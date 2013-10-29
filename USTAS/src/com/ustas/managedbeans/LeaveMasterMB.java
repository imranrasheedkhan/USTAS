package com.ustas.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
//import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.ustas.application.managedbean.ApplicationBean;
import com.ustas.db.dao.LeaveMasterDAO;
import com.ustas.db.model.LeaveInfo;
import com.ustas.view.model.LeaveMasterViewModel;  


@ManagedBean
@ViewScoped
public class LeaveMasterMB implements Serializable {
	
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

	public LeaveMasterMB()
	  {
		   dao=new LeaveMasterDAO(em);
	   }
	
	private LeaveMasterViewModel model=new LeaveMasterViewModel();

	public LeaveMasterViewModel getModel() {
		return model;
	}

	public void setModel(LeaveMasterViewModel model) {
		this.model = model;
	}	
	private LeaveMasterDAO dao;
	public void selectLeaveList()
	{
		List<LeaveInfo> list=dao.selectLeaveList(model.getLeaveType(),ut,em);
	    model.setLeaveList(list);
	}
	   public void addLeaveInfo()
	       {
		      System.out.println("Add Method..");
		      model.getLeaveInfo();
		      dao.addLeaveInfo(model.getLeaveInfo(),em,ut);
		  	String message = appBean.applicationPropreties.getProperty("ADD_LEAVE");
		    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
		    model.setLeaveInfo(new LeaveInfo());
	       }
	public void selectLeaveUpdate()
	  {
		System.out.println("This is Update  Method..");
      
		selectLeaveList();
	  }
	
	public void updateLeaveInfo()
	 {
		System.out.println("Update Method...");
		model.getLeaveInfo();
		dao.updateLeaveInfo(model.getLeaveInfo(), em, ut);
		String message = appBean.applicationPropreties.getProperty("UPDATE_LEAVE");
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
		 model.setLeaveInfo(new LeaveInfo());
		
	 }
	
   
	@PostConstruct
	public void selectAllleaveInfo()
	   {  
		  model.setLeaveList(dao.selectAllLeave(ut, em));
	   }  
	

}
	
	
	
		