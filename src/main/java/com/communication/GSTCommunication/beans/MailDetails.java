package com.communication.GSTCommunication.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailDetails {
	
	@JsonProperty("userName")
	private String userName;
	
	@JsonProperty("mailContent")
	private String mailContent;
	
	@JsonProperty("userMailId")
	private String userMailId;
	
	@JsonProperty("fromId")
	private String fromId;
	
	@JsonProperty("subject")
	private String subject;
	
	@JsonProperty("isNewMail")
	private boolean isNewMail;
	
	@JsonProperty("mailType")
	private String mailType;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMailContent() {
		return mailContent;
	}

	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	public String getUserMailId() {
		return userMailId;
	}

	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}

	public String getFromId() {
		return fromId;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public boolean getIsNewMail() {
		return isNewMail;
	}

	public void setIsNewMail(boolean isNewMail) {
		this.isNewMail = isNewMail;
	}

	public String getMailType() {
		return mailType;
	}

	public void setMailType(String mailType) {
		this.mailType = mailType;
	}
	
	
	
}
