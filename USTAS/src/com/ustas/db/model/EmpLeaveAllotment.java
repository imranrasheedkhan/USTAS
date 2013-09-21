package com.ustas.db.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="YRLY_LEAVE_ALLOT")
public class EmpLeaveAllotment implements Serializable {
	  
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INDEX_NO")
	private int indexNo;
	
	@Column(name="FOR_YEAR")
	private int forYear;
	
	@Column(name="NO_OF_DAYS")
	private float noOfDays;  
	
	@Column(name="REMARKS")
	private String remarks;   
	
	@ManyToOne
	@JoinColumn(name="LEAVE_MASTER_INDEX")
	private LeaveInfo leaveInfos ; 
	
	@ManyToOne
	@JoinColumn(name="EMP_INFO_EMP_NO")
	private EmpInfo empInfo;    

	public int getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(int indexNo) {
		this.indexNo = indexNo;
	}

	public int getForYear() {
		return forYear;
	}

	public void setForYear(int forYear) {
		this.forYear = forYear;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LeaveInfo getLeaveInfos() {
		return leaveInfos;
	}

	public void setLeaveInfos(LeaveInfo leaveInfos) {
		this.leaveInfos = leaveInfos;
	}

	public EmpInfo getEmpInfo() {
		return empInfo;
	}

	public void setEmpInfo(EmpInfo empInfo) {
		this.empInfo = empInfo;
	}

	public float getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(float noOfDays) {
		this.noOfDays = noOfDays;
	}

	
	
	
	

}
