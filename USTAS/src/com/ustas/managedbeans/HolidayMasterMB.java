package com.ustas.managedbeans;

import java.io.Serializable;
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
import com.ustas.db.dao.HolidayMasterDAO;
import com.ustas.db.model.HolidayInfo;
import com.ustas.view.model.HolidayMasterViewModel;

@ManagedBean
@ViewScoped
public class HolidayMasterMB implements Serializable {

	private static final long serialVersionUID = 1L;

	// --------------------- Injections ------------------------------

	@PersistenceContext(unitName = "USTAS")
	EntityManager em;

	@Resource
	UserTransaction ut;

	// ----------------------- Data Access Object
	// -------------------------------------
	 @ManagedProperty(value="#{ApplicationBean}")
	 private ApplicationBean appBean;
	   
	 
	
	public ApplicationBean getAppBean() {
		return appBean;
	}

	public void setAppBean(ApplicationBean appBean) {
		this.appBean = appBean;
	}

	private HolidayMasterDAO dao;

	

	public HolidayMasterMB() {
		model = new HolidayMasterViewModel();
		dao = new HolidayMasterDAO(em);
	}

	// ----------------------- Getter & Setter - View Model
	// -------------------------------------
	private HolidayMasterViewModel model;
	
	
	

	public HolidayMasterViewModel getModel() {
		return model;
	}

	public void setModel(HolidayMasterViewModel model) {
		this.model = model;
	}

	public void add() {

		dao.saveHoliday(model.getHolidayInfo(), em, ut);
		String message = appBean.applicationPropreties.getProperty("ADD_HOLIDAY");
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
	    model.setHolidayInfo(new HolidayInfo());
	    

	}

	public void Display() {

		List<HolidayInfo> holidayList = dao.displayHoliday(model.getSearchKey(), em, ut);
		model.setHolidayList(holidayList);

	}

	public void selectHoliday() {

		System.out.println("helooooooooo");
	}

	public void updateHoliday() {
		
		dao.updateHoliday(model.getHolidayInfo(), em, ut);
		String message = appBean.applicationPropreties.getProperty("UPDATE_HOLIDAY");
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
	    model.setHolidayInfo(new HolidayInfo());
	}

}
