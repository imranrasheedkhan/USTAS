package com.ustas.view.model;

import java.util.ArrayList;
import java.util.List;

import com.ustas.db.model.BreakInfo;
import com.ustas.db.model.ShiftInfo;

public class SwiftMasterViewModel {
	     
	 public SwiftMasterViewModel()
	    {
		 
	    }
	
	private  ShiftInfo shiftInfo=new ShiftInfo();
	   
    private  BreakInfo breakInfo=new BreakInfo();
    
    
   
    
	public ShiftInfo getShiftInfo() {
		return shiftInfo;
	}

	public void setShiftInfo(ShiftInfo shiftInfo) {
		this.shiftInfo = shiftInfo;
	}

	public BreakInfo getBreakInfo() {
		return breakInfo;
	}

	public void setBreakInfo(BreakInfo breakInfo) {
		this.breakInfo = breakInfo;
	}
	   
	   
 // to store the time information..
    
    private int inTomeHr;
    
    private int inTimeMin;
    
    private int inTimeSec;
    
    private int outTimeHr;
    
    private int outTimeMin;
    
    private int outTimeSec;
    
    private int overTimeHr;
    
    private int overTimeMin;
    
    private int overTimeSec ;




	public int getInTomeHr() {
		return inTomeHr;
	}

	public void setInTomeHr(int inTomeHr) {
		this.inTomeHr = inTomeHr;
	}

	public int getInTimeMin() {
		return inTimeMin;
	}

	public void setInTimeMin(int inTimeMin) {
		this.inTimeMin = inTimeMin;
	}

	public int getInTimeSec() {
		return inTimeSec;
	}

	public void setInTimeSec(int inTimeSec) {
		this.inTimeSec = inTimeSec;
	}

	public int getOutTimeHr() {
		return outTimeHr;
	}

	public void setOutTimeHr(int outTimeHr) {
		this.outTimeHr = outTimeHr;
	}

	public int getOutTimeMin() {
		return outTimeMin;
	}

	public void setOutTimeMin(int outTimeMin) {
		this.outTimeMin = outTimeMin;
	}

	public int getOutTimeSec() {
		return outTimeSec;
	}

	public void setOutTimeSec(int outTimeSec) {
		this.outTimeSec = outTimeSec;
	}

	public int getOverTimeHr() {
		return overTimeHr;
	}

	public void setOverTimeHr(int overTimeHr) {
		this.overTimeHr = overTimeHr;
	}

	public int getOverTimeMin() {
		return overTimeMin;
	}

	public void setOverTimeMin(int overTimeMin) {
		this.overTimeMin = overTimeMin;
	}

	public int getOverTimeSec() {
		return overTimeSec;
	}

	public void setOverTimeSec(int overTimeSec) {
		this.overTimeSec = overTimeSec;
	}
	   
	 // to store the  weekoff details..
	private boolean monWeekOff;
	
	private boolean tueWeekOff;
	
	private boolean wedWeekOff;
	
	private boolean thursWeekOff;
	
	private boolean friWeekOff;
	
	private boolean satWeekOff;
	
	private boolean sunWeekOff;




	public boolean isMonWeekOff() {
		return monWeekOff;
	}

	public void setMonWeekOff(boolean monWeekOff) {
		this.monWeekOff = monWeekOff;
	}

	public boolean isTueWeekOff() {
		return tueWeekOff;
	}

	public void setTueWeekOff(boolean tueWeekOff) {
		this.tueWeekOff = tueWeekOff;
	}

	public boolean isWedWeekOff() {
		return wedWeekOff;
	}

	public void setWedWeekOff(boolean wedWeekOff) {
		this.wedWeekOff = wedWeekOff;
	}

	public boolean isThursWeekOff() {
		return thursWeekOff;
	}

	public void setThursWeekOff(boolean thursWeekOff) {
		this.thursWeekOff = thursWeekOff;
	}

	public boolean isFriWeekOff() {
		return friWeekOff;
	}

	public void setFriWeekOff(boolean friWeekOff) {
		this.friWeekOff = friWeekOff;
	}

	public boolean isSatWeekOff() {
		return satWeekOff;
	}

	public void setSatWeekOff(boolean satWeekOff) {
		this.satWeekOff = satWeekOff;
	}

	public boolean isSunWeekOff() {
		return sunWeekOff;
	}

	public void setSunWeekOff(boolean sunWeekOff) {
		this.sunWeekOff = sunWeekOff;
	}
	
	 // AlterNate week off.
	
    private boolean monAlternateOFF;
	
	private boolean tueAlternateOFF;
	
	private boolean wedAlternateOFF;
	
	private boolean thursAlternateOFF;
	
	private boolean friAlternateOFF;
	
	private boolean satAlternateOFF;
	
	private boolean sunAlternateOFF;




	public boolean isMonAlternateOFF() {
		return monAlternateOFF;
	}

	public void setMonAlternateOFF(boolean monAlternateOFF) {
		this.monAlternateOFF = monAlternateOFF;
	}

	public boolean isTueAlternateOFF() {
		return tueAlternateOFF;
	}

	public void setTueAlternateOFF(boolean tueAlternateOFF) {
		this.tueAlternateOFF = tueAlternateOFF;
	}

	public boolean isWedAlternateOFF() {
		return wedAlternateOFF;
	}

	public void setWedAlternateOFF(boolean wedAlternateOFF) {
		this.wedAlternateOFF = wedAlternateOFF;
	}

	public boolean isThursAlternateOFF() {
		return thursAlternateOFF;
	}

	public void setThursAlternateOFF(boolean thursAlternateOFF) {
		this.thursAlternateOFF = thursAlternateOFF;
	}

	public boolean isFriAlternateOFF() {
		return friAlternateOFF;
	}

	public void setFriAlternateOFF(boolean friAlternateOFF) {
		this.friAlternateOFF = friAlternateOFF;
	}

	public boolean isSatAlternateOFF() {
		return satAlternateOFF;
	}

	public void setSatAlternateOFF(boolean satAlternateOFF) {
		this.satAlternateOFF = satAlternateOFF;
	}

	public boolean isSunAlternateOFF() {
		return sunAlternateOFF;
	}

	public void setSunAlternateOFF(boolean sunAlternateOFF) {
		this.sunAlternateOFF = sunAlternateOFF;
	}
	
	 //........................break List..................
	
	List<BreakInfo>  breakList=new  ArrayList<>();
	
	
	
	
	

}
