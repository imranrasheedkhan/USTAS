package com.ustas.db.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.ustas.db.model.EmpInfo;
import com.ustas.db.model.EmpShiftAllotment;
import com.ustas.db.model.HolidayInfo;
import com.ustas.db.model.ShiftInfo;

public class ShiftAllotmentDAO implements Serializable {
	EntityManager em;
	
	public ShiftAllotmentDAO(EntityManager em){
		this.em=em;
		
	}
	
	public void saveShiftAllotment(EmpInfo empshift,EntityManager em, UserTransaction ut)
	 {
    	System.out.println("in side the DAO");
    	try{
	      ut.begin();
       	  em.merge(empshift);
	     ut.commit();
	     System.out.println("commit");
	     }catch(Exception e){
		 System.out.println(e.getMessage());  
	 }
	
	}
	
	
//public List<EmpShiftAllotment> searchShiftAllotment(String name,EntityManager em,UserTransaction ut ){
//	List<EmpShiftAllotment>empshiftList=new ArrayList<EmpShiftAllotment>();
//		try{ 
//			ut.begin();
//			Query q 	 = em.createQuery("Select A EmpShiftAllotment from  A where (A.shiftInfo.shiftName LIKE :name)  ");
//			q.setParameter("name",name);
//			//q.setParameter("month",month);
//			empshiftList= q.getResultList();
//			ut.commit();
//			
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//			
//		}
//		
//		return  empshiftList;
//	}
	
	 public  List<EmpInfo> selectemployees(EntityManager em,UserTransaction ut)
	   {
		 System.out.println("In side save");
	    List<EmpInfo> list=null;   
	    try {
	       
	        ut.begin();
	      
	        Query q = em.createQuery("Select A from EmpInfo A");
	       
	        list= q.getResultList();
	         ut.commit();   
	         System.out.println("commit");
	   
	         }catch (Exception e)   
	       {
	      System.out.println(e.getMessage());
	     try
	       {   
	     ut.rollback();
	        } catch (IllegalStateException | SecurityException | SystemException e1)
	     {

	     e1.printStackTrace();
	        }
	     }   
	     
	     return list;
	   }
	 
	 public List<ShiftInfo> selectShift(EntityManager em, UserTransaction ut ){
		 System.out.println("in DAO");
		 List<ShiftInfo> shiftlist=null; 
		 try {
		       
		         ut.begin();
		          Query q = em.createQuery("Select A from ShiftInfo A where A.isActive=:active");
		          q.setParameter("active", true);
		          shiftlist= q.getResultList();
		          ut.commit();   
		         System.out.println("IN shift Commit");
		      
		         }catch (Exception e)   
		       {
		      System.out.println(e.getMessage());
		     try
		       {   
		     ut.rollback();
		        } catch (IllegalStateException | SecurityException | SystemException e1)
		     {

		     e1.printStackTrace();
		        }
		     }   
		 
		 return  shiftlist;
	 }
	 
	 
	 
	 

public void updateShiftAllotment( EmpShiftAllotment empshift, EntityManager em, UserTransaction ut){
	try{
		
		ut.begin();
		em.merge(empshift);
		ut.commit();
	}catch(Exception e){
		System.out.println(e.getMessage());
		
		try {
			ut.rollback();
		} catch (IllegalStateException | SecurityException
				| SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  }
	
	
  }

public ShiftInfo selectAllotedShift(int indexNo,EntityManager em,UserTransaction ut)
         {
	       ShiftInfo shiftInfo=null;
          try{
		     ut.begin();
		      Query q=em.createQuery("Select S from ShiftInfo S where s.indexNo=:indexNo");
		      q.setParameter("indexNo", indexNo);
		      shiftInfo=(ShiftInfo) q.getSingleResult();
		      ut.commit();
	          }catch(Exception e){
		      System.out.println(e.getMessage());
		
		     try {
			    ut.rollback();
		        } catch (IllegalStateException | SecurityException
				| SystemException e1) {
			 // TODO Auto-generated catch block
			 e1.printStackTrace();
		     }
	       }
	     return shiftInfo;
	
   }

  public List<EmpShiftAllotment> viewShiftAlloment(EntityManager em,UserTransaction ut,String empNo)
    {
	  List<EmpShiftAllotment> shiftAllotmentList=null;
      try{
	     ut.begin();
	      Query q=em.createQuery("Select S from EmpShiftAllotment S where S.empInfo.empNo Like :empNo");
	      q.setParameter("empNo", "%"+empNo+"%");
	      shiftAllotmentList=q.getResultList();
	      ut.commit();
          }catch(Exception e){
	      System.out.println(e.getMessage());
	
	     try {
		    ut.rollback();
	        } catch (IllegalStateException | SecurityException
			| SystemException e1) {
		 // TODO Auto-generated catch block
		 e1.printStackTrace(); 
	     }
       }
     return shiftAllotmentList;
   }
	
	
}


	




	

	
	
	