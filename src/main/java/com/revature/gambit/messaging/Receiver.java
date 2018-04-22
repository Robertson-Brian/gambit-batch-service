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
	 * @param payload json object to update another instance database
	 * 
	 * also uses unique id for each microservice instance to check if it (mircoservice instance ) was the one that sent it 
	 * batch_insert is used for inserts
	 */
	@KafkaListener(topics="${spring.kafka.topic.batch.register}")
	public void recieveInsert(String payload) {
		ObjectMapper om = new ObjectMapper();
		System.out.println(payload);
		
		String[] a = payload.split(" ");
		//Checks if the services are different
		if(!a[0].equals(UUIDService.getServiceInstanceIdentifier().toString())) {
			System.out.println(a[1]);
			try {
				Batch batch = om.readValue(a[1], Batch.class);
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
		}
	}
	
	
	/**
	 * @param payload json object to update another instance database
	 * 
	 * also uses unique id for each microservice instance to check if it (mircoservice instance ) was the one that sent it
	 * batch_update is used for updates 
	 */
	@KafkaListener(topics="${spring.kafka.topic.batch.update}")
	public void recieveUpdate(String payload) {
		ObjectMapper om = new ObjectMapper();
		System.out.println(payload);
		
		String[] a = payload.split(" ");
		//Checks if the services are different
		if(!a[0].equals(UUIDService.getServiceInstanceIdentifier().toString())) {
			System.out.println(a[1]);
			try {
				Batch batch = om.readValue(a[1], Batch.class);
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
		}
	}
	
	/**
	 * @param payload json object to update another instance database
	 * 
	 * also uses unique id for each microservice instance to check if it (mircoservice instance ) was the one that sent it
	 * batch_delete is used for deletes 
	 */
	@KafkaListener(topics="${spring.kafka.topic.batch.delete}")
	public void recieveDelete(String payload) {
		ObjectMapper om = new ObjectMapper();
		System.out.println(payload);
		
		String[] a = payload.split(" ");
		//Checks if the services are different
		if(!a[0].equals(UUIDService.getServiceInstanceIdentifier().toString())) {
			System.out.println(a[1]);
			try {
				int id = om.readValue(a[1], Integer.class);
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
		}
	}

}
