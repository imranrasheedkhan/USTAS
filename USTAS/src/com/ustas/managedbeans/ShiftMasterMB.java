package com.ustas.managedbeans;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.ustas.view.model.SwiftMasterViewModel;

@ManagedBean
@ViewScoped
public class ShiftMasterMB implements Serializable {
        
	   
	  private static final long serialVersionUID = 1L;
     
	  public ShiftMasterMB(){
    	  
      }
	
	//---------------------   Injections               ------------------------------
	
	@PersistenceContext(unitName="USTAS")
	EntityManager em;
	
	@Resource
	UserTransaction ut;
	
	//---------------------  View Model ------------------------------
	private SwiftMasterViewModel model=new SwiftMasterViewModel();

	public SwiftMasterViewModel getModel() {
		return model;
	}

	public void setModel(SwiftMasterViewModel model) {
		this.model = model;
	}
	
	
	
}
