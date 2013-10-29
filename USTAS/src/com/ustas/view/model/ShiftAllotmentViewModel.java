package com.ustas.view.model;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import com.ustas.db.model.EmpInfo;
import com.ustas.db.model.EmpShiftAllotment;
import com.ustas.db.model.ShiftInfo;

import javax.faces.model.SelectItem;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.xml.fastinfoset.sax.Properties;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;




public class ShiftAllotmentViewModel implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	public ShiftAllotmentViewModel(){
		
		
	}
	
    private	EmpShiftAllotment empshift = new EmpShiftAllotment();

	public EmpShiftAllotment getEmpshift() {
		return empshift;
	}
	public void setEmpshift(EmpShiftAllotment empshift) {
		this.empshift = empshift;
	}
	
	
	private EmpInfo empInfo = new EmpInfo();
	
	 public EmpInfo getEmpInfo() {
			return empInfo;
		}
		public void setEmpInfo(EmpInfo empInfo) {
			this.empInfo = empInfo;
		}
	
		
		public static void sendMail(EmpInfo empInfo,EmpShiftAllotment shiftAlloted,ShiftInfo shiftInfo){
			
			final String to =empInfo.getOffEmail();
			 DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
			javax.mail.PasswordAuthentication authenticator = new javax.mail.PasswordAuthentication("tariq.amu2008@gmail.com","pass");  
			try{
			 String from ="tariq.amu2008@gmail.com";
			 String SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";
			 final String SMTP_HOST_NAME = "smtp.gmail.com";
			 String PORT = "465";
			// String Filepath ="E:\\USMS\\Files_64_khanSalarySlip.pdf";
			  java.util.Properties properties = System.getProperties();
			  properties.put("mail.smtp.host", "192.168.2.12");
			  properties.put("mail.stmp.user" , "shaikabid23@gmail.com	");
			  properties.put("mail.stmp.password" , "xxxxxx");
			  properties.put("mail.smtp.auth", "true");
			//properties.put("mail.smtp.starttls.enable", "STARTTLS");
			  properties.put("mail.smtp.socketFactory.port", PORT);
			  properties.put("mail.smtp.socketFactory.class", SOCKET_FACTORY);
			  properties.put("mail.smtp.socketFactory.fallback", "false");
			  properties.put("mail.smtp.auth", "true");
			  properties.put("mail.debug", "true");  
			
			  Session session = Session.getDefaultInstance(properties);  
			  InternetAddress addressFrom = new InternetAddress(from);	
			  
				MimeMessage msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress(from));
				msg.addRecipients(javax.mail.Message.RecipientType.TO, to);
				System.out.println("heloooo");
				BodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setText("You have been Alloted " + shiftInfo.getShiftName() + "  Shift from"+df.format(shiftAlloted.getFromDate())+
						 "To " +df.format(shiftAlloted.getToDate())+ " The working time is from  "+shiftInfo.getInTime() + 
						 " To " +shiftInfo.getOutTime() + "." );
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart);
				messageBodyPart = new MimeBodyPart();
				//DataSource source = new FileDataSource(Filepath);
			   
				//messageBodyPart.setDataHandler(new DataHandler(source));
			//
				//messageBodyPart.setFileName(Filepath);
				 
				//multipart.addBodyPart(messageBodyPart);
			
				 Transport transport = session.getTransport("smtp");
				 msg.setSubject("Shift Allotment");		    
			     msg.setContent(multipart);	
			
		        transport.connect( "smtp.gmail.com" , "tariq.amu2008@gmail.com" , "pass" );
		         
			 
			 transport.sendMessage(msg, msg.getAllRecipients());
				System.out.println("Successs");
			    }catch(Exception e){
				e.printStackTrace();
			

		     }
			
		}  
	
	
		 
		// ---- for month and year -----
			public void consolidateMonthyear(){
				System.out.println("in consolidation");
				
			 System.out.println("in consolidation "+(getEmpshift().getFromDate()));
			// String test =getEmpshift().getFromDate();
//			 int year =Integer.parseInt( formate1.format(getEmpshift().getFromDate()));
//			 System.out.println(year+"test"+month);
			 empshift.setForYear(getEmpshift().getFromDate().getYear()+1900);
			 empshift.setForMonth(getMonthFromInt(getEmpshift().getFromDate().getMonth()));
			 
			}	  
			
			public String getMonthFromInt(int iMonth)
			   {
				String month = "invalid";
				DateFormatSymbols dfs = new DateFormatSymbols();
				String[] months = dfs.getMonths();
				 if (iMonth >= 0 && iMonth <= 11)
				    month = months[iMonth];
				  return month;
			   }
			
			List<SelectItem> shiftItemList=new ArrayList<>();	
			
			private List<EmpInfo> empList;

			public List<EmpInfo> getEmpList() {
				return empList;
			}
			public void setEmpList(List<EmpInfo> empList) {
				this.empList = empList;
			}
			
			private List<ShiftInfo> shiftList;

			public List<ShiftInfo> getShiftList() {
				return shiftList;
			}
			public void setShiftList(List<ShiftInfo> shiftList) {
				this.shiftList = shiftList;
			}
			
		  
			
			public List<SelectItem> getShiftItemList() {
				return shiftItemList;
			}
			public void setShiftItemList(List<SelectItem> shiftItemList) {
				this.shiftItemList = shiftItemList;
			}
			
			
	       // Alloted List
			
			private List<EmpShiftAllotment> empAllotedList=new ArrayList<>();
			
			private String searchKey;

			public List<EmpShiftAllotment> getEmpAllotedList() {
				return empAllotedList;
			}
			public void setEmpAllotedList(List<EmpShiftAllotment> empAllotedList) {
				this.empAllotedList = empAllotedList;
			}
			public String getSearchKey() {
				return searchKey;
			}
			public void setSearchKey(String searchKey) {
				this.searchKey = searchKey;
			}

			
			
	
}
