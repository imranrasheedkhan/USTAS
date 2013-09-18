package com.ustas.managedbeans;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.ustas.application.managedbean.ApplicationBean;
import com.ustas.db.dao.AttendanceProcessDAO;
import com.ustas.view.model.AttendanceProcessViewModel;

@ManagedBean
@ViewScoped
public class AttendanceProcessMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	  
	  //.............injection
	   
	    @PersistenceContext(unitName="USTAS")
	    EntityManager em;
	    
	    @Resource
	    UserTransaction ut;
	    
	    
	    
	    //.............Application bean
	    @ManagedProperty(value="#{ApplicationBean}")
		private ApplicationBean appBean;
	    
	    public AttendanceProcessMB()  
	     {
	    	dao=new AttendanceProcessDAO(em);
	    	model.buildMonthOptions();
	     }
	    
	    private AttendanceProcessDAO dao;
	    
	    private AttendanceProcessViewModel model=new AttendanceProcessViewModel();
	    
	      
	    
	  public ApplicationBean getAppBean() {
			return appBean;
		}



		public void setAppBean(ApplicationBean appBean) {
			this.appBean = appBean;
		}



		public AttendanceProcessViewModel getModel() {
			return model;
		}



		public void setModel(AttendanceProcessViewModel model) {
			this.model = model; 
		}



		//...........view the detail  
	    public void  viewAttendanceDetail()
	         {
	    	   System.out.println("Attendance detail");
	    	   model.setAttendanceList(dao.viewAttendanceDetail(model.getSerchEmpNo(), model.getMonth(),model.getSearchDate(), em, ut));
	         }
	    
	    
	     public static void processAttendance()
	       {
	    	  System.out.println("In the Attendance Process");
	    	  
	       }
   
}  
