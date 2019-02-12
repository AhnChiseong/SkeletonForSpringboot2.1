package com.ahnstar.skeleton.utils.mail;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="mail")
public class MailProperties {
//	host: 'smtp.naver.com'
//	    port: 465
//	    user: 'nalrary14'
//	    password: 'faith8!'
//	    sender: 'nalrary14@gmail.com'
	
	private String host;
	private int port;
	private String user;
	private String password;
	private String sender;
	private List<String> receiver;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public List<String> getReceiver() {
		return receiver;
	}
	public void setReceiver(List<String> receiver) {
		this.receiver = receiver;
	}
	@Override
	public String toString() {
		return "MailProperties [host=" + host + ", port=" + port + ", user=" + user + ", password=" + password
				+ ", sender=" + sender + ", receiver=" + receiver + "]";
	}
	
		
}
