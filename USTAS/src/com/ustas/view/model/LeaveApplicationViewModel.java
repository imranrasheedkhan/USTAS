package com.ustas.view.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.securityRoleRefType;
import com.ustas.db.model.EmpInfo;
import com.ustas.db.model.EmpLeaveAllotment;
import com.ustas.db.model.EmpLeaveAppEntry;
import com.ustas.db.model.LeaveInfo;

public class LeaveApplicationViewModel implements Serializable {
	private static final long serialVersionUID = 1L;
	

	
	
	private EmpLeaveAppEntry leaveApplication=new EmpLeaveAppEntry(); 
	
	private LeaveInfo leaveInfo=new LeaveInfo();
	
	private LeaveInfo selectedLeave=new LeaveInfo();
	
	public LeaveInfo getSelectedLeave() {
		return selectedLeave;
	}

	public void setSelectedLeave(LeaveInfo selectedLeave) {
		this.selectedLeave = selectedLeave;
	}

    private boolean isApprove;

	private EmpLeaveAllotment leaveAllotment=new EmpLeaveAllotment();
	
	private EmpInfo  empInfo=new EmpInfo();
	
	private EmpInfo approveBy=new EmpInfo();
	
	//...............leave info.......
	
	private float totalLeave;
	
	private float leaveTaken;
	
	private float remainingLeave; 
	
	private float unpaidays;
	
	private String empNo;
	
	private List<SelectItem> leaveTypeList=new ArrayList<>();
	
	
	private List<EmpLeaveAppEntry> leaveApplyList=new ArrayList<>();
	
	// mail object
	
	
	

	public float getTotalLeave() {
		return totalLeave;
	}

	public boolean isApprove() {
		return isApprove;
	}

	public void setApprove(boolean isApprove) {
		this.isApprove = isApprove;
	}

	public void setTotalLeave(float totalLeave) {
		this.totalLeave = totalLeave;
	}

	public float getLeaveTaken() {
		return leaveTaken;
	}

	public void setLeaveTaken(float leaveTaken) {
		this.leaveTaken = leaveTaken;
	}

	public float getRemainingLeave() {
		return remainingLeave;
	}

	public void setRemainingLeave(float remainingLeave) {
		this.remainingLeave = remainingLeave;
	}

	public EmpLeaveAppEntry getLeaveApplication() {
		return leaveApplication;
	}

	public void setLeaveApplication(EmpLeaveAppEntry leaveApplication) {
		this.leaveApplication = leaveApplication;
	}

	public LeaveInfo getLeaveInfo() {
		return leaveInfo;
	}

	public void setLeaveInfo(LeaveInfo leaveInfo) {
		this.leaveInfo = leaveInfo;
	}

	public EmpLeaveAllotment getLeaveAllotment() {
		return leaveAllotment;
	}

	public void setLeaveAllotment(EmpLeaveAllotment leaveAllotment) {
		this.leaveAllotment = leaveAllotment;
	}

	public EmpInfo getEmpInfo() {
		return empInfo;
	}

	public void setEmpInfo(EmpInfo empInfo) {
		this.empInfo = empInfo;
	}
	
	
	public EmpInfo getApproveBy() {
		return approveBy;
	}  

	public void setApproveBy(EmpInfo approveBy) {
		this.approveBy = approveBy;
	}
	
	

	public List<SelectItem> getLeaveTypeList() {  
		return leaveTypeList;
	}

	public void setLeaveTypeList(List<SelectItem> leaveTypeList) {
		this.leaveTypeList = leaveTypeList;
	}
	
	

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public List<EmpLeaveAppEntry> getLeaveApplyList() {
		return leaveApplyList;
	}

	public void setLeaveApplyList(List<EmpLeaveAppEntry> leaveApplyList) {
		this.leaveApplyList = leaveApplyList;
	}



	//current year...
	int year = Calendar.getInstance().get(Calendar.YEAR);
	
	
	//float total=0f;
	//float leavetaken=0f;
	
