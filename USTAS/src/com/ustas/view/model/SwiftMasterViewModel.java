package com.ustas.view.model;

import java.io.Serializable;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.component.UIDataTable;

import com.ustas.db.model.BreakInfo;
import com.ustas.db.model.ShiftInfo;

public class SwiftMasterViewModel implements Serializable {
	   
	private static final long serialVersionUID = 1L;




	public    SwiftMasterViewModel(){
		   
	    }
	  
	
	private  ShiftInfo shiftInfo=new ShiftInfo();
	   
    private  BreakInfo breakInfo=new BreakInfo();
        
    
   
    
	public ShiftInfo getShiftInfo() {
		return shiftInfo;
	}

	public void setShiftInfo(ShiftInfo shiftInfo) {
		this.shiftInfo = shiftInfo;
	}

	public BreakInfo getBreakInfo() {
		return breakInfo;
	}

	public void setBreakInfo(BreakInfo breakInfo) {
		this.breakInfo = breakInfo;
	}
	   
	   
 // to store the time information..
    
    private int inTimeHr;
    
    private int inTimeMin;
    
    private int inTimeSec;
    
    private int outTimeHr;
    
    private int outTimeMin;
    
    private int outTimeSec;
    
    private int overTimeHr;
    
    private int overTimeMin;
    
    private int overTimeSec ;




	public int getInTomeHr() {
		return inTimeHr;
	}

	public void setInTomeHr(int inTomeHr) {
		this.inTimeHr = inTomeHr;
	}

	public int getInTimeMin() {
		return inTimeMin;
	}

	public void setInTimeMin(int inTimeMin) {
		this.inTimeMin = inTimeMin;
	}

	public int getInTimeSec() {
		return inTimeSec;
	}

	public void setInTimeSec(int inTimeSec) {
		this.inTimeSec = inTimeSec;
	}

	public int getOutTimeHr() {
		return outTimeHr;
	}

	public void setOutTimeHr(int outTimeHr) {
		this.outTimeHr = outTimeHr;
	}

	public int getOutTimeMin() {
		return outTimeMin;
	}

	public void setOutTimeMin(int outTimeMin) {
		this.outTimeMin = outTimeMin;
	}

	public int getOutTimeSec() {
		return outTimeSec;
	}

	public void setOutTimeSec(int outTimeSec) {
		this.outTimeSec = outTimeSec;
	}

	public int getOverTimeHr() {
		return overTimeHr;
	}

	public void setOverTimeHr(int overTimeHr) {
		this.overTimeHr = overTimeHr;
	}

	public int getOverTimeMin() {
		return overTimeMin;
	}

	public void setOverTimeMin(int overTimeMin) {
		this.overTimeMin = overTimeMin;
	}

	public int getOverTimeSec() {
		return overTimeSec;
	}

	public void setOverTimeSec(int overTimeSec) {
		this.overTimeSec = overTimeSec;
	}
	   
	 // to store the  weekoff details..
	private boolean monWeekOff;
	
	private boolean tueWeekOff;
	
	private boolean wedWeekOff;
	
	private boolean thursWeekOff;
	
	private boolean friWeekOff;
	
	private boolean satWeekOff;
	
	private boolean sunWeekOff;




	public boolean isMonWeekOff() {
		return monWeekOff;
	}

	public void setMonWeekOff(boolean monWeekOff) {
		this.monWeekOff = monWeekOff;
	}

	public boolean isTueWeekOff() {
		return tueWeekOff;
	}

	public void setTueWeekOff(boolean tueWeekOff) {
		this.tueWeekOff = tueWeekOff;
	}

	public boolean isWedWeekOff() {
		return wedWeekOff;
	}

	public void setWedWeekOff(boolean wedWeekOff) {
		this.wedWeekOff = wedWeekOff;
	}

	public boolean isThursWeekOff() {
		return thursWeekOff;
	}

	public void setThursWeekOff(boolean thursWeekOff) {
		this.thursWeekOff = thursWeekOff;
	}

	public boolean isFriWeekOff() {
		return friWeekOff;
	}

	public void setFriWeekOff(boolean friWeekOff) {
		this.friWeekOff = friWeekOff;
	}

	public boolean isSatWeekOff() {
		return satWeekOff;
	}

