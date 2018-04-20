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
	public void sendInsert(String topic, String payload){
		payload=UUIDService.getServiceInstanceIdentifier().toString()+" "+"insert "+payload;
		
		kafkaTemplate.send(topic, payload);
	}
		
	/**
	 * sends a message to update in another instance 
	 * @param topic which topic it is sending to
	 * @param payload should be a json object no spaces in it 
	 */
	public void sendUpdate(String topic, String payload){
		payload=UUIDService.getServiceInstanceIdentifier().toString()+" "+"update "+payload;
			
		kafkaTemplate.send(topic, payload);
	}
	/**
	 * sends a message to delete in another instance 
	 * @param topic which topic it is sending to
	 * @param payload should be a json object no spaces in it 
	 */
	public void sendDelete(String topic, String payload){
		payload=UUIDService.getServiceInstanceIdentifier().toString()+" "+"delete "+payload;
			
		kafkaTemplate.send(topic, payload);
	}
				
			
		
		
	

}
