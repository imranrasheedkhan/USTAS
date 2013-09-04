package com.ustas.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

import com.ustas.db.dao.ShiftMasterDAO;
import com.ustas.view.model.SwiftMasterViewModel;

@ManagedBean
@ViewScoped
public class ShiftMasterMB implements Serializable {
        
	   
	  private static final long serialVersionUID = 1L;
     
	//---------------------   Injections               ------------------------------
		
		@PersistenceContext(unitName="USTAS")
		EntityManager em;
	
	
		@Resource 
		UserTransaction ut;
	  
	   
		  
		public ShiftMasterMB(){
		    dao=new ShiftMasterDAO(em);
		//    selectBreakListItem();
    	   
        }
	
	   
	
	//---------------------  View Model ------------------------------
	private SwiftMasterViewModel model=new SwiftMasterViewModel();

	public SwiftMasterViewModel getModel(){
		return model;
	}

	public void setModel(SwiftMasterViewModel model) {
		this.model = model;
	}
	//--------------------- DAO model------------------------------	
	 private ShiftMasterDAO dao ;
	 
	 public void selectBreakListItem()
	   {   
		 List<SelectItem>list=dao.selectBreakList(null, null);
		 
		 model.setBreakSelectItemList(list);
	   }
	   
	 public void addShift()
	    { 
		   System.out.println("In the add method");
		   model.consolidateShift(model.getShiftInfo());
	 	   dao.addShift(model.getShiftInfo(), null, null);  
	 	   
	    }
	  
}
