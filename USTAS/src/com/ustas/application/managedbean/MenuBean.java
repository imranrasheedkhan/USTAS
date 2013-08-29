package com.ustas.application.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
@ManagedBean
@SessionScoped
public class MenuBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 
	 private String pageName;
	 
	 private int count;

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	 
	public void logout(ActionEvent event)
	{
		HttpSession session;
		
		if(FacesContext.getCurrentInstance().getExternalContext().getSession(false) instanceof HttpSession){
			session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
			if(session != null)
			{
				session.invalidate();
			}
		}
	}
	
	public String login()
	{
		HttpSession session;
		
		if(FacesContext.getCurrentInstance().getExternalContext().getSession(false) instanceof HttpSession){
			session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
			if(session != null) 
			{
				session.invalidate();
			}
		}
		
		return "compositions/home.xhtml?faces-redirect=true";
	}  
	

}
