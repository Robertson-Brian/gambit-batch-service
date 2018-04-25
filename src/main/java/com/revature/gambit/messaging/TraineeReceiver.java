package com.revature.gambit.messaging;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.gambit.model.Batch;
import com.revature.gambit.model.TraineeDTO;
import com.revature.gambit.services.BatchServiceImpl;
import com.revature.gambit.util.LoggingUtil;

public class TraineeReceiver {
	
	@Autowired
	BatchServiceImpl batchService;
	
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
			e.printStackTrace();
		}
	}
	
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
			e.printStackTrace();
		}
	}
	
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
	}
}
