package com.revature.gambit.messaging;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class Receiver {
	
	@Autowired
	UUIDService UUIDService;
	
	/**
	 * @param payload add type and json object to update another instance database
	 * 
	 * also uses unique id for each microservice instance to check if it (mircoservice instance ) was the one that sent it 
	 */
	@KafkaListener(topics="${spring.kafka.topic.helloworld}")
	public void recieve(String payload) {
		
		String[] a = payload.split(" ");
		if(a[0].equals(UUIDService.getServiceInstanceIdentifier().toString())) {
			
		}
		else {
			
			//toDo based on (insert, update, or delete) 
			
		}
		
	}

}
