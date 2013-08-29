package com.ustas.db.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
	private  Timestamp startTime;
	
    @Column(name="END_TIME")
	private Timestamp endTime;
	
    @ManyToMany
	private List<ShiftInfo> shiftInfos;
	
	private String comments;

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

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
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
	
    
}
