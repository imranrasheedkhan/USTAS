package com.ustas.managedbeans;

import java.io.Serializable;
import java.text.ParseException;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import com.ustas.db.dao.BreakMasterDAO;
import com.ustas.db.model.BreakInfo;
import com.ustas.view.model.BreakMasterViewModel;


@ManagedBean
@ViewScoped

public class BreakMasterMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="USTAS")
	EntityManager em;
	
	
	@Resource
	UserTransaction ut;
	
	private BreakMasterDAO BreakDAO = new BreakMasterDAO(em);
	
	
	public BreakMasterMB()
	{
		Model = new BreakMasterViewModel();
	}
	
	public BreakMasterViewModel getModel() {
		return Model;
	}

	public void setModel(BreakMasterViewModel model) {
		Model = model;
	}

	private BreakMasterViewModel Model;
	
	public void addBreak() throws ParseException 
	{
	   Model.consolidateBreak(Model.getBreakInfo());	
	   BreakDAO.save(Model.getBreakInfo(), em, ut);
	}
	
	public void updateBreak() throws ParseException 
	{
		System.out.println("in update");
   		Model.consolidateBreak(Model.getBreakInfo());
		BreakDAO.updateBreakInfo(Model.getBreakInfo(),em,ut);
		
	}
	
	public void display()
	
	{
		//System.out.println("hello");
		//java.util.List<BreakInfo>breakList=BreakDAO.displayBreak(Model.getBreakInfo().getBreakType(),em,ut);
		java.util.List<BreakInfo>breakList= BreakDAO.displayBreak(Model.getSearchKey(), em, ut);
		Model.setBreakList(breakList);
	}
	
	public void edit()
	{
		System.out.println("in action");
		Model.breakBreakObjects(Model.getBreakInfo());
	
		
		
		
	}
	
	
}

