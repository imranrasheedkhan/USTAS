package com.ustas.db.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import com.steadystate.css.parser.selectors.BeginHyphenAttributeConditionImpl;
import com.ustas.db.model.BadgeInfo;
import com.ustas.db.model.EmpInfo;


public class BadgeMasterDAO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	EntityManager em;
	
	public BadgeMasterDAO(EntityManager em)
	{
		this.em = em;
	}

 public List<EmpInfo> displayBadge(String id, EntityManager em,UserTransaction ut)
 {

	 List<EmpInfo> empList = new ArrayList<EmpInfo>();
		
		try
		 {
			ut.begin();
		     Query q= em.createQuery("select A from EmpInfo A where (A.empNo Like:id)");
             q.setParameter("id","%"+id+"%");
            empList = q.getResultList();
			ut.commit();
		 }catch(Exception e){
			System.out.println(e.getMessage());
		}
	
	  
	
	return empList;
	 
 }
 
 public void addbadge(EmpInfo badgeInfo, EntityManager em, UserTransaction ut  )
 {
	 try
	 {
		 ut.begin();
	     em.merge(badgeInfo);
		 ut.commit();
	 } catch (Exception e) {
       System.out.println(e.getMessage());
		 
		
	 } 
	 
 }
 
 public void updateBadge(BadgeInfo badgeInfo, EntityManager em, UserTransaction ut)
  {
	 
	 try {
			
			ut.begin();
	  		em.merge(badgeInfo);
			em.flush();
		   	ut.commit();
		   } catch (Exception e) {
			System.out.println(e.getMessage());
			
	    }
   }
 
 public  List<BadgeInfo> selectBadge(String id, EntityManager em,UserTransaction ut)
      {
	     List<BadgeInfo> badglist=null;
	     try{
	    	  ut.begin();
	    	  Query q= em.createQuery("select A from BadgeInfo A where (A.empInfo.empNo Like:id)");
	          q.setParameter("id","%"+id+"%");
	          badglist = q.getResultList();
			  ut.commit();
	    	
	    	  }catch(Exception e){
	    	  
	    	  System.out.println("Exception is throws" +e.getStackTrace());
	        }
	    return badglist;
     }
}
