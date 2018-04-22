package com.revature.gambit.messaging;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author chris
 * create send functions to send based on insert, update, or delete also add a UUID to the front of the message so the receiver
 * if it was the one that sent it
 *
 */
public class Sender {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	UUIDService UUIDService;
	
	/**
	 * sends a message to insert in another instance 
	 * @param topic which topic it is sending to
	 * @param payload should be a json object no spaces in it 
	 */
	public void sendInsert(String payload){
		payload=UUIDService.getServiceInstanceIdentifier().toString()+" "+payload;
		
		kafkaTemplate.send("batch.register.t", payload);
	}
		
	/**
	 * sends a message to update in another instance 
	 * @param topic which topic it is sending to
	 * @param payload should be a json object no spaces in it 
	 */
	public void sendUpdate(String payload){
		payload=UUIDService.getServiceInstanceIdentifier().toString()+" "+payload;
			
		kafkaTemplate.send("batch.update.t", payload);
	}
	/**
	 * sends a message to delete in another instance 
	 * @param topic which topic it is sending to
	 * @param payload should be a json object no spaces in it 
	 */
	public void sendDelete(String payload){
		payload=UUIDService.getServiceInstanceIdentifier().toString()+" "+payload;
			
		kafkaTemplate.send("batch.delete.t", payload);
	}
				
			
		
		
	

}
