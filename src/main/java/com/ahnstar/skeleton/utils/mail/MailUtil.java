package com.ahnstar.skeleton.utils.mail;

import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MailUtil {
	
	public void sendMail(MailProperties mailProperties, String subject, String content) {
		
		List<String> list = mailProperties.getReceiver();
		for(String receiver : list) {
			try {
				
				Email email = new SimpleEmail();
				email.setHostName(mailProperties.getHost());
				email.setSmtpPort(mailProperties.getPort());
				email.setAuthenticator(new DefaultAuthenticator(mailProperties.getUser(), mailProperties.getPassword()));
				email.setSSL(true);
				email.setFrom(mailProperties.getSender());
				email.setSubject(subject);
				email.setMsg(content);
				email.addTo(receiver);
				
				System.out.println(email.toString());
				email.send();
				
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
