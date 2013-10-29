package com.ustas.view.model;

import java.io.Serializable;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.zip.DataFormatException;

import com.sun.tools.ws.processor.model.Model;
import com.ustas.db.model.BreakInfo;

public class BreakMasterViewModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private BreakInfo breakInfo = new BreakInfo();
	
	private String searchKey;
	
	
	public BreakInfo getBreakInfo() {
		return breakInfo;
	}


	public void setBreakInfo(BreakInfo breakInfo) {
		this.breakInfo = breakInfo;
	}

 private int starttimehr;
 
 private int starttimemin;
 
 private int starttimesec;
 
 private int endtimehr;
 
 private int endtimemin;
 
 private int endtimesec;

public int getStarttimehr() {
	return starttimehr;
}


public void setStarttimehr(int starttimehr) {
	this.starttimehr = starttimehr;
}


public int getStarttimemin() {
	return starttimemin;
}


public void setStarttimemin(int starttimemin) {
	this.starttimemin = starttimemin;
}


public int getStarttimesec() {
	return starttimesec;
}


public void setStarttimesec(int starttimesec) {
	this.starttimesec = starttimesec;
}


public int getEndtimehr() {
	return endtimehr;
}


public void setEndtimehr(int endtimehr) {
	this.endtimehr = endtimehr;
}


public int getEndtimemin() {
	return endtimemin;
}


public void setEndtimemin(int endtimemin) {
	this.endtimemin = endtimemin;
}


public int getEndtimesec() {
	return endtimesec;
}


public void setEndtimesec(int endtimesec) {
	this.endtimesec = endtimesec;
}
	

public String getSearchKey() {
	return searchKey;
}


public void setSearchKey(String searchKey) {
	this.searchKey = searchKey;
}

private List<BreakInfo>  breakList=new  ArrayList<BreakInfo>();

public List<BreakInfo> getBreakList() {
	return breakList;
}


public void setBreakList(List<BreakInfo> breakList) {
	this.breakList = breakList;
}

public void consolidateBreak(BreakInfo breakinfo) throws ParseException 

{
System.out.println("hello");

	
	String tempstartTime=Integer.toString(this.starttimehr)+":"+Integer.toString(this.starttimemin)+":"+Integer.toString(this.starttimesec);
	String tempendtime=Integer.toString(this.endtimehr)+":"+Integer.toString(this.endtimemin)+":"+Integer.toString(this.endtimesec);
    try
    {
    	DateFormat df = new SimpleDateFormat("HH:mm:ss");
    	Date startTime=(Date) df.parse(tempstartTime);
	    Date endTime=(Date) df.parse(tempendtime);
	    
	    breakinfo.setStartTime(new Time(startTime.getTime()));
	    breakinfo.setEndTime(new Time(endTime.getTime()));
	    
	     String STARTtime = null;
	     String ENDtime = null;
		 SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		 Date STARTTIME = format.parse(STARTtime);
		 Date ENDTIME = format.parse(ENDtime);
	    long totalBreakTime = ENDTIME.getTime()-STARTTIME.getTime();
	    
	    System.out.println("result"+totalBreakTime);
	        
      }catch(Exception e){e.getStackTrace();
    
    }

   
    
   
    }	
         
  public void breakBreakObjects(BreakInfo breakInfo)
   {
	  this.starttimehr=breakInfo.getStartTime().getHours();
	  this.starttimemin=breakInfo.getStartTime().getMinutes();
	  this.starttimesec=breakInfo.getStartTime().getSeconds();
	  this.endtimehr=breakInfo.getEndTime().getHours();
	  this.endtimemin=breakInfo.getEndTime().getMinutes();
	  this.endtimesec=breakInfo.getEndTime().getSeconds();
   }
  
  public void clearBreak()
   {
	  starttimehr=0;
	  starttimemin=0;
	  starttimesec=0;
	  endtimehr=0;
	  endtimemin=0;
	  endtimesec=0;
	  
   }
  
 
  public void totalBreakTime(BreakInfo breakInfo) 
   {
	   Date totalTime = new Date() ;
	   String  totalTimes=Integer.toString(breakInfo.getEndTime().getHours()-breakInfo.getStartTime().getHours())+
			  ":"+Integer.toString(breakInfo.getEndTime().getMinutes()-breakInfo.getStartTime().getMinutes())+
			  ":"+Integer.toString(breakInfo.getEndTime().getSeconds()-breakInfo.getStartTime().getSeconds());
	  
	   try
	     {
	    	DateFormat df = new SimpleDateFormat("HH:mm:ss");
	    	totalTime=(Date) df.parse(totalTimes);
	    	
	      }catch(ParseException e){
	    	 
	    	 System.out.println("Parse Exception" +e.getStackTrace());
	      }
	      breakInfo.setTotalTime(new Time(totalTime.getTime()));

     }
}