	public void setSatWeekOff(boolean satWeekOff) {
		this.satWeekOff = satWeekOff;
	}

	public boolean isSunWeekOff() {
		return sunWeekOff;
	}

	public void setSunWeekOff(boolean sunWeekOff) {
		this.sunWeekOff = sunWeekOff;
	}
	
	 // AlterNate week off.
	
    private boolean mondayAlternateOFF; 
	
	private boolean tueAlternateOFF;
	
	private boolean wedAlternateOFF;
	
	private boolean thursAlternateOFF;
	
	private boolean friAlternateOFF;
	
	private boolean satAlternateOFF;
	
	private boolean sunAlternateOFF;




	

	public boolean isMondayAlternateOFF() {
		return mondayAlternateOFF;
	}

	public void setMondayAlternateOFF(boolean mondayAlternateOFF) {
		this.mondayAlternateOFF = mondayAlternateOFF;
	}

	public boolean isTueAlternateOFF() {
		return tueAlternateOFF;
	}

	public void setTueAlternateOFF(boolean tueAlternateOFF) {
		this.tueAlternateOFF = tueAlternateOFF;
	}

	public boolean isWedAlternateOFF() {
		return wedAlternateOFF;
	}

	public void setWedAlternateOFF(boolean wedAlternateOFF) {
		this.wedAlternateOFF = wedAlternateOFF;
	}

	public boolean isThursAlternateOFF() {
		return thursAlternateOFF;
	}

	public void setThursAlternateOFF(boolean thursAlternateOFF) {
		this.thursAlternateOFF = thursAlternateOFF;
	}

	public boolean isFriAlternateOFF() {
		return friAlternateOFF;
	}

	public void setFriAlternateOFF(boolean friAlternateOFF) {
		this.friAlternateOFF = friAlternateOFF;
	}

	public boolean isSatAlternateOFF() {
		return satAlternateOFF;
	}

	public void setSatAlternateOFF(boolean satAlternateOFF) {
		this.satAlternateOFF = satAlternateOFF;
	}

	public boolean isSunAlternateOFF() {
		return sunAlternateOFF;
	}

	public void setSunAlternateOFF(boolean sunAlternateOFF) {
		this.sunAlternateOFF = sunAlternateOFF;
	}
	
	 //........................break List..................
	
	List<BreakInfo>  breakList=new  ArrayList<BreakInfo>();
	
	List<SelectItem>  breakSelectItemList=new  ArrayList<SelectItem>();

	 //........................Shift Detail List..................
   
	 private List<ShiftInfo> shiftDetailList=new ArrayList<>();
     
	 //........................Search..................
	 
	 private String searchShift;
	 
	 
	 
	public String getSearchShift() {
		return searchShift;
	}

	public void setSearchShift(String searchShift) {
		this.searchShift = searchShift;
	}

	public List<ShiftInfo> getShiftDetailList() {
		return shiftDetailList;
	}

	public void setShiftDetailList(List<ShiftInfo> shiftDetailList) {
		this.shiftDetailList = shiftDetailList;
	}

	public List<BreakInfo> getBreakList() {
		return breakList;
	}

	public void setBreakList(List<BreakInfo> breakList) {
		this.breakList = breakList;
	}

	public List<SelectItem> getBreakSelectItemList() {
		return breakSelectItemList;
	}

	public void setBreakSelectItemList(List<SelectItem> breakSelectItemList) {
		this.breakSelectItemList = breakSelectItemList;
	}
	
	 //........................row number..................
	


