package com.ustas.view.model;

import java.io.Serializable;
import java.util.List;


import com.ustas.db.model.HolidayInfo;

public class HolidayMasterViewModel implements Serializable {
	

	 
	private static final long serialVersionUID = 1L;

	public HolidayMasterViewModel() {
		 
		       
       }
	   
	 //--------------------HolidayInfo---------------------------
	 private HolidayInfo holidayInfo= new HolidayInfo();

	public HolidayInfo getHolidayInfo() {
	
		return holidayInfo;
	}

	public void setHolidayInfo(HolidayInfo holidayInfo) {
	
		this.holidayInfo = holidayInfo;
	
		
	}
	 private List<HolidayInfo> holidayList;

	public List<HolidayInfo> getHolidayList() {
		return holidayList;
	}

	public void setHolidayList(List<HolidayInfo> holidayList) {
		
		this.holidayList = holidayList;
	}
	
	private String searchKey;

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	
	
	 

}


