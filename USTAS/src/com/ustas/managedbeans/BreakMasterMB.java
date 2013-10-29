package com.ustas.managedbeans;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.ustas.application.managedbean.ApplicationBean;
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
	
	@ManagedProperty(value="#{ApplicationBean}")
	private ApplicationBean appBean;
	
	
	
	public ApplicationBean getAppBean() {
		return appBean;
	}

	public void setAppBean(ApplicationBean appBean) {
		this.appBean = appBean;
	}

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
	    
	    String message = appBean.applicationPropreties.getProperty("ADD_BREAK");
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
	    Model.setBreakInfo(new BreakInfo());
	    Model.clearBreak();
	    
	 }
	
	public void updateBreak() throws ParseException 
	 {
		System.out.println("in update");
   		Model.consolidateBreak(Model.getBreakInfo());
		BreakDAO.updateBreakInfo(Model.getBreakInfo(),em,ut);
		
		 String message = appBean.applicationPropreties.getProperty("UPDATE_BREAK");
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
		 Model.setBreakInfo(new BreakInfo());
		 Model.clearBreak();
		
	 }
	
	public void display()
	
	{
		
		List<BreakInfo>breakList= BreakDAO.displayBreak(Model.getSearchKey(), em, ut);
		for(BreakInfo breakInfo : breakList)
		Model.totalBreakTime(breakInfo);
		Model.setBreakList(breakList);
	}
	
	public void edit()
	 {
		System.out.println("in action");
		Model.breakBreakObjects(Model.getBreakInfo());
	
		
		
		
	 }
	
	
}

