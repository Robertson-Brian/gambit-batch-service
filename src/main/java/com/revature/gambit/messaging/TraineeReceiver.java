package com.revature.gambit.messaging;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.gambit.model.Batch;
import com.revature.gambit.model.TraineeDTO;
import com.revature.gambit.services.BatchServiceImpl;
import com.revature.gambit.util.LoggingUtil;


/**
 * @author klath
 * Receives messages from trainee subtopics
 */
@Component
public class TraineeReceiver {
	
	@Autowired
	BatchServiceImpl batchService;
	
	//CountDownLatch is used in testing to confirm a message was recieved
	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}
	
	
	/**
	 * @param payload
	 * Receives messages for trainee.register and adds the trainee to their batch
	 */
	@KafkaListener(topics="${spring.kafka.topic.trainee.register}")
	public void receiveInsert(String payload) {
		ObjectMapper om = new ObjectMapper();
		LoggingUtil.logInfo(payload);
		
		try {
			TraineeDTO trainee = om.readValue(payload, TraineeDTO.class);
			for(Integer i: trainee.getBatches()) {
				Batch batch = batchService.findById(i);
				batch.getTrainees().add(trainee.getUserId());
				batchService.update(batch);
			}
		} catch (IOException e) {
			LoggingUtil.logWarn(e.toString());
		}
		latch.countDown();
	}
	
	/**
	 * @param payload
	 * Receives messages for trainee.update and adds trainee to their batch
	 */
	@KafkaListener(topics="${spring.kafka.topic.trainee.update}")
	public void receiveUpdate(String payload) {
		ObjectMapper om = new ObjectMapper();
		LoggingUtil.logInfo(payload);
		
		try {
			TraineeDTO trainee = om.readValue(payload, TraineeDTO.class);
			for(Integer i: trainee.getBatches()) {
				Batch batch = batchService.findById(i);
				batch.getTrainees().add(trainee.getUserId());
				batchService.update(batch);
			}
		} catch (IOException e) {
			LoggingUtil.logWarn(e.toString());
		}
		latch.countDown();
	}
	
	/**
	 * @param payload
	 * Receives messages from trainee.delete and removes trainee from their batch
	 */
	@KafkaListener(topics="${spring.kafka.topic.trainee.delete}")
	public void recieveDelete(String payload) {
		ObjectMapper om = new ObjectMapper();
		LoggingUtil.logInfo(payload);
		
		try {
			TraineeDTO trainee = om.readValue(payload, TraineeDTO.class);
			for(Integer i: trainee.getBatches()) {
				Batch batch = batchService.findById(i);
				batch.getTrainees().remove(trainee.getUserId());
				batchService.update(batch);
			}
		} catch (IOException e) {
			LoggingUtil.logWarn(e.toString());
			e.printStackTrace();
		}
		latch.countDown();
	}
}
