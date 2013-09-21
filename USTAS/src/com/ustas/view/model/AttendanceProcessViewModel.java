package com.ustas.view.model;

import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ustas.db.model.EmpAttendanceProcess;
import com.ustas.db.model.EmpInfo;

public class AttendanceProcessViewModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private EmpInfo empInfo=new EmpInfo();
	
	private EmpAttendanceProcess attendanceProcess=new EmpAttendanceProcess();
	
	private List<EmpAttendanceProcess> attendanceList=new ArrayList<>();
	
	//..........serck key
	
	private String serchEmpNo; 
	
	private int month;
	private  Date searchDate;
	
	private List<SelectItem> months=new ArrayList<>();

	public EmpAttendanceProcess getAttendanceProcess() {
		return attendanceProcess;
	}

	public void setAttendanceProcess(EmpAttendanceProcess attendanceProcess) {
		this.attendanceProcess = attendanceProcess;
	}

	public EmpInfo getEmpInfo() {
		return empInfo;
	}

	public void setEmpInfo(EmpInfo empInfo) {
		this.empInfo = empInfo;
	}

	public List<EmpAttendanceProcess> getAttendanceList() {
		return attendanceList;
	}

	public void setAttendanceList(List<EmpAttendanceProcess> attendanceList) {
		this.attendanceList = attendanceList;
	}

	public String getSerchEmpNo() {
		return serchEmpNo;
	}

	public void setSerchEmpNo(String serchEmpNo) {
		this.serchEmpNo = serchEmpNo;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	
	public List<SelectItem> getMonths() {
		return months;
	}

	public void setMonths(List<SelectItem> months) {
		this.months = months;
	}
	
	

	public Date getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(Date searchDate) {
		this.searchDate = searchDate;
	}

	public void buildMonthOptions() 
	  {
		 String month = "invalid";
		 months.add(new SelectItem(-1,"All"));
		 DateFormatSymbols dfs = new DateFormatSymbols();
		 String[] smonths = dfs.getMonths();
		 for(int imonth=0 ;imonth<=11; imonth++)
		 {	 
		    month = smonths[imonth];
		    months.add(new SelectItem(imonth, month));
		 } 
		
	  } 

}
