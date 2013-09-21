package com.ustas.db.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import com.ustas.db.model.BreakInfo;

public class BreakMasterDAO implements Serializable {
	
	EntityManager em;
	
	public BreakMasterDAO(EntityManager em)
	{
		this.em = em;
		
	}

	public void save(BreakInfo BreakInfo, EntityManager em, UserTransaction ut)  
	
	{
		try {
			
			ut.begin();
	  		em.persist(BreakInfo);
			em.flush();
		   	ut.commit();
		   } catch (Exception e) {
			System.out.println(e.getMessage());
			
	}
	}
		
			
		
	
	public void updateBreakInfo(BreakInfo breakInfo,EntityManager em, UserTransaction ut)
		{
		System.out.println("in update");
			try
			{
				ut.begin();
		  		em.merge(breakInfo);
				em.flush();
			   	ut.commit();
			   } catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
			
		
		
		public List<BreakInfo> displayBreak(String name,EntityManager em,UserTransaction ut)
		   {
			
				List<BreakInfo> BreakList = new ArrayList<BreakInfo>();
				
				try
				{
					ut.begin();
					
					//Query q= em.createQuery("Select A from BreakInfo A where(A.breakType LIKE :name)");
					javax.persistence.Query q= em.createQuery("select A from BreakInfo A where (A.breakType Like:name)");
                   q.setParameter("name","%"+name+"%");
                   BreakList = q.getResultList();
					ut.commit();
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			
			  
			
			return BreakList;
			}
		}	
		
		
		
	
	
	
	
	
	
