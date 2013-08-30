package com.ustas.db.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="emp_attendance")
public class EmpAttendanceProcess implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int indexNo;
   
	@Temporal(TemporalType.DATE)
	@Column(name="FOR_DATE")
	private Date forDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="PROCESS_DATE")
	private Date processDate;
	
	@Column(name="IN_TIME")
	private Timestamp inTime;
	
	@Column(name="OUT_TIME")
	private Timestamp outTime;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="OT_WORK")
	private String overTimeWork;
	
	@Column(name="IS_HALF_DAY")
	private boolean isHalfDay;
	
	@Column(name="REMARKS")
	private String remarks;
	
	@ManyToOne
	@JoinColumn(name="EMP_INFO_EMP_NO")
	private EmpInfo empInfo;
	
	@ManyToOne
	@JoinColumn(name="SHIFT_MASTER_INDEX")
	private ShiftInfo shiftInfos;

	public int getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(int indexNo) {
		this.indexNo = indexNo;
	}

	public Date getForDate() {
		return forDate;
	}

	public void setForDate(Date forDate) {
		this.forDate = forDate;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public Timestamp getInTime() {
		return inTime;
	}

	public void setInTime(Timestamp inTime) {
		this.inTime = inTime;
	}

	public Timestamp getOutTime() {
		return outTime;
	}

	public void setOutTime(Timestamp outTime) {
		this.outTime = outTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOverTimeWork() {
		return overTimeWork;
	}

	public void setOverTimeWork(String overTimeWork) {
		this.overTimeWork = overTimeWork;
	}

	public boolean isHalfDay() {
		return isHalfDay;
	}

	public void setHalfDay(boolean isHalfDay) {
		this.isHalfDay = isHalfDay;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public EmpInfo getEmpInfo() {
		return empInfo;
	}

	public void setEmpInfo(EmpInfo empInfo) {
		this.empInfo = empInfo;
	}

	

	

}
