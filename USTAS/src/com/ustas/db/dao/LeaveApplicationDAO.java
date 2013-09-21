package com.ustas.db.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.ustas.db.model.EmpInfo;
import com.ustas.db.model.EmpLeaveAppEntry;

public class LeaveApplicationDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public LeaveApplicationDAO(EntityManager em)
	   {
		 this.em=em;
	   }
	   
	public EmpInfo leaveInfo(String empId,EntityManager em,UserTransaction ut)
	   {
		     EmpInfo empInfo=null;
		      try {
			    
		    	  ut.begin();
			      Query q = em.createQuery("Select A from EmpInfo A where A.empNo=:empNo");
			      q.setParameter("empNo", empId);
		    	  empInfo=(EmpInfo) q.getSingleResult();
		    	   em.flush();
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
		    
		  return empInfo;
		
	   }
	
	public void addLeaveApp(EmpInfo empInfo,EntityManager em,UserTransaction ut)
	    {
		
		  try {
			    
	    	   ut.begin();
		        em.merge(empInfo); 
		        em.flush();
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

	public List<EmpLeaveAppEntry> selectLeaveApplication(String empNo, EntityManager em,UserTransaction ut)
	  {
		List<EmpLeaveAppEntry> list=null;
		  try {
			   ut.begin();
			   Query q=em.createQuery("Select A from EmpLeaveAppEntry A where A.empInfo.empNo LIKE:empNo");
			   
			   q.setParameter("empNo", "%"+empNo+"%");
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
}
