package com.ustas.db.model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="BREAK_MASTER")
public class BreakInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INDEX_NO")
	private int indexNo;
	
    @Column(name="BREAK_TYPE")
	private String breakType;
	
    @Column(name="BREAK_DESC")
	private String desc;
	
    @Column(name="START_TIME")
	private  Time startTime;
	
    @Column(name="END_TIME")
	private Time endTime;
	
    @ManyToMany(mappedBy="breakInfos")
    
	private List<ShiftInfo> shiftInfos;
	
    @Column(name="remarks")
	private String comments;
    
    @Column(name="IS_ACTIVE")
	private boolean isActive;
    
    @Transient
    private Time totalTime;

	public int getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(int indexNo) {
		this.indexNo = indexNo;
	}

	public String getBreakType() {
		return breakType;
	}

	public void setBreakType(String breakType) {
		this.breakType = breakType;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public List<ShiftInfo> getShiftInfos() {
		return shiftInfos;
	}

	public void setShiftInfos(List<ShiftInfo> shiftInfos) {
		this.shiftInfos = shiftInfos;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean isActive() {
		return isActive;
	}  

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Time getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Time totalTime) {
		this.totalTime = totalTime;
	}
	
    
}
