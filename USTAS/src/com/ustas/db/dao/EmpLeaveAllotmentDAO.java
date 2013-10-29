package com.ustas.db.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.ustas.db.model.EmpInfo;
import com.ustas.db.model.LeaveInfo;

public class EmpLeaveAllotmentDAO implements Serializable {

	
	  private static final long serialVersionUID = 1L;
	  
      EntityManager em;
	
      public EmpLeaveAllotmentDAO(EntityManager em){
		  this.em=em;
	  }
	  
	  public List<LeaveInfo> selectLeaveType(EntityManager em, UserTransaction ut)
	    {
		  List<LeaveInfo> list=null;
		  try {
			    
	    	  ut.begin();
		      Query q = em.createQuery("Select A from LeaveInfo A where A.isActive=:active",LeaveInfo.class);
		      q.setParameter("active", true);
	    	  list=q.getResultList();
	     	  ut.commit();    
			
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
	  
	  public  List<EmpInfo> selectemployees(int year,EntityManager em,UserTransaction ut)
	  {
		  List<EmpInfo> list=null;   
		  try {
			    
	    	  ut.begin();
		    
	    	  Query q = em.createQuery("Select A from EmpInfo A");    
		//      q.setParameter("year", year);
	    	  list= q.getResultList();      
	     	  ut.commit();      
			  
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
	  
	  public void addAllotedLeave(EmpInfo empInfo,EntityManager em,UserTransaction ut)
	    {
		  
		  try {
			    
	    	  ut.begin();
		      em.merge(empInfo);  
		      ut.commit();    
			
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
	    }

}
