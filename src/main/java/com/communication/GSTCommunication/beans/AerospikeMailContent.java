package com.communication.GSTCommunication.beans;

public class AerospikeMailContent {

	private String typeOfMail;
	private String subject;
	private String Content;
	public String getTypeOfMail() {
		return typeOfMail;
	}
	public void setTypeOfMail(String typeOfMail) {
		this.typeOfMail = typeOfMail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	
}
