package com.ustas.managedbeans;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;
import com.ustas.db.dao.HolidayMasterDAO;
import com.ustas.db.model.HolidayInfo;
import com.ustas.view.model.HolidayMasterViewModel;



@ManagedBean
@ViewScoped
public class HolidayMasterMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	
    
	
	
	
	//---------------------   Injections               ------------------------------
	
		@PersistenceContext(unitName="USTAS")
		EntityManager em;
		
		@Resource
		UserTransaction ut;       
		  
		
		//----------------------- Data Access Object -------------------------------------
				private HolidayMasterDAO HolidayDAO;
				
				public HolidayMasterViewModel getModel() {
					return Model;
				}

				public void setModel(HolidayMasterViewModel model) {
					Model = model;
				}
		
		public HolidayMasterMB(){
			Model = new HolidayMasterViewModel();
			HolidayDAO= new HolidayMasterDAO(em);
		}
		 
		//----------------------- Getter & Setter - View Model -------------------------------------
		private HolidayMasterViewModel Model;

		
		
		
		
		public  void  add() 
		 {
//			System.out.println("Hello");
//			
//			System.out.println(Model.getHolidayInfo().getHolidayName());
//			System.out.println(Model.getHolidayInfo().getHolidayDesc());
//			System.out.println(Model.getHolidayInfo().getHolidayType());
//			System.out.println(Model.getHolidayInfo().getToDate());
//			System.out.println(Model.getHolidayInfo().getRemarks());
//			System.out.println(Model.getHolidayInfo());
			  
			HolidayDAO.saveHoliday(Model.getHolidayInfo(), em, ut);
			
		 }
		
		
		
		
		
		public void  Display(){
		//System.out.println("In Display function");
		//List <HolidayInfo>holidayList = HolidayDAO.displatHoliday(Model.getHolidayInfo(),em,ut);
		java.util.List<HolidayInfo> holidayList=HolidayDAO.displayHoliday(Model.getHolidayInfo().getHolidayName(),em,ut);
		Model.setHolidayList(holidayList);
		
			
		}  
		
		
		
         public void selectHoliday(){
			
			System.out.println("helooooooooo");  
		}
		
		public void updateHoliday(){
		//	System.out.println("In Update function");
			HolidayDAO.updateHoliday(Model.getHolidayInfo(), em, ut);
		}
		
		
	
	
}
