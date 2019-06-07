package com.communication.GSTCommunication.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailDeliveryStatus {
	@JsonProperty("Status")
	private String status;
	@JsonProperty("UserMailId")
	private String userMailId;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserMailId() {
		return userMailId;
	}
	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}
	
	
}
