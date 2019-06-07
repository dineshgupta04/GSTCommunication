package com.communication.GSTCommunication.utils;


import com.aerospike.client.AerospikeClient;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.ScanCallback;
import com.aerospike.client.policy.Priority;
import com.aerospike.client.policy.ScanPolicy;
import com.aerospike.client.policy.WritePolicy;
import com.communication.GSTCommunication.GSTCommunicationConfiguration;
import com.communication.GSTCommunication.beans.AerospikeMailContent;

public class AerospikeManager {
	
	private static AerospikeClient client;

	/** Put data in Aerospike based on PK*/
	public void putDataInAerospike(String msgType, String subject, String content,GSTCommunicationConfiguration config) {
		client = new AerospikeClient(config.getHostName(), config.getPort());
		WritePolicy writePolicy = new WritePolicy();
		Key key = new Key(config.getNamespace(), config.getSetName(), msgType);
		Bin bin = new Bin(Constants.typeofmail, msgType);
		Bin bin1 = new Bin(Constants.Subject, subject);
		Bin bin2 = new Bin(Constants.mailContent, content);
		client.put(writePolicy, key, bin, bin1, bin2);
	
	}

	/** Get data based on PK from Aerospike */
	public AerospikeMailContent scandata(String msgType,GSTCommunicationConfiguration config) {
		AerospikeMailContent content = new AerospikeMailContent();
		try {
			client = new AerospikeClient(config.hostName, config.getPort());
			ScanPolicy policy = new ScanPolicy();
			policy.concurrentNodes = true;
			policy.priority = Priority.LOW;
			policy.includeBinData = false;
			Key key = new Key(config.getNamespace(), config.getSetName(), msgType);
			Record record = client.get(policy, key);
			content.setTypeOfMail(record.getValue(Constants.typeofmail).toString());
			content.setSubject(record.getValue(Constants.Subject).toString());
			content.setContent(record.getValue(Constants.mailContent).toString());
		} finally {
			client.close();
		}

		return content;

	}
}
