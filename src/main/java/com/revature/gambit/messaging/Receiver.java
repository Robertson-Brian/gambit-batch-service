package com.revature.gambit.messaging;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.gambit.model.Batch;
import com.revature.gambit.services.BatchServiceImpl;

public class Receiver {
	
	@Autowired
	UUIDService UUIDService;
	
	@Autowired
	BatchServiceImpl batchService;
	
	/**
	 * @param payload add type and json object to update another instance database
	 * 
	 * also uses unique id for each microservice instance to check if it (mircoservice instance ) was the one that sent it 
	 */
	@KafkaListener(topics="${spring.kafka.topic.batch}")
	public void recieve(String payload) {
		ObjectMapper om = new ObjectMapper();
		System.out.println(payload);
		
		String[] a = payload.split(" ");
		if(a[0].equals(UUIDService.getServiceInstanceIdentifier().toString())) {
			
		}
		else {
			
			if(a[1].equals("insert")) {
				System.out.println(a[2]);
				try {
					Batch batch = om.readValue(a[2], Batch.class);
					batchService.save(batch);
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(a[1].equals("update")) {
				System.out.println(a[2]);
				try {
					Batch batch = om.readValue(a[2], Batch.class);
					batchService.update(batch);
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(a[1].equals("delete")) {
				System.out.println(a[2]);
				try {
					int id = om.readValue(a[2], Integer.class);
					batchService.delete(id);
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("Did not detect valid service operation");
			}
			
		}
		
	}

}
