package com.revature.gambit.messaging;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author chris
 * create send functions to send based on insert, update, or delete also add a UUID to the front of the message so the receiver
 * if it was the one that sent it
 *
 */
@Component
public class Sender {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	UUIDService uuidService;
	
	private static Logger logger = Logger.getLogger(Sender.class);
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	
	/**

	 * sends a message with UUID of service and JSON object
	 * @param topic which topic it is sending to
	 * @param payload object to be sent in message
	 */
	public void send(String topic, Object payload) {
		uuidService.checkuuid();
		logger.info("Sending payload for topic: " + topic);
		try {
			String message = uuidService.getServiceInstanceIdentifier().toString()+" "+mapper.writeValueAsString(payload);
			logger.info("Sending message: "+ message);
			kafkaTemplate.send(topic, message);
		} catch (Exception e) {
			logger.error("Couldn't stringify POJO in sender.", e);
		}

	}
	
	public void sendUUID(String payload){
			kafkaTemplate.send("batch.uuid.t", payload);
	}
  
}
