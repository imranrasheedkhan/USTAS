package com.ustas.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.richfaces.component.UIDataTable;

import com.ustas.application.managedbean.ApplicationBean;
import com.ustas.db.dao.EmpLeaveAllotmentDAO;
import com.ustas.db.model.EmpInfo;
import com.ustas.db.model.EmpLeaveAllotment;
import com.ustas.db.model.LeaveInfo;
import com.ustas.view.model.EmpLeaveAllotmentViewModel;

@ManagedBean
@ViewScoped
public class EmpLeaveAllotmentMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 //.............injection
	   
	   @PersistenceContext(unitName="USTAS")
	    EntityManager em;
	    
	    @Resource
	    UserTransaction ut;
    
    
    
    //.............Application bean
    @ManagedProperty(value="#{ApplicationBean}")
	private ApplicationBean appBean;
    
    public EmpLeaveAllotmentMB()
      {
    	
      dao=new EmpLeaveAllotmentDAO(em); 
      rowList.clear();

   // 	selectLeaveTypeList();
      }
    Map<Integer,Boolean> rowList=new HashMap<>();
    private  EmpLeaveAllotmentDAO dao ;
    private EmpLeaveAllotmentViewModel model=new EmpLeaveAllotmentViewModel();

	public ApplicationBean getAppBean() {
		return appBean;
	}
	public void setAppBean(ApplicationBean appBean) {
		this.appBean = appBean;
	}
	public EmpLeaveAllotmentDAO getDao() {
		return dao;
	}
	public void setDao(EmpLeaveAllotmentDAO dao) {
		this.dao = dao;
	}
	public EmpLeaveAllotmentViewModel getModel() {
		return model;
	}
	public void setModel(EmpLeaveAllotmentViewModel model) {
		this.model = model;
	}
    
    
	
     public void selectLeaveTypeList()
	      {
		     System.out.println("In the leave Allotment");
		     List<LeaveInfo> list=dao.selectLeaveType(em, ut);
		      for(LeaveInfo leaveInfo:list)
		        {
			      model.getLeaveTypeList().add(new SelectItem(leaveInfo.getIndexNo(),leaveInfo.getShortName()));
		        }
		       model.setLeaveInfoList(list);
		   
	      }
     
     @PostConstruct
     public void selectEmployees()    
        {   
    	   System.out.println("In the Select Employee");
    	   model.setEmpList(dao.selectemployees(model.getEmpLeaveAllotmnet().getForYear(),em, ut));
    	   this.selectLeaveTypeList();
        }    
        
          public void selectLeaveEmployee()
                {
					System.out.println("In the Select Employee");
			       
			//		UIDataTable data = (UIDataTable) e.getComponent().findComponent("empList_table");
			//		int rowIndex = data.getRowIndex();
			//		rowList.put(rowIndex, (boolean) e.getNewValue());
			//		EmpInfo empInfo = model.getEmpList().get(rowIndex);
			//    	empInfo.setFlag( (boolean) e.getNewValue());
					selectLeaveTypeList();
					int allotedSize = model.getEmpInfo().getEmpLeaveAllotment().size();
					List<EmpLeaveAllotment> tempList = new ArrayList<>();
					for (int i = 0; i < allotedSize; i++) {
						EmpLeaveAllotment leaveAllotment = model.getEmpInfo().getEmpLeaveAllotment().get(i);
						for (LeaveInfo leaveInfo : model.getLeaveInfoList()) {
							if (leaveAllotment.getLeaveInfos().getIndexNo() == leaveInfo.getIndexNo()
									&& leaveAllotment.getForYear() == model.getEmpLeaveAllotmnet().getForYear()) {
								   model.getLeaveInfoList().remove(leaveInfo);
								  break;
							 }
							if (leaveAllotment.getForYear() != model.getEmpLeaveAllotmnet().getForYear()) {
								tempList.add(leaveAllotment);
								break;
							}
						}
			
					}
					model.getEmpInfo().getEmpLeaveAllotment().removeAll(tempList);
					for (LeaveInfo leaveInfo : model.getLeaveInfoList()) {
						EmpLeaveAllotment newLeaveAllot = new EmpLeaveAllotment();
						newLeaveAllot.setEmpInfo(model.getEmpInfo());
						newLeaveAllot.setLeaveInfos(leaveInfo);
						newLeaveAllot.setForYear(model.getEmpLeaveAllotmnet().getForYear());
						model.getEmpInfo().getEmpLeaveAllotment().add(newLeaveAllot);
					}
		    	//	model.getEmpList().remove(rowIndex);
			//		model.setEmpInfo(empInfo);
			//       model.getEmpList().add(rowIndex, empInfo);
//				  for(Integer i: rowList.keySet())
//				    {
//					   model.getEmpList().get(i).setFlag(rowList.get(i));
//				    }
    	         model.setTempLeaveAlloment(model.getEmpInfo().getEmpLeaveAllotment());	  

          }
      
      public void addAllotedLeave() 
         {  
    	  System.out.println("In the Leave Allotment");
    	  for(EmpInfo empInfo:model.getEmpList())
    	    { 
    		   if(empInfo.isFlag())     
    		    {
    			     
    	             dao.addAllotedLeave(empInfo, em, ut);
    		    }
    	      
    	    }
    	    String message = appBean.applicationPropreties.getProperty("LEAVE_SUCCESS");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
		
			selectEmployees();
    	   
        }
      
      public void allotAllEmployee()
        {
    	 
    	    System.out.println("In the Listene");  
    	     
//    	    UIDataTable data = (UIDataTable) e.getComponent().findComponent("dataTable");
//	        int rowIndex = data.getRowIndex();
//	        int days=(int) e.getNewValue();
//	        EmpLeaveAllotment leaveAlloted =model.getEmpInfo().getEmpLeaveAllotment().get(rowIndex);
    	  
        }  
    
 
}
