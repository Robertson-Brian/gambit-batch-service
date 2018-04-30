package com.revature.gambit.messaging;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.gambit.model.Batch;
import com.revature.gambit.model.NotesDTO;
import com.revature.gambit.services.BatchServiceImpl;
import com.revature.gambit.util.LoggingUtil;

/**
 * @author chris
 * Receives messages from note subtopics
 */
@Component
public class NoteReceiver {
	
	@Autowired
	BatchServiceImpl batchService;
	
	//CountDownLatch is used in testing to confirm a message was recieved
	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}
	
	/**
	 * @param payload
	 * Receives messages for note.register and adds the note to their batch
	 */
	@KafkaListener(topics="${spring.kafka.topic.note.register}")
	public void receiveInsert(String payload) {
		ObjectMapper om = new ObjectMapper();
		LoggingUtil.logInfo(payload);
		
		try {
			NotesDTO notes = om.readValue(payload, NotesDTO.class);
			for(Integer i: notes.getBatches()) {
				Batch batch = batchService.findById(i);
				batch.getNotes().add(notes.getNoteId());
				batchService.update(batch);
			}
		} catch (IOException e) {
			LoggingUtil.logWarn(e.toString());
			e.printStackTrace();
		}
		latch.countDown();
	}
	
	/**
	 * @param payload
	 * Receives messages for note.update and adds note to their batch
	 */
	@KafkaListener(topics="${spring.kafka.topic.note.update}")
	public void receiveUpdate(String payload) {
		ObjectMapper om = new ObjectMapper();
		LoggingUtil.logInfo(payload);
		
		try {
			NotesDTO notes = om.readValue(payload, NotesDTO.class);
			for(Integer i: notes.getBatches()) {
				Batch batch = batchService.findById(i);
				batch.getNotes().add(notes.getNoteId());
				batchService.update(batch);
			}
		} catch (IOException e) {
			LoggingUtil.logWarn(e.toString());
			e.printStackTrace();
		}
		latch.countDown();
	}
	
	/**
	 * @param payload
	 * Receives messages from note.delete and removes note from their batch
	 */
	@KafkaListener(topics="${spring.kafka.topic.note.delete}")
	public void recieveDelete(String payload) {
		ObjectMapper om = new ObjectMapper();
		LoggingUtil.logInfo(payload);
		
		try {
			NotesDTO notes = om.readValue(payload, NotesDTO.class);
			for(Integer i: notes.getBatches()) {
				Batch batch = batchService.findById(i);
				batch.getNotes().remove(notes.getNoteId());
				batchService.update(batch);
			}
		} catch (IOException e) {
			LoggingUtil.logWarn(e.toString());
			e.printStackTrace();
		}
		latch.countDown();
	}
}
