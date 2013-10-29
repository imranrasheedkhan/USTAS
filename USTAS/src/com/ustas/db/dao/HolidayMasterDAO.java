package com.ustas.db.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;



import com.ustas.db.model.HolidayInfo;

public class HolidayMasterDAO implements Serializable {
	EntityManager em;
	
	public HolidayMasterDAO(EntityManager em) {
		this.em = em;
	}
	
	public void saveHoliday(HolidayInfo holidayInfo, EntityManager emm, UserTransaction ut)
	{
		System.out.println("reached 4"+holidayInfo);
		try {  
		
			ut.begin();
			
	  		emm.persist(holidayInfo);
	  
		
		   	ut.commit();
		   
		   } catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				//ut.rollback();
			} catch (IllegalStateException | SecurityException e1){
//					| SystemException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	
	public List<HolidayInfo> displayHoliday(String name ,EntityManager emm,UserTransaction ut){
		List<HolidayInfo> HolidayList = new ArrayList<HolidayInfo>();
		
		try{
			
			ut.begin();
			
			  Query q 	 = emm.createQuery("Select A from HolidayInfo A where (A.name LIKE :name)");
			q.setParameter("name","%"+name+"%");
			HolidayList	=q.getResultList(); 
	
			ut.commit();
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		return HolidayList;
	}
		
		
		
		

	public void updateHoliday(HolidayInfo holidayInfo,EntityManager emm,UserTransaction ut){
		System.out.println("reached 4");
		try{
			
			ut.begin();
			emm.merge(holidayInfo);
			emm.flush();
			ut.commit();
		}
		catch(Exception e){
			
			System.out.println(e.getMessage());
		}
		
		try {
			ut.rollback();
		} catch (IllegalStateException | SecurityException
				| SystemException e1) {
			e1.printStackTrace();
		}
		
	}
	
}
