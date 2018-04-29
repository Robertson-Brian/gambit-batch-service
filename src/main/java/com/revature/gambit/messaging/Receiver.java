package com.revature.gambit.messaging;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.gambit.model.Batch;
import com.revature.gambit.services.BatchServiceImpl;
import com.revature.gambit.util.LoggingUtil;

@Component
public class Receiver {
	
	@Autowired
	UUIDService UUIDService;
	
	@Autowired
	BatchServiceImpl batchService;
	
	//CountDownLatch is used in testing to confirm a message was recieved
	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}
	
	/**
	 * @param payload json object to update another instance database
	 * 
	 * also uses unique id for each microservice instance to check if it (mircoservice instance ) was the one that sent it 
	 * batch_insert is used for inserts
	 */
	@KafkaListener(topics="${spring.kafka.topic.batch.register}")
	public void recieveInsert(String payload) {
		ObjectMapper om = new ObjectMapper();
		LoggingUtil.logInfo(payload);
		
		String[] a = payload.split(" ", 2);
		if(!a[0].equals(UUIDService.getServiceInstanceIdentifier().toString())) {
			LoggingUtil.logInfo(a[1]);
			try {
				Batch batch = om.readValue(a[1], Batch.class);
				batchService.save(batch);
			} catch (Exception e) {
				LoggingUtil.logWarn(e.toString());
				e.printStackTrace();
			}
		}
		latch.countDown();
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
		LoggingUtil.logInfo(payload);
		
		String[] a = payload.split(" ", 2);
		
		if(!a[0].equals(UUIDService.getServiceInstanceIdentifier().toString())) {
			LoggingUtil.logInfo(a[1]);
			try {
				Batch batch = om.readValue(a[1], Batch.class);
				batchService.update(batch);
			} catch (Exception e) {
				LoggingUtil.logWarn(e.toString());
				e.printStackTrace();
			}
		}
		latch.countDown();
	}
	
	
	
	@KafkaListener(topics="${spring.kafka.topic.batch.uuid}")
	public void recieveUUID(String payload) {
		
		UUIDService.addUUIDToList(payload);
		latch.countDown();
					
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
		LoggingUtil.logInfo(payload);
		
		String[] a = payload.split(" ", 2);
		
		if(!a[0].equals(UUIDService.getServiceInstanceIdentifier().toString())) {
			LoggingUtil.logInfo(a[1]);
			try {
				int id = om.readValue(a[1], Integer.class);
				batchService.delete(id);
			} catch (Exception e) {
				LoggingUtil.logWarn(e.toString());
				e.printStackTrace();
			}
		}
		latch.countDown();
	}
}
