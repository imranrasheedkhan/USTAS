package com.ustas.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

import org.richfaces.component.UIDataTable;

import com.ustas.application.managedbean.ApplicationBean;
import com.ustas.db.dao.ShiftMasterDAO;
import com.ustas.db.model.BreakInfo;
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
	  
		@ManagedProperty(value="#{ApplicationBean}")
	     private ApplicationBean appBean;
		  
		public ShiftMasterMB(){
		    dao=new ShiftMasterDAO(em);
		    model.getBreakList().clear();
		//    selectBreakListItem();
		 //   selectShiftDetail();
    	   
        }
	
	   
	
	public ApplicationBean getAppBean() {
			return appBean;
		}

		public void setAppBean(ApplicationBean appBean) {
			this.appBean = appBean;
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
	 
	 List<BreakInfo> list=null ;
	 
	 public void selectBreakListItem()
	   {   
		 List<SelectItem> itemList=new ArrayList<>();
		 list=dao.selectBreakList(ut, em);
		 for(BreakInfo item:list)
		  {
			 itemList.add(new SelectItem(item.getIndexNo(), item.getBreakType()));
		  }
		 model.setBreakSelectItemList(itemList);
	   }
	 
	 public void addMoreBreak()  
	  {
		
		 System.out.println("In the addMore filed");
		 selectBreakListItem();
		 model.getBreakList().add(new BreakInfo());
		 
	  }
	 
	 public void breakChangeListener(ValueChangeEvent e)
	  {
		   System.out.println("In the break change ");
	    	int breakValue= (int) e.getNewValue();
	    	UIDataTable data = (UIDataTable) e.getComponent().findComponent("table");
	        int rowIndex = data.getRowIndex();
		 for(BreakInfo itemInfo:list)
		  {
			 if(breakValue==itemInfo.getIndexNo())
			 {  
				model.getBreakList().get(rowIndex).setStartTime(itemInfo.getStartTime());
				model.getBreakList().get(rowIndex).setEndTime(itemInfo.getEndTime());
				 
			 }  
		 }
	   } 
	
	  public void selectShiftupdate()
	    {
	 	   System.out.println("in the select shift");
	 	   selectBreakListItem();
	 	   model.breakShift();
	    }
		 
	 
	   
	 public void addShift()
	    { 
		   System.out.println("In the add method");
		   model.consolidateShift(model.getShiftInfo());
	 	   dao.addShift(model.getShiftInfo(), em, ut); 
	 	   String message = appBean.applicationPropreties.getProperty("ADD_SHIFT");
	 	   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
	 	   
	    }
	    
	 public void selectShiftDetail()
	   {
		   System.out.println("In the Select method");
		   model.setShiftDetailList(dao.selectShift(model.getSearchShift(),em, ut));
	   } 
	 
	 
	 public void updateShift()
	  {
		 System.out.println("In update Shift");
		 model.consolidateShift(model.getShiftInfo());
		 dao.updateShift(model.getShiftInfo(), em, ut); 
		 String message = appBean.applicationPropreties.getProperty("UPDATE_SHIFT");
	 	 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
		 
	  }
	  
}