	//calculation of leave Info
	public void consolidateLeave(EmpInfo empInfo)
	  {
		float total=0f;
		float leavetaken=0f;
	
		if(empInfo.getEmpLeaveAllotment()!=null)
		{
		 for( EmpLeaveAllotment leaveInfo:empInfo.getEmpLeaveAllotment())
		   {
		   if(leaveInfo.getForYear()==year)
		     {
			  total=total+leaveInfo.getNoOfDays();
		     }
		
		   }
		  }
		totalLeave=total;
		if(empInfo.getEmpLeaveAppEntry()!=null )
		{
		 for(EmpLeaveAppEntry empLeaveEntry:empInfo.getEmpLeaveAppEntry())
		  {
			float days=(empLeaveEntry.getToDate().getTime()-empLeaveEntry.getFromDate().getTime())/(1000 * 60 * 60 * 24)+1; 
			if(empLeaveEntry.getYear()==year && empLeaveEntry.getLeaveStatus() && empLeaveEntry.getHalfDayLeave()==false)
			   leavetaken=leavetaken+days;
			
			else if(empLeaveEntry.getHalfDayLeave() && days>1 && empLeaveEntry.getYear()==year && empLeaveEntry.getLeaveStatus())
			    
				leavetaken=(float) (leavetaken+(days-0.5));
			else if(empLeaveEntry.getYear()==year && empLeaveEntry.getLeaveStatus())
				
				leavetaken=(float)(leavetaken+ 0.5);  
				
		  }
		}
		
		this.leaveTaken=leavetaken;
		if(this.totalLeave>=this.leaveTaken)
		   this.remainingLeave=this.totalLeave-this.leaveTaken;
		else
			this.remainingLeave=0.0f;
		
		
	  }
	
	//calculation of leave days..
	
	public void consolidateAddLeave()
	      {
		    leaveApplication.setYear(year);
		     float days=(leaveApplication.getToDate().getTime()-leaveApplication.getFromDate().getTime())/(1000 * 60 * 60 * 24)+1;
//		    if(leaveApplication.getLeaveStatus())
//		     {
		    	if(leaveApplication.getHalfDayLeave()==false)
		    	 {
		    	 
		    		 leaveApplication.setNoOfDays(days);
//		    	    if(leaveApplication.getNoOfDays()+this.remainingLeave>=this.totalLeave)
//		    		  leaveApplication.setRemainingDays(this.remainingLeave-leaveApplication.getNoOfDays());
//		    	    else
//		    	      unpaidays=unpaidays+leaveApplication.getNoOfDays();	
		    	 }
		      else if(leaveApplication.getHalfDayLeave() && days>1)  
		          {
		    	    leaveApplication.setNoOfDays(days-0.5f);
//		    	    if(leaveApplication.getNoOfDays()+this.remainingLeave>=this.totalLeave)
//			    	   leaveApplication.setRemainingDays(this.remainingLeave-leaveApplication.getNoOfDays());
//			       else
//			    	 unpaidays=unpaidays+leaveApplication.getNoOfDays();
		    	   
		    	  }  
		      else
		         {
		    	     leaveApplication.setNoOfDays(0.5f);
//		    	     if(leaveApplication.getNoOfDays()+this.remainingLeave>=this.totalLeave)
//			    	   leaveApplication.setRemainingDays(this.remainingLeave-leaveApplication.getNoOfDays());
//			        else
//			    	 unpaidays=unpaidays+leaveApplication.getNoOfDays();
		    	  
		         }
		    	
//		    	leaveApplication.setUnpaidDays(unpaidays);
		    	
		    	
		     }


		 public void clearData()
		   {
			 setEmpInfo(new EmpInfo());
			 totalLeave=0;
			 leaveTaken=0;
			 remainingLeave=0;
			 setLeaveTypeList(new ArrayList<SelectItem>());
			 setLeaveApplication(new EmpLeaveAppEntry());
			 getLeaveApplication().setApplicationDate(new Date());
			 setApproveBy(new EmpInfo());
		   }
	      
	 
	
	

}
