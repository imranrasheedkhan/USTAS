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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.ustas.application.managedbean.ApplicationBean;
import com.ustas.db.dao.BadgeMasterDAO;
import com.ustas.db.model.BadgeInfo;
import com.ustas.db.model.EmpInfo;
import com.ustas.view.model.BadgeMasterViewModel;



@ManagedBean
@ViewScoped

public class BadgeMasterMB implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="USTAS")
	EntityManager em;
	
	
	@Resource
	UserTransaction ut;
	
	@ManagedProperty(value="#{ApplicationBean}")
	private ApplicationBean appBean;
	
	private BadgeMasterDAO dao = new BadgeMasterDAO(em);
	
	
	private BadgeMasterViewModel model=new BadgeMasterViewModel();

	public BadgeMasterViewModel getModel() {
		return model;
	}

	public void setModel(BadgeMasterViewModel model) {
		this.model = model;
	}
	
	public ApplicationBean getAppBean() {
		return appBean;
	}

	public void setAppBean(ApplicationBean appBean) {
		this.appBean = appBean;
	}
   
	
	@PostConstruct
	public void display()
	 {
	    BadgeInfo badgeInfo ;
		List<EmpInfo>empList=dao.displayBadge(model.getSearchkey(), em, ut);
		model.setEmpList(empList);
	    for(EmpInfo empInfo:empList)
	     { 
	    	if(empInfo.getBadgeInfo()==null)
	    	{
	    	 empInfo.setShiftAlloted(true);	
	    	 badgeInfo=new BadgeInfo();
	    	 empInfo.setBadgeInfo(badgeInfo);
	    	 badgeInfo.setEmpInfo(empInfo);
	    	 badgeInfo.setEmpName(empInfo.getFirstName()+empInfo.getLastName());
	    	}
	    	
	    	
	     }
	    
	    
		
		
	}
	
	  @PostConstruct
	  public void selectAllBadgeList()
     	{
		  List<BadgeInfo> badgeList=dao.selectBadge(model.getSearchkey(), em, ut);
		  model.setBadgeList(badgeList);
		  
		
	    }
	
	public void save()
	 {
		
	   for(EmpInfo badgeEmp:model.getEmpList())
		  {
		
		   if(badgeEmp.isFlag()) 
		     dao.addbadge(badgeEmp, em, ut); 
		   
			
		 }
		
	      String message = appBean.applicationPropreties.getProperty("ADD_BADGE");
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
	} 
	
	public void updateBadge()
	{
		System.out.println("in update");
		for(BadgeInfo badgInfo:model.getBadgeList())
		 {
		     if(badgInfo.getEmpInfo().isFlag())
		     dao.updateBadge(badgInfo, em, ut);
		 }
		String message = appBean.applicationPropreties.getProperty("UPDATE_BADGE");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
	}

	
}
