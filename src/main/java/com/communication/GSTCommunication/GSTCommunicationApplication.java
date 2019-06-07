package com.communication.GSTCommunication;

import com.communication.GSTCommunication.api.SendMail;
import com.communication.GSTCommunication.utils.AerospikeManager;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class GSTCommunicationApplication extends Application<GSTCommunicationConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GSTCommunicationApplication().run(args);
    }

    @Override
    public String getName() {
        return "GSTCommunication";
    }

    @Override
    public void initialize(final Bootstrap<GSTCommunicationConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final GSTCommunicationConfiguration configuration,
                    final Environment environment) {
 
    	final SendMail  mail= new SendMail(configuration);
    	environment.jersey().register(mail);
        
    }

}
