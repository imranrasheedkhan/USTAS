package com.ustas.db.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LEAVE_MASTER")
public class LeaveInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INDEX_NO")
	private int indexNo;
	
	@Column(name="LEAVE_TYPE")
	private String LeaveType;
	
	@Column(name="SHORT_NAME")
	private String shortName;
	
	@Column(name="LEAVE_DESC")
	private String desc;
	      
	@Column(name="CF_ALLOWED")
	private boolean cfAllowed;
	
	@Column(name="IS_ACTIVE")
	private boolean isActive;
	
	@OneToMany(mappedBy="leaveInfos",cascade=CascadeType.ALL)
	private List<EmpLeaveAllotment> empLeaveAllotments;  

	public int getIndexNo() {
		return indexNo;       
	}

	public void setIndexNo(int indexNo) {
		this.indexNo = indexNo;
	}

	public String getLeaveType() {
		return LeaveType;
	}

	public void setLeaveType(String leaveType) {
		LeaveType = leaveType;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isCfAllowed() {
		return cfAllowed;
	}

	public void setCfAllowed(boolean cfAllowed) {
		this.cfAllowed = cfAllowed;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public List<EmpLeaveAllotment> getEmpLeaveAllotments() {
		return empLeaveAllotments;
	}

	public void setEmpLeaveAllotments(List<EmpLeaveAllotment> empLeaveAllotments) {
		this.empLeaveAllotments = empLeaveAllotments;
	}

	
	

}
