package com.communication.GSTCommunication.api;

import java.io.IOException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import com.communication.GSTCommunication.GSTCommunicationConfiguration;
import com.communication.GSTCommunication.beans.AerospikeMailContent;
import com.communication.GSTCommunication.beans.MailDeliveryStatus;
import com.communication.GSTCommunication.beans.MailDetails;
import com.communication.GSTCommunication.utils.AerospikeManager;
import com.communication.GSTCommunication.utils.Constants;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;

import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Path("/sendMail")
@Produces(MediaType.APPLICATION_JSON)
public class SendMail {
	GSTCommunicationConfiguration gstConfiguration;

	public SendMail(GSTCommunicationConfiguration configuration) {
		// TODO Auto-generated constructor stub
		gstConfiguration = configuration;
	}

	@POST
	public MailDeliveryStatus sendMailToUser(MailDetails details) {
		AerospikeManager manager = new AerospikeManager();
		MailDeliveryStatus mailStatus = new MailDeliveryStatus();

		if (details.getIsNewMail() == true) {

			/** storing data in Aerospike */
			manager.putDataInAerospike(details.getMailType(), details.getSubject(), details.getMailContent(),
					gstConfiguration);
		}
		/** Retrieving data from Aerospike */

		AerospikeMailContent mailContent = manager.scandata(details.getMailType(), gstConfiguration);

		/** Sending mail operations using sendGrid */
		Email from = new Email(details.getFromId());
		String subject = mailContent.getSubject();
		Email to = new Email(details.getUserMailId());
		Content content = new Content("text/plain", mailContent.getContent());
		Mail mail = new Mail(from, subject, to, content);
		SendGrid sg = new SendGrid(gstConfiguration.getApiKey());
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			if (response.getStatusCode() == 202) {
				mailStatus.setStatus(Constants.SUCCESS);
				mailStatus.setUserMailId(details.getUserMailId());
				return mailStatus;
			}
		} catch (IOException ex) {
			System.out.print(ex);
		}
		mailStatus.setStatus(Constants.FAILED);
		mailStatus.setUserMailId(details.getUserMailId());
		return mailStatus;

	}
}
