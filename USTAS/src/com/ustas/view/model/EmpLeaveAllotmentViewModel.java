package com.ustas.view.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.model.SelectItem;

import com.ustas.db.model.EmpInfo;
import com.ustas.db.model.EmpLeaveAllotment;
import com.ustas.db.model.LeaveInfo;

public class EmpLeaveAllotmentViewModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private EmpInfo empInfo ;
	
	private LeaveInfo leaveInfo=new LeaveInfo();
	
	private EmpLeaveAllotment empLeaveAllotmnet=new EmpLeaveAllotment();  
	
	public EmpLeaveAllotment getEmpLeaveAllotmnet() {
		return empLeaveAllotmnet;
	}

	public void setEmpLeaveAllotmnet(EmpLeaveAllotment empLeaveAllotmnet) {
		this.empLeaveAllotmnet = empLeaveAllotmnet;
	}

	private List<SelectItem> leaveTypeList=new ArrayList<>();
	
	private List<LeaveInfo> leaveInfoList=new ArrayList<>();
	
	private List<EmpInfo> empList=new ArrayList<>();

	public EmpInfo getEmpInfo() {
		return empInfo;
	}

	public void setEmpInfo(EmpInfo empInfo) {
		this.empInfo = empInfo;
	}

	public LeaveInfo getLeaveInfo() {
		return leaveInfo;
	}

	public void setLeaveInfo(LeaveInfo leaveInfo) {
		this.leaveInfo = leaveInfo;
	}

	public List<SelectItem> getLeaveTypeList() {
		return leaveTypeList;
	}

	public void setLeaveTypeList(List<SelectItem> leaveTypeList) {
		this.leaveTypeList = leaveTypeList;
	}

	public List<EmpInfo> getEmpList() {
		return empList;
	}

	public void setEmpList(List<EmpInfo> empList) {
		this.empList = empList;
	}
  
	public List<LeaveInfo> getLeaveInfoList() {
		return leaveInfoList;
	}

	public void setLeaveInfoList(List<LeaveInfo> leaveInfoList) {
		this.leaveInfoList = leaveInfoList;
	}
	   
	
	
		
	

}
