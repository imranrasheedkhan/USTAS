package com.ustas.view.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ustas.db.model.LeaveInfo;

public class LeaveMasterViewModel implements Serializable{
	
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	
	public LeaveMasterViewModel()
	{
		
	}
	
	private String leaveType;
	
	
	public String getLeaveType() {
		return leaveType;
	} 
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	private LeaveInfo leaveInfo=new LeaveInfo();
	public LeaveInfo getLeaveInfo() {
		return leaveInfo;
	}
	public void setLeaveInfo(LeaveInfo leaveInfo) {
		this.leaveInfo = leaveInfo;
	}
	List<LeaveInfo> leaveList=new ArrayList<>();
	public List<LeaveInfo> getLeaveList() {
		return leaveList;
	}
	public void setLeaveList(List<LeaveInfo> leaveList) {
		this.leaveList = leaveList;
	}

	
}
