package com.ustas.db.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="shift_allotment")
public class EmpShiftAllotment implements Serializable{  

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INDEX_NO")
	private int indexNo;
	
	@Column(name="FOR_MONTH")
	private String forMonth;
	
	@Column(name="FOR_YEAR")    
	private int forYear;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FROM_DATE")
	private Date fromDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TO_DATE")
	private Date toDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="ALLOTMENT_DATE")
	private Date allotmentDate;   
	
	@Column(name="REMARKS")
	private String remarks;
	
	@OneToOne
	@JoinColumn(name="SHIFT_MS_INDEX")
	private ShiftInfo shiftInfo;
	
	@ManyToOne
	@JoinColumn(name="EMP_INFO_EMP_NO")
	private EmpInfo empInfo;
	
	@Transient
	private boolean shiftAlloted ;
	
	@Transient
	private int tempShiftIndex ;

	public int getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(int indexNo) {
		this.indexNo = indexNo;
	}

	public String getForMonth() {
		return forMonth;
	}

	public void setForMonth(String forMonth) {
		this.forMonth = forMonth;
	}

	public int getForYear() {
		return forYear;
	}

	public void setForYear(int forYear) {
		this.forYear = forYear;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public ShiftInfo getShiftInfo() {
		return shiftInfo;
	}

	public void setShiftInfo(ShiftInfo shiftInfo) {
		this.shiftInfo = shiftInfo;
	}

	public EmpInfo getEmpInfo() {
		return empInfo;
	}

	public void setEmpInfo(EmpInfo empInfo) {
		this.empInfo = empInfo;
	}

	public Date getAllotmentDate() {
		return allotmentDate;
	}

	public void setAllotmentDate(Date allotmentDate) {
		this.allotmentDate = allotmentDate;
	}

	public boolean isShiftAlloted() {
		return shiftAlloted;
	}

	public void setShiftAlloted(boolean shiftAlloted) {
		this.shiftAlloted = shiftAlloted;
	}

	public int getTempShiftIndex() {
		return tempShiftIndex;
	}

	public void setTempShiftIndex(int tempShiftIndex) {
		this.tempShiftIndex = tempShiftIndex;
	}


	
    
}
