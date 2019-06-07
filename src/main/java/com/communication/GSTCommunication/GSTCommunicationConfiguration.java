package com.communication.GSTCommunication;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.eclipse.jetty.server.handler.ContextHandler.StaticContext;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class GSTCommunicationConfiguration extends Configuration {
    // TODO: implement service configuration
	public  String apiKey;
	public  String hostName;
	public  int port;
	public  String namespace;
	public  String setName;
	
	@JsonProperty
	public String getApiKey() {
		return apiKey;
	}
	@JsonProperty
	public String getHostName() {
		return hostName;
	}
	@JsonProperty
	public int getPort() {
		return port;
	}
	@JsonProperty
	public String getNamespace() {
		return namespace;
	}
	@JsonProperty
	public String getSetName() {
		return setName;
	}
	
}
