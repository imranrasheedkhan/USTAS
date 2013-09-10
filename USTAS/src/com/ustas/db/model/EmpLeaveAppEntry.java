package com.ustas.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="leave_app_entry")
public class EmpLeaveAppEntry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INDEX_NO")
	private int indexNo;                   
                            
	@Temporal(TemporalType.DATE)  
	@Column(name="APPLICATION_DATE")
	private Date applicationDate;
   
	@Column(name="APPROVER_COMMENTS")
	private String approverComments;


  
	@Temporal(TemporalType.DATE)
	@Column(name="FROM_DATE")
	private Date fromDate;

	@Column(name="HALF_DAY_LEAVE")
	private boolean halfDayLeave;

	

	@Column(name="LEAVE_REASON")
	private String leaveReason;

	@Column(name="LEAVE_STATUS")
	private boolean leaveStatus;

	@Column(name="NO_OF_DAYS")
	private float noOfDays;

	@Column(name="PAID_DAYS")
	private float paidDays;

	@Column(name="REMAINING_DAYS")
	private float remainingDays;

	@Temporal(TemporalType.DATE)
	@Column(name="TO_DATE")
	private Date toDate;

	@Column(name="UNPAID_DAYS")
	private float unpaidDays;
    
	@Column(name="YEAR")
	private int year;
   
	@ManyToOne
	@JoinColumn(name="EMP_INFO_EMP_NO")
	private EmpInfo empInfo;
	
	@OneToOne
	@JoinColumn(name="LEAVE_MASTER_INDEX")
	private LeaveInfo leaveInfo;  
	
	@ManyToOne
	@JoinColumn(name="APPROVED_BY")
	private EmpInfo approvedBy;    
	
	public EmpLeaveAppEntry() {
	}

	public int getIndexNo() {
		return this.indexNo;
	}

	public void setIndexNo(int indexNo) {
		this.indexNo = indexNo;  
	}

	public Date getApplicationDate() {
		return this.applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public EmpInfo getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(EmpInfo approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getApproverComments() {
		return this.approverComments;
	}

	public void setApproverComments(String approverComments) {
		this.approverComments = approverComments;
	}

	

	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public boolean getHalfDayLeave() {
		return this.halfDayLeave;
	}

	public void setHalfDayLeave(boolean halfDayLeave) {
		this.halfDayLeave = halfDayLeave;
	}

	

	public String getLeaveReason() {
		return this.leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public boolean getLeaveStatus() {
		return this.leaveStatus;
	}

	public void setLeaveStatus(boolean leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public float getNoOfDays() {
		return this.noOfDays;
	}

	public void setNoOfDays(float noOfDays) {
		this.noOfDays = noOfDays;
	}

	public float getPaidDays() {
		return this.paidDays;
	}

	public void setPaidDays(float paidDays) {
		this.paidDays = paidDays;
	}

	public float getRemainingDays() {
		return this.remainingDays;
	}

	public void setRemainingDays(float remainingDays) {
		this.remainingDays = remainingDays;
	}

	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public float getUnpaidDays() {
		return this.unpaidDays;
	}

	public void setUnpaidDays(float unpaidDays) {
		this.unpaidDays = unpaidDays;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

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
	
	

}