package com.ustas.db.dao;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import com.ustas.db.model.EmpAttendanceProcess;
import com.ustas.db.model.EmpInfo;

public class AttendanceProcessDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	EntityManager em;
	
	public AttendanceProcessDAO(EntityManager em)
    	 {
		 this.em=em;
	     }
	
	public List<EmpAttendanceProcess> viewAttendanceDetail(String empNo,int month,Date date,EntityManager em,UserTransaction ut)
	 {
		  List<EmpAttendanceProcess> list=null;
		   CriteriaBuilder cb=em.getCriteriaBuilder();
		   Date selectedDate=null ;
	       if(date!=null)
		   selectedDate= new Date(date.getTime()+(24*60*60*1000));
		
		  try {
			   ut.begin();
			    CriteriaQuery<EmpAttendanceProcess> cq = cb.createQuery(EmpAttendanceProcess.class);
		  	    Root<EmpAttendanceProcess> root=cq.from(EmpAttendanceProcess.class);
			    Expression<Integer> year= cb.function("year", Integer.class,root.get("forDate"));
			    Expression<Integer> mon = cb.function("month", Integer.class,root.get("forDate"));
			    Expression<String> id = root.get("empInfo").get("empNo");
			    Expression<Date> forDate = root.get("forDate");
			  
			    Predicate perdicate1=cb.equal(year,Calendar.getInstance().get(Calendar.YEAR));
			    
			    Predicate perdicate2=cb.equal(mon,    month+1);
			 
			    Predicate perdicate3=cb.like(id,"%"+empNo+"%"); 
			   
			    Predicate perdicate4=cb.equal(forDate,selectedDate); 
			   
			    if(month==-1 && date!=null)
				   cq.where(cb.and(perdicate1,perdicate3,perdicate4));
			   
			    else if(month==-1 && date==null)
			      cq.where(cb.and(perdicate1,perdicate3)); 
			
			    else if(month!=-1 && date==null)
			      cq.where(cb.and(perdicate1,perdicate2,perdicate3));
			    else if (month!=-1 && date!=null)  
			    	cq.where(cb.and(perdicate1,perdicate2,perdicate3,perdicate4));
			    TypedQuery<EmpAttendanceProcess> typedQuery = em.createQuery(cq);   
			    list=typedQuery.getResultList();  
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
	
	public List<EmpInfo> selectAllEmployee(EntityManager em,UserTransaction ut)
	  {
		 List<EmpInfo> list=null;   
		  try {
			    
	    	  ut.begin();
		    
	    	  Query q = em.createQuery("Select A from EmpInfo A");  
		     
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
	
	public void processAttendance(EntityManager em,UserTransaction ut,EmpInfo empInfo)
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
