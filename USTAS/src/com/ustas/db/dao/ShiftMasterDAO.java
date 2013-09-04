package com.ustas.db.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.ustas.db.model.ShiftInfo;

public class ShiftMasterDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

    public ShiftMasterDAO(EntityManager em){
		this.em=em;
	}
    
 //   @PersistenceContext(unitName="USTAS")
  //  EntityManager emm;
    
  //  @Resource  
  //  UserTransaction utt;
    
    public List<SelectItem> selectBreakList(UserTransaction ut, EntityManager em)
      {
    	System.out.println("In the select Breaklist DAO");
    	List<SelectItem> list=null;
    	
    	try {
		     ut.begin();
		   //   em.getTransaction().begin();
			  Query q = em.createQuery("Select A.indexNo,A.breakType from BreakInfo A where A.isActive=:isActive"); 
			  q.setParameter("isActive", true);
			  list = q.getResultList();
		//	  em.getTransaction().commit();
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
    
    public void addShift(ShiftInfo shiftInfo,EntityManager em,UserTransaction ut)
      {
    	      try {
    	    	  System.out.println("In the DAO method");
             	   ut.begin();
             	 //  em.getTransaction().begin();
    	           em.persist(shiftInfo);  
    	           
    	        //   em.getTransaction().commit();
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
