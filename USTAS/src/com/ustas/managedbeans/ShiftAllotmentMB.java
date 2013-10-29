package com.ustas.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.ustas.application.managedbean.ApplicationBean;
import com.ustas.db.dao.ShiftAllotmentDAO;
import com.ustas.db.model.EmpInfo;
import com.ustas.db.model.EmpShiftAllotment;
import com.ustas.db.model.ShiftInfo;
import com.ustas.view.model.ShiftAllotmentViewModel;

@ManagedBean
@ViewScoped
public class ShiftAllotmentMB implements Serializable {
	
	  private static final long serialVersionUID = 1L;
	  
	//---------------------   Injections               ------------------------------
		
			@PersistenceContext(unitName="USTAS")
			EntityManager em;
		
		
			@Resource 
			UserTransaction ut;    
			
			public ShiftAllotmentMB(){
				System.out.println("in managed bean");    
				shiftDAO= new ShiftAllotmentDAO(em);
				shiftModel.getEmpshift().setAllotmentDate(new Date());
				
			}
		  //--------- View Model --------------
			  //.............Application bean
		    @ManagedProperty(value="#{ApplicationBean}")
			private ApplicationBean appBean;
		    
			
			
		public ApplicationBean getAppBean() {
				return appBean;
			}

			public void setAppBean(ApplicationBean appBean) {
				this.appBean = appBean;
			}
		private ShiftAllotmentViewModel shiftModel=new ShiftAllotmentViewModel();

		public ShiftAllotmentViewModel getShiftModel() {
			return shiftModel;
		}

		public void setShiftModel(ShiftAllotmentViewModel shiftModel) {
			this.shiftModel = shiftModel;
		}
		
//---------------ShiftAllotment DAO----------
		
		private ShiftAllotmentDAO shiftDAO ;

		
		public  void addShiftAllotment(){
			System.out.println("in Allotment of Shift");
			 for( EmpInfo shiftEmp:shiftModel.getEmpList())
			     {
				 if(shiftEmp.isFlag()){
			       shiftModel.consolidateMonthyear();
			       shiftEmp.getEmpShiftAllotments().get(0).setAllotmentDate(shiftModel.getEmpshift().getAllotmentDate());
			       shiftEmp.getEmpShiftAllotments().get(0).setFromDate(shiftModel.getEmpshift().getFromDate());
			       shiftEmp.getEmpShiftAllotments().get(0).setToDate(shiftModel.getEmpshift().getToDate());
			       shiftEmp.getEmpShiftAllotments().get(0).setForYear(shiftModel.getEmpshift().getForYear());
			       shiftEmp.getEmpShiftAllotments().get(0).setForMonth(shiftModel.getEmpshift().getForMonth());
			       shiftEmp.getEmpShiftAllotments().get(0).setEmpInfo(shiftEmp);
			       shiftDAO.saveShiftAllotment(shiftEmp,em,ut);
			       ShiftInfo shiftInfo= shiftDAO.selectAllotedShift(shiftEmp.getEmpShiftAllotments().get(0).getShiftInfo().getIndexNo(),em,ut);
			       ShiftAllotmentViewModel.sendMail(shiftEmp,shiftEmp.getEmpShiftAllotments().get(0),shiftInfo);  
				   }    
			     }
			
			System.out.println("in Allotment");
			
			System.out.println("save");
			String message = appBean.applicationPropreties.getProperty("ADD_SHIFT");
		    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
			shiftModel.setEmpshift(new EmpShiftAllotment());
			
		}
		public void updateShiftAllotment(){
			 System.out.println("In the Update Shift Allotment");
			 ShiftInfo upDateShiftInfo=null;
			for(EmpShiftAllotment empShiftAllotment: shiftModel.getEmpAllotedList()) 
			 {
			  if(empShiftAllotment.isShiftAlloted())
			   {
				upDateShiftInfo=new ShiftInfo();
				upDateShiftInfo.setIndexNo(empShiftAllotment.getTempShiftIndex());
			    upDateShiftInfo.setShiftAllotment(empShiftAllotment);
			    empShiftAllotment.setShiftInfo(upDateShiftInfo);
				shiftModel.setEmpshift(empShiftAllotment);
				shiftModel.consolidateMonthyear();
			    shiftDAO.updateShiftAllotment(empShiftAllotment, em, ut);
			    }  
			 }
			String message = appBean.applicationPropreties.getProperty("UPDATE_SHIFT");
		    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
			
		}
		public void displayShiftAllotment(){
		
			List<EmpInfo> empList= shiftDAO.selectemployees(em, ut);
			EmpShiftAllotment newAllotment= null;
			ShiftInfo newShiftInfo=null;
			for(EmpInfo empInfo: empList)
			 {
				if( empInfo.getEmpShiftAllotments().size()>0)
				{
				 for(EmpShiftAllotment shiftAllotment : empInfo.getEmpShiftAllotments())
				     {
					  if(shiftModel.getEmpshift().getFromDate().compareTo(shiftAllotment.getToDate())<=0
							  && shiftModel.getEmpshift().getToDate().compareTo(shiftAllotment.getFromDate())>=0){  
						empInfo.getEmpShiftAllotments().add(0,shiftAllotment); 
						empInfo.setShiftAlloted(true);
					   }
					  else
					  {
						  newAllotment=new EmpShiftAllotment();
						  newShiftInfo=new ShiftInfo();
						  newAllotment.setShiftInfo(newShiftInfo);
					      empInfo.getEmpShiftAllotments().add(0,newAllotment); 
					  }  
					  break;
				     }
				  }
				else
				  {
					newAllotment=new EmpShiftAllotment();
					newShiftInfo=new ShiftInfo();
					newAllotment.setShiftInfo(newShiftInfo);
					empInfo.getEmpShiftAllotments().add(0,newAllotment); 
				  }
			 }
			
			shiftModel.setEmpList(empList);
			shifDetails();
			System.out.println("in list");
		
			
		}
		
		public void shifDetails(){
			System.out.println("in shift Detail");
			List<SelectItem> itemList=new ArrayList<>();
			List<ShiftInfo> shiftItemList = shiftDAO.selectShift(em, ut); 
			for(ShiftInfo shiftInfo:shiftItemList)
			 {
				itemList.add(new SelectItem(shiftInfo.getIndexNo(),shiftInfo.getShiftName()));
			 }
			
			
			shiftModel.setShiftItemList(itemList);  
			
			
		}
		
	 public void viewAllotedShift()
	       {
			 System.out.println("in update shift Allotment");
			 shiftModel.setEmpAllotedList(shiftDAO.viewShiftAlloment(em, ut,shiftModel.getSearchKey()));
			 for(EmpShiftAllotment shiftAllotment:shiftModel.getEmpAllotedList())
			  {
				 shiftAllotment.setTempShiftIndex(shiftAllotment.getShiftInfo().getIndexNo());
			  }
		     shifDetails();
	        }
		
}
