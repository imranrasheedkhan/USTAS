package com.ustas.managedbeans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.ustas.application.managedbean.ApplicationBean;
import com.ustas.db.dao.AttendanceProcessDAO;
import com.ustas.db.model.EmpAttendanceProcess;
import com.ustas.db.model.EmpInfo;
import com.ustas.db.model.EmpShiftAllotment;
import com.ustas.helper.FileUtil;
import com.ustas.view.model.AttendanceProcessViewModel;

@ManagedBean
@ViewScoped
public class AttendanceProcessMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	  
	  //.............injection
	   
	    @PersistenceContext(unitName="USTAS")
	    EntityManager em;
	    
	    @Resource
	    UserTransaction ut;
	       
	    
	    
	    //.............Application bean
	    @ManagedProperty(value="#{ApplicationBean}")  
		private ApplicationBean appBean;
	    
	    public AttendanceProcessMB()  
	     {
	    	dao=new AttendanceProcessDAO(em);
	    	model.buildMonthOptions();
	     }  
	    
	    private AttendanceProcessDAO dao;
	    
	    private AttendanceProcessViewModel model=new AttendanceProcessViewModel();
	    
	      
	    
	  public ApplicationBean getAppBean() {
			return appBean;
		}



		public void setAppBean(ApplicationBean appBean) {
			this.appBean = appBean;
		}



		public AttendanceProcessViewModel getModel() {
			return model;
		}



		public void setModel(AttendanceProcessViewModel model) {
			this.model = model; 
		}



		//...........view the detail  
	    public void  viewAttendanceDetail()
	         {
	    	   System.out.println("Attendance detail");
	    	   model.setAttendanceList(dao.viewAttendanceDetail(model.getSerchEmpNo(), model.getMonth(),model.getSearchDate(), em, ut));
	         }
	    
	    
	     public  void processAttendance()
	       {
	    	    System.out.println("In the Attendance Process");
	    	    String server=appBean.applicationPropreties.getProperty("server");
	    	    String port=appBean.applicationPropreties.getProperty("port");
	    	    String user=appBean.applicationPropreties.getProperty("userName");
	    	    String password=appBean.applicationPropreties.getProperty("passWord");
	    	    String unsyncPath=appBean.applicationPropreties.getProperty("UNSYNC_FILE_PATH");
	    	    String syncPath=appBean.applicationPropreties.getProperty("SYNC_FILE_PATH");
	    	    FileUtil.downloadAttendanceFile(server,Integer.parseInt(port),user,password,unsyncPath);
	    	    File sourceFile=new File(unsyncPath+File.separator+"attendance.txt");
	   // 	    File sourceFile=new File("D:"+File.separator+"AttendanceProcess"+File.separator+"Unsynchronized"+File.separator+"attendance.txt");
	    	    String[] ar = null ;
	    	    try {
	                BufferedReader in = new BufferedReader(new FileReader(sourceFile));
	                String str;
	                str = in.readLine();  
	                while ((str = in.readLine()) != null) {  
	                    System.out.println(str); 
	                    ar=str.split(",");
	                    importAttendance(ar);
	                 }
	             
	                in.close();
	               } catch (IOException e) {
	                System.out.println("File Read Error");
	             }
	    	    String message = appBean.applicationPropreties.getProperty("ATTENDANCE_SUCCESS");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
		        Date toDay=new Date();
		        SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
			//	File dir = new File("D:"+File.separator+"AttendanceProcess"+File.separator+"Synchronized");
				File dir = new File(syncPath);
				dir.mkdir();
                File targetFile=new File(dir,df.format(toDay)+"_"+sourceFile.getName());
                FileInputStream inStream;
                FileOutputStream outStream;
                try{
                	inStream = new FileInputStream(sourceFile);
             	    outStream = new FileOutputStream(targetFile);
          
             	    byte[] buffer = new byte[1024];
          
             	    int length;
             	 
             	    while ((length = inStream.read(buffer)) > 0){
          
             	    	outStream.write(buffer, 0, length);
          
             	    }
          
             	       inStream.close();
             	       outStream.close();
                     }catch(FileNotFoundException e){ 
                   
                	  System.out.println("File Not Found Exception "+e.getMessage());
                        }catch(IOException e){ 
               
         	               System.out.println("Input output Exceptuion"+e.getMessage());
                         }
                    sourceFile.delete();
                }
	        
	          
	        
	     

	       private void importAttendance(String [] data)
	           {
	    	    List<EmpInfo> empList=dao.selectAllEmployee(em, ut);
	    	    DateFormat df = new SimpleDateFormat("dd-MM-yyy");
	    	    List <EmpAttendanceProcess> attendanceList=new ArrayList<>();
	    	     try {
	    	      for(EmpInfo empInfo:empList)
	    	        {
	    		     if(empInfo.getEmpNo().equalsIgnoreCase(data[0]))
	    		       {
					    EmpAttendanceProcess attenDance = new EmpAttendanceProcess();
					    attenDance.setForDate(df.parse(data[1]));
					    attenDance.setInTime(Time.valueOf(data[2]));
					    attenDance.setOutTime(Time.valueOf(data[3]));  
					    attenDance.setStatus("P");
					    attenDance.setShiftAllotments(empCurrentShiftDetail(empInfo, attenDance.getForDate()));
					    attenDance.setProcessDate(new Date());    
					    attenDance.setEmpInfo(empInfo);
					    attendanceList.add(attenDance);
					    empInfo.setEmpAttendanceProcess(attendanceList);
					    dao.processAttendance(em, ut, empInfo);
		    		    break;
	    		       }
	    		     
	    		       
	    	         }
	    		   } catch (ParseException e) {
				
					e.printStackTrace();
				  }
	          }
	       
	       private EmpShiftAllotment empCurrentShiftDetail(EmpInfo empInfo,Date attendanceDate)
	          {
			    EmpShiftAllotment shiftAlloted=null;
	    	    for(EmpShiftAllotment currentShift:empInfo.getEmpShiftAllotments())
	    	       {
	    	    	 if(attendanceDate.after(currentShift.getFromDate()) && attendanceDate.before(currentShift.getToDate()))
	    	    		shiftAlloted=currentShift;		
	    	    		
	    	       }  
	    	   
	    	      return shiftAlloted;
	    	   
	          }
   
}  
