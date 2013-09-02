package com.ustas.db.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.ustas.db.model.BreakInfo;

public class SwiftMasterDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;

    public SwiftMasterDAO(){
		
	}
    
    public List<BreakInfo> selectBreakList(UserTransaction ut, EntityManager em)
      {
    	System.out.println("In the select Breaklist DAO");
    	List<BreakInfo> list=null;
    	
    	try {
		      ut.begin();
			  Query q = em.createQuery("Select A from BreakInfo A where A.isActive=:isActive"); 
			  q.setParameter("isActive", true);
			  list = q.getResultList();
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
