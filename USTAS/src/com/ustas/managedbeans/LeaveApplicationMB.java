package com.ustas.managedbeans;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.ustas.application.managedbean.ApplicationBean;
import com.ustas.db.dao.LeaveApplicationDAO;
import com.ustas.db.model.EmpInfo;
import com.ustas.db.model.EmpLeaveAllotment;
import com.ustas.db.model.EmpLeaveAppEntry;
import com.ustas.helper.LeaveApprovalMail;
import com.ustas.view.model.LeaveApplicationViewModel;

@ManagedBean
@ViewScoped
public class LeaveApplicationMB implements Serializable{

	    private static final long serialVersionUID = 1L;
	  
	  //.............injection
	   
	    @PersistenceContext(unitName="USTAS")
	    EntityManager em;
	    
	    @Resource
	    UserTransaction ut;
	    
	    //.............Application bean
	    @ManagedProperty(value="#{ApplicationBean}")
		private ApplicationBean appBean;
	    
	    
	      
	    
	    
	    public ApplicationBean getAppBean() {
			return appBean;
		}

		public void setAppBean(ApplicationBean appBean) {
			this.appBean = appBean;
		}

		
		public LeaveApplicationMB(){
		     dao=new LeaveApplicationDAO(em);
		     model.getLeaveApplication().setApplicationDate(new Date());
	      }
	  
	    private LeaveApplicationViewModel model=new LeaveApplicationViewModel();
        
	    private LeaveApplicationDAO dao;
	    
	    public LeaveApplicationViewModel getModel() {
		   return model;
	      }

	    public void setModel(LeaveApplicationViewModel model) {
		   this.model = model;
    	 }
	  
	  //geting the leave info
	    
	   public void leaveInfo()
	     {
		      System.out.println("In the leave Info");
		      EmpInfo empInfo=dao.leaveInfo(model.getEmpInfo().getEmpNo(), em, ut);
		      if(empInfo==null)
		        {
		    	  String message = appBean.applicationPropreties.getProperty("INVALID_EMPID");
				  FacesContext.getCurrentInstance().addMessage("centreContentForm:emp_id", new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
		          model.getEmpInfo().setEmpNo("");
		          model.setTotalLeave(0);
		          model.setRemainingLeave(0);
		          model.setLeaveTaken(0);
		        }
		      else{
		            model.setEmpInfo(empInfo);
		            model.consolidateLeave(empInfo);
		            leaveType();
		      }
		    
		  }
	   
	   public void leaveType()
	    {
		  
		   if(model.getEmpInfo().getEmpLeaveAllotment()!=null)
		   {
		    for(EmpLeaveAllotment leaveAllotment:model.getEmpInfo().getEmpLeaveAllotment())
		     {
			   SelectItem leaveType=new SelectItem(leaveAllotment.getLeaveInfos().getIndexNo(),leaveAllotment.getLeaveInfos().getLeaveType());
			   
			   model.getLeaveTypeList().add(leaveType);
			   
		     }
		   }
	    }
	   
	   
	   public void addLeaveApp()
	    {
		   System.out.println("In the add leave application ");
		
		   model.getLeaveApplication().setEmpInfo(model.getEmpInfo());
		   for(EmpLeaveAllotment leaveAllotInfo:model.getEmpInfo().getEmpLeaveAllotment())
		    {
			   if(leaveAllotInfo.getLeaveInfos().getIndexNo()==model.getSelectedLeave().getIndexNo())
			   {
				   model.getLeaveApplication().setLeaveInfo(leaveAllotInfo.getLeaveInfos());
				   break;
			   }
				  
		   }
		    
		 
		    model.getEmpInfo().getEmpLeaveAppEntry().add(model.getLeaveApplication());
		    model.consolidateAddLeave();
		    dao.addLeaveApp(model.getEmpInfo(), em, ut);
		    if(!model.isApprove())
		     {	
		      String message = appBean.applicationPropreties.getProperty("ADD_SUCCESS");
			  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
			  model.clearData();
		     }
			
		   
		   } 
	      
	   public void approveLeave()  
	     {
		    model.setApprove(true);
		    System.out.println("In the Approval of leave application ");
		    String from= appBean.applicationPropreties.getProperty("LEAVE_CONFIRM_MAIL_FROM");
		    String host =appBean.applicationPropreties.getProperty("HOST");
		    model.getLeaveApplication().setApprovedBy(model.getApproveBy());
		    this.addLeaveApp();
		//    if(model.getLeaveApplication().getLeaveStatus())
		//    LeaveApprovalMail.sendMail(model.getEmpInfo().getOffEmail(),from,host);
		    String message = appBean.applicationPropreties.getProperty("LEAVE_APPROVE");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
			model.setApprove(false);
			model.clearData();
		    
	     }  
	  
	  
	   //search leaveApply
	   
	   public void selectLeaveApplyList()  
	     {
		    System.out.println("In the leaveApplication detail");
		    model.setLeaveApplyList(dao.selectLeaveApplication(model.getEmpNo(), em, ut));
		 }
	   
	   public void selectLeave()
	      {
		   
		   System.out.println("select leave for the approval");
		 
		   model.getSelectedLeave().setIndexNo(model.getLeaveApplication().getLeaveInfo().getIndexNo());
		   model.getLeaveAllotment().setIndexNo(model.getLeaveApplication().getLeaveInfo().getIndexNo());
		   model.setEmpInfo(model.getLeaveApplication().getEmpInfo());
		   model.setLeaveInfo(model.getLeaveApplication().getLeaveInfo());   
		   leaveType();
		   model.consolidateLeave(model.getEmpInfo());
		      
		  }
	   

}