	public void consolidateShift(ShiftInfo shiftInfo) 
    	{
		  
		  shiftInfo.setBreakInfo(breakList);
		  String tempIntime=Integer.toString(this.inTimeHr)+":"+Integer.toString(this.inTimeMin)+":"+Integer.toString(this.inTimeMin);
		  String tempOuttime=Integer.toString(this.outTimeHr)+":"+Integer.toString(outTimeMin)+":"+Integer.toString(outTimeSec);
		  String tempOvertime=Integer.toString(overTimeHr)+":"+Integer.toString(overTimeMin)+":"+Integer.toString(overTimeSec);
		  try
		  {
		      DateFormat df = new SimpleDateFormat("HH:mm:ss");
		      Date inTime=(Date) df.parse(tempIntime); 
		      Date outTime=(Date) df.parse(tempOuttime);
		      Date overTime=(Date) df.parse(tempOvertime);
		      shiftInfo.setInTime(new Time(inTime.getTime()));
		      shiftInfo.setOutTime(new Time(outTime.getTime()));
		      shiftInfo.setOvertimeLimit(new Time(overTime.getTime()));
		  
		   }catch(Exception e){e.getStackTrace();}
		  
		  if(this.monWeekOff==true )
		   {
			  if(shiftInfo.getWeekOfDay1()==null)
			    shiftInfo.setWeekOfDay1("Monday");
			  if(shiftInfo.getWeekOfDay2()==null && shiftInfo.getWeekOfDay1()!=null && !(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Monday")))
			    shiftInfo.setWeekOfDay2("Monday");
		      if(shiftInfo.getWeekOfDay3()==null && shiftInfo.getWeekOfDay1()!=null && !(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Monday"))
		    		  && shiftInfo.getWeekOfDay2()!=null && !(shiftInfo.getWeekOfDay2().equalsIgnoreCase("Monday")))
				shiftInfo.setWeekOfDay3("Monday");
		   }
		  if(this.tueWeekOff==true)
		   {
			  if(shiftInfo.getWeekOfDay1()==null)    
			   shiftInfo.setWeekOfDay1("Tuesday");
			  
			  if(shiftInfo.getWeekOfDay2()==null && shiftInfo.getWeekOfDay1()!=null && !(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Tuesday")))
			   shiftInfo.setWeekOfDay2("Tuesday");
			  
			  if(shiftInfo.getWeekOfDay3()==null && shiftInfo.getWeekOfDay1()!=null && !(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Tuesday"))
					  && shiftInfo.getWeekOfDay2()!=null && !(shiftInfo.getWeekOfDay2().equalsIgnoreCase("Tuesday")))
				shiftInfo.setWeekOfDay3("Tuesday");
			 
			 
		    }
		  if(this.wedWeekOff==true)
		      {
			      if(shiftInfo.getWeekOfDay1()==null)
				   shiftInfo.setWeekOfDay1("Wednesday");
				  
				  if(shiftInfo.getWeekOfDay2()==null && shiftInfo.getWeekOfDay1()!=null && !(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Wednesday")) )
				   shiftInfo.setWeekOfDay2("Wednesday");
				  
				  if(shiftInfo.getWeekOfDay3()==null && shiftInfo.getWeekOfDay1()!=null && !(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Wednesday"))
						  && shiftInfo.getWeekOfDay2()!=null && !(shiftInfo.getWeekOfDay2().equalsIgnoreCase("Wednesday")))
				    shiftInfo.setWeekOfDay3("Wednesday");
		      }
		  if(this.thursWeekOff==true)
		     {
			      if(shiftInfo.getWeekOfDay1()==null)
				   shiftInfo.setWeekOfDay1("Thursday");
				  
				  if(shiftInfo.getWeekOfDay2()==null && shiftInfo.getWeekOfDay1()!=null && !(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Thursday")) )
				   shiftInfo.setWeekOfDay2("Thursday");
				  
				  if(shiftInfo.getWeekOfDay3()==null && shiftInfo.getWeekOfDay1()!=null && !(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Thursday"))
						  && shiftInfo.getWeekOfDay2()!=null && !(shiftInfo.getWeekOfDay2().equalsIgnoreCase("Thursday")))
				    shiftInfo.setWeekOfDay3("Thursday");
		     }
		   if(this.friWeekOff==true)
		     {
			      if(shiftInfo.getWeekOfDay1()==null)
				   shiftInfo.setWeekOfDay1("Friday");
				  
				  if(shiftInfo.getWeekOfDay2()==null && shiftInfo.getWeekOfDay1()!=null && !(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Friday")))
				   shiftInfo.setWeekOfDay2("Friday");
				  
				  if(shiftInfo.getWeekOfDay3()==null && shiftInfo.getWeekOfDay1()!=null &&  !(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Friday"))
						  && shiftInfo.getWeekOfDay2()!=null && !(shiftInfo.getWeekOfDay2().equalsIgnoreCase("Friday")))
				    shiftInfo.setWeekOfDay3("Friday");
		     }
		   if(this.satWeekOff==true)
		     {
			      if(shiftInfo.getWeekOfDay1()==null )
				   shiftInfo.setWeekOfDay1("Saturday");
				  
				  if(shiftInfo.getWeekOfDay2()==null && shiftInfo.getWeekOfDay1()!=null &&  !(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Saturday"))) 
				   shiftInfo.setWeekOfDay2("Saturday");
				  
				  if(shiftInfo.getWeekOfDay3()==null && shiftInfo.getWeekOfDay1()!=null &&  !(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Saturday"))
						  && shiftInfo.getWeekOfDay2()!=null &&  !(shiftInfo.getWeekOfDay2().equalsIgnoreCase("Saturday")))
				    shiftInfo.setWeekOfDay3("Saturday");
		     }
		   if(this.sunWeekOff==true)
		     {
			      if(shiftInfo.getWeekOfDay1()==null)
				   shiftInfo.setWeekOfDay1("Sunday");
				  
				  if(shiftInfo.getWeekOfDay2()==null && shiftInfo.getWeekOfDay1()!=null &&  !(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Sunday")) )
				   shiftInfo.setWeekOfDay2("Sunday");
				  
				  if(shiftInfo.getWeekOfDay3()==null  && shiftInfo.getWeekOfDay1()!=null && !(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Sunday"))
						  && shiftInfo.getWeekOfDay2()!=null && !(shiftInfo.getWeekOfDay2().equalsIgnoreCase("Sunday")))
				    shiftInfo.setWeekOfDay3("Sunday");
		     }
		   if(this.mondayAlternateOFF && shiftInfo.getAlternateWeekOff()==null)
		       shiftInfo.setAlternateWeekOff("Monday");
		   
		   if(this.tueAlternateOFF && shiftInfo.getAlternateWeekOff()==null)
			  shiftInfo.setAlternateWeekOff("Tuesday");  
		   if(this.wedAlternateOFF && shiftInfo.getAlternateWeekOff()==null)
			  shiftInfo.setAlternateWeekOff("Wednesday");
		   if(this.thursAlternateOFF && shiftInfo.getAlternateWeekOff()==null)
			  shiftInfo.setAlternateWeekOff("Thursday");
		    if(this.friAlternateOFF && shiftInfo.getAlternateWeekOff()==null)
			  shiftInfo.setAlternateWeekOff("Friday");
		   if(this.satAlternateOFF && shiftInfo.getAlternateWeekOff()==null)
			  shiftInfo.setAlternateWeekOff("Saturday");
		    if(this.sunAlternateOFF && shiftInfo.getAlternateWeekOff()==null)
			  shiftInfo.setAlternateWeekOff("Sunday");
		  
	    }
	
	public void breakShift()  
	  {
		 inTimeHr=shiftInfo.getInTime().getHours();
		 inTimeMin=shiftInfo.getInTime().getMinutes();
		 inTimeSec=shiftInfo.getInTime().getSeconds();
		 outTimeHr=shiftInfo.getOutTime().getHours();
		 outTimeMin=shiftInfo.getOutTime().getMinutes();
		 outTimeSec=shiftInfo.getOutTime().getSeconds();
		 overTimeHr=shiftInfo.getOvertimeLimit().getHours();
		 overTimeMin=shiftInfo.getOvertimeLimit().getMinutes();
		 overTimeSec=shiftInfo.getOvertimeLimit().getSeconds();
		 if(shiftInfo.getWeekOfDay1()!=null);
		  {
			 if(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Monday"))
			  monWeekOff=true;
			 if(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Tuesday"))
			  tueWeekOff=true;
			 if(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Wednesday"))
			 wedWeekOff=true;
			 if(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Thursday"))
			 thursWeekOff=true;
			 if(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Friday"))
			 friWeekOff=true;
			 if(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Saturday"))
			 satWeekOff=true;
			 if(shiftInfo.getWeekOfDay1().equalsIgnoreCase("Sunday"))
			 sunWeekOff=true;
			 
			 shiftInfo.setWeekOfDay1(null);
			  
		  }
		  
		  if(shiftInfo.getWeekOfDay2()!=null)
		  {
			 if(shiftInfo.getWeekOfDay2().equalsIgnoreCase("Monday"))
			  monWeekOff=true;
			 if(shiftInfo.getWeekOfDay2().equalsIgnoreCase("Tuesday"))
			  tueWeekOff=true;
			 if(shiftInfo.getWeekOfDay2().equalsIgnoreCase("Wednesday"))
			 wedWeekOff=true;  
			 if(shiftInfo.getWeekOfDay2().equalsIgnoreCase("Thursday"))
			 thursWeekOff=true;
			 if(shiftInfo.getWeekOfDay2().equalsIgnoreCase("Friday"))
			 friWeekOff=true;
			 if(shiftInfo.getWeekOfDay2().equalsIgnoreCase("Saturday"))
			 satWeekOff=true;
			 if(shiftInfo.getWeekOfDay2().equalsIgnoreCase("Sunday"))
			 sunWeekOff=true;
			 
			 shiftInfo.setWeekOfDay2(null);
			  
		  }
		  
		  if(shiftInfo.getWeekOfDay3()!=null)
		  {
			 if(shiftInfo.getWeekOfDay3().equalsIgnoreCase("Monday"))
			  monWeekOff=true;
			 if(shiftInfo.getWeekOfDay3().equalsIgnoreCase("Tuesday"))
			  tueWeekOff=true;
			 if(shiftInfo.getWeekOfDay3().equalsIgnoreCase("Wednesday"))
			 wedWeekOff=true;
			 if(shiftInfo.getWeekOfDay3().equalsIgnoreCase("Thursday"))
			 thursWeekOff=true;
			 if(shiftInfo.getWeekOfDay3().equalsIgnoreCase("Friday"))
			 friWeekOff=true;
			 if(shiftInfo.getWeekOfDay3().equalsIgnoreCase("Saturday"))
			 satWeekOff=true;
			 if(shiftInfo.getWeekOfDay3().equalsIgnoreCase("Sunday"))
			 sunWeekOff=true;
			 shiftInfo.setWeekOfDay3(null);
			  
		  }
		  if(shiftInfo.getAlternateWeekOff()!=null && shiftInfo.getAlternateWeekOff().equalsIgnoreCase("Monday"))
			  mondayAlternateOFF=true;
		  if( shiftInfo.getAlternateWeekOff()!=null &&shiftInfo.getAlternateWeekOff().equalsIgnoreCase("Tuesday"))
			  tueAlternateOFF=true;
		  if( shiftInfo.getAlternateWeekOff()!=null &&shiftInfo.getAlternateWeekOff().equalsIgnoreCase("Wednesday"))
			  wedAlternateOFF=true;
		  if(shiftInfo.getAlternateWeekOff()!=null &&shiftInfo.getAlternateWeekOff().equalsIgnoreCase("Thursday"))
			 thursAlternateOFF=true;
		  if( shiftInfo.getAlternateWeekOff()!=null &&shiftInfo.getAlternateWeekOff().equalsIgnoreCase("Friday"))
			 friAlternateOFF=true;
		  if( shiftInfo.getAlternateWeekOff()!=null &&shiftInfo.getAlternateWeekOff().equalsIgnoreCase("Saturday"))
				 satWeekOff=true;
		  if(shiftInfo.getAlternateWeekOff()!=null &&shiftInfo.getAlternateWeekOff().equalsIgnoreCase("Sunday"))
				 sunAlternateOFF=true;
		  if(shiftInfo.getBreakInfo()!=null) 
		   setBreakList(shiftInfo.getBreakInfo());
		   
		  shiftInfo.setAlternateWeekOff(null);
		 
	  }
	 
	
	public void clearShiftDetail()
	  {
		       inTimeHr=0;
		       inTimeMin=0; 
		       inTimeSec=0;  
		       outTimeHr=0;
		       outTimeMin=0;
	           outTimeSec=0;
		       overTimeHr=0;
		       overTimeMin=0;
		       overTimeSec =0;
		       mondayAlternateOFF=false; 
		   	   tueAlternateOFF=false;
		   	   wedAlternateOFF=false;
		   	   thursAlternateOFF=false;
		   	   friAlternateOFF=false;
		   	   satAlternateOFF=false;
		   	   sunAlternateOFF=false;
		   	   monWeekOff=false;
			   tueWeekOff=false;
			   wedWeekOff=false;
			   thursWeekOff=false;
			   friWeekOff=false;
			   satWeekOff=false;
			   sunWeekOff=false;
	           shiftInfo=new ShiftInfo();
			   breakList=new ArrayList<>();
			   
		
	  }
	
	
	

}
