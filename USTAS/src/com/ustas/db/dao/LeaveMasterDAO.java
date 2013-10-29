package com.ustas.db.dao;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.ustas.db.model.LeaveInfo;

public class LeaveMasterDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	public LeaveMasterDAO(EntityManager em) {
		this.em = em;
	}

	public List<LeaveInfo> selectLeaveList(String leaveType,UserTransaction ut, EntityManager em) {
		System.out.println("Leavelist DAO");
		List<LeaveInfo> list = null;

		try {
			ut.begin();
			Query q = em.createQuery("Select A from LeaveInfo A where A.shortName like:name and  A.isActive=:isActive");
			q.setParameter("isActive", true);
			q.setParameter("name", "%"+leaveType+"%");
			list = q.getResultList();
			ut.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				ut.rollback();
			} catch (IllegalStateException | SecurityException
					| SystemException se) {
				se.printStackTrace();
			}
		}
		return list;
	}

	public void addLeaveInfo(LeaveInfo leaveInfo, EntityManager em,
			UserTransaction ut) {
		try {
			System.out.println("DAO Method:");
			ut.begin();
			em.persist(leaveInfo);
			ut.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				ut.rollback();
			} catch (IllegalStateException | SecurityException
					| SystemException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void updateLeaveInfo(LeaveInfo leaveInfo, EntityManager em,
			UserTransaction ut) {
		try {
			ut.begin();
			em.merge(leaveInfo);
			ut.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				ut.rollback();
			} catch (IllegalStateException | SecurityException
					| SystemException e1) {
				e1.printStackTrace();
			}
		}

	}

	public List<LeaveInfo> selectAllLeave(UserTransaction ut, EntityManager em) {
		System.out.println("Leavelist DAO");
		List<LeaveInfo> list = null;

		try {
			ut.begin();
			Query q = em.createQuery("Select A from LeaveInfo A where  A.isActive=:isActive");
			q.setParameter("isActive", true);
			list = q.getResultList();
			ut.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				ut.rollback();
			} catch (IllegalStateException | SecurityException
					| SystemException se) {
				se.printStackTrace();
			}
		}
		return list;
	}

}
