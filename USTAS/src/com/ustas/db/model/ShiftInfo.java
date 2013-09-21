package com.ustas.db.model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="shift_master")
public class ShiftInfo implements Serializable {
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INDEX_NO")
	private int indexNo;
	
	@Column(name="SHIFT_NAME")
	private String shiftName;
	
	@Column(name="SHIFT_DESC")
	private String ShiftDesc;
	
	@Column(name="IN_TIME")
	private Time inTime;
	
	@Column(name="OUT_TIME")
	private Time outTime;
	
	@Column(name="LATE_COMING_LIMIT")  
	private int lateComingLimit;
	
	@Column(name="EARLY_GOING_LIMIT")
	private int earlyGoingLimit;
	
	@Column(name="WEEK_OFF_NO")
	private int weekOfNo;
	
	@Column(name="WEEK_OFF_DAY1")
	private String weekOfDay1;
	
	@Column(name="WEEK_OFF_DAY2")
	private String weekOfDay2;
	
	@Column(name="WEEK_OFF_DAY3")
	private String weekOfDay3;
	
	@Column(name="ALT_OFF_DAY")
	private String alternateWeekOff;
	
	@Column(name="OVERTIME_LIMIT")
	private Time overtimeLimit;
   
	@Column(name="IS_ACTIVE")
	private boolean isActive ;
	
	@OneToOne(mappedBy="shiftInfo")
	private EmpShiftAllotment shiftAllotment;
	
	@ManyToMany
	@JoinTable(name="SHIFT_BREAK_MASTER",joinColumns=@JoinColumn(name="SHIFT_INDEX"),
	          inverseJoinColumns=@JoinColumn(name="BREAK_INDEX"))
    
	private List <BreakInfo>  breakInfos=new ArrayList<>();
	
	
	public int getIndexNo() {
		return indexNo;  
	}

	public void setIndexNo(int indexNo) {  
		this.indexNo = indexNo;
	}

	public String getShiftName() {
		return shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public String getShiftDesc() {
		return ShiftDesc;
	}

	public void setShiftDesc(String shiftDesc) {
		ShiftDesc = shiftDesc;
	}

	public Time getInTime() {
		return inTime;
	}

	public void setInTime(Time inTime) {
		this.inTime = inTime;
	}

	public Time getOutTime() {
		return outTime;
	}

	public void setOutTime(Time outTime) {
		this.outTime = outTime;
	}

	public int getLateComingLimit() {
		return lateComingLimit;
	}

	public void setLateComingLimit(int lateComingLimit) {
		this.lateComingLimit = lateComingLimit;
	}

	public int getEarlyGoingLimit() {
		return earlyGoingLimit;
	}

	public void setEarlyGoingLimit(int earlyGoingLimit) {
		this.earlyGoingLimit = earlyGoingLimit;
	}

	public int getWeekOfNo() {
		return weekOfNo;
	}

	public void setWeekOfNo(int weekOfNo) {
		this.weekOfNo = weekOfNo;
	}

	public String getWeekOfDay1() {
		return weekOfDay1;
	}

	public void setWeekOfDay1(String weekOfDay1) {
		this.weekOfDay1 = weekOfDay1;
	}

	public String getWeekOfDay2() {
		return weekOfDay2;
	}

	public void setWeekOfDay2(String weekOfDay2) {
		this.weekOfDay2 = weekOfDay2;
	}

	public String getWeekOfDay3() {
		return weekOfDay3;
	}

	public void setWeekOfDay3(String weekOfDay3) {
		this.weekOfDay3 = weekOfDay3;
	}

	public String getAlternateWeekOff() {
		return alternateWeekOff;
	}

	public void setAlternateWeekOff(String alternateWeekOff) {
		this.alternateWeekOff = alternateWeekOff;
	}

	public Time getOvertimeLimit() {
		return overtimeLimit;
	}

	public void setOvertimeLimit(Time overtimeLimit) {
		this.overtimeLimit = overtimeLimit;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<BreakInfo> getBreakInfo() {
		return breakInfos;
	}

	public void setBreakInfo(List<BreakInfo> breakInfo) {
		this.breakInfos = breakInfo;
	}

	public EmpShiftAllotment getShiftAllotment() {
		return shiftAllotment;
	}

	public void setShiftAllotment(EmpShiftAllotment shiftAllotment) {
		this.shiftAllotment = shiftAllotment;
	}

	
	
	  
	
}
