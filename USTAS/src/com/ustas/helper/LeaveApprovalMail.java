package com.ustas.helper;

import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class LeaveApprovalMail {
	
	
	  public static void sendMail(String recepiant,String from,String host)
	    {  
		  
		   Properties properties = System.getProperties();
		//   properties.setProperty("mail.smtp.host", "gmail.com");
		   Session session = Session.getDefaultInstance(properties);  
		   
		   try{
		         // Create a default MimeMessage object.
		         MimeMessage message = new MimeMessage(session);  
  
		         // Set From: header field of the header.
		         message.setFrom(new InternetAddress(from));

		         // Set To: header field of the header.
		         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepiant));

		         // Set Subject: header field
		         message.setSubject("This is the Subject Line!");  

		         // Now set the actual message
		         message.setText("You Leave has been approve");
		         Transport transport = session.getTransport("smtps");
		         transport.connect("smtp.gmail.com", 465, "tariq.amu2008*@gmail.com", "t@riqkhan");
		         transport.sendMessage(message, message.getAllRecipients());
		         transport.close();
		    //     Transport.send(message);
		         System.out.println("Sent message successfully....");
		      }catch (MessagingException mex) {
		         mex.printStackTrace();
		      }
		   }
  
		   
		}


