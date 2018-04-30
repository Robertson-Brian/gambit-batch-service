package com.revature.gambit.messaging;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.gambit.model.Batch;
import com.revature.gambit.model.TraineeDTO;
import com.revature.gambit.repository.BatchRepo;
import com.revature.gambit.services.BatchServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class TraineeReceiverTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverTest.class);
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	private static final String BATCH_REGISTER_TOPIC = "batch.register.t";
	private static final String BATCH_UPDATE_TOPIC = "batch.update.t";
	private static final String BATCH_DELETE_TOPIC = "batch.delete.t";
	private static final String UUID_TOPIC = "batch.uuid.t";
	private static final String TRAINEE_REGISTER_TOPIC = "trainee.register.t";
	private static final String TRAINEE_UPDATE_TOPIC = "trainee.update.t";
	private static final String TRAINEE_DELETE_TOPIC = "trainee.delete.t";
	private static final String NOTE_REGISTER_TOPIC = "note.register.t";
	private static final String NOTE_UPDATE_TOPIC = "note.update.t";
	private static final String NOTE_DELETE_TOPIC = "note.delete.t";
	
	@Autowired
	private TraineeReceiver receiver;
	
	@Autowired
	private BatchRepo repo;
	
	@Autowired
	private BatchServiceImpl service;
	
	private KafkaTemplate<String, String> template;
	
	@Autowired
	private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
	
	@ClassRule
	public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, BATCH_REGISTER_TOPIC, 
			BATCH_UPDATE_TOPIC, BATCH_DELETE_TOPIC, UUID_TOPIC, TRAINEE_REGISTER_TOPIC, 
			TRAINEE_UPDATE_TOPIC, TRAINEE_DELETE_TOPIC, NOTE_REGISTER_TOPIC, 
			NOTE_UPDATE_TOPIC, NOTE_DELETE_TOPIC);
	
	@Before
	public void setUp() throws Exception {
		// set up the Kafka producer properties
	    Map<String, Object> senderProperties =
	        KafkaTestUtils.senderProps(embeddedKafka.getBrokersAsString());

	    // create a Kafka producer factory
	    ProducerFactory<String, String> producerFactory =
	        new DefaultKafkaProducerFactory<String, String>(senderProperties);

	    // create a Kafka template
	    template = new KafkaTemplate<>(producerFactory);
	    // set the default topic to send to
	    template.setDefaultTopic(TRAINEE_REGISTER_TOPIC);
	    
	    
	    // wait until the partitions are assigned
	    for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
	        .getListenerContainers()) {
	      ContainerTestUtils.waitForAssignment(messageListenerContainer,
	          embeddedKafka.getPartitionsPerTopic());
	    }
	}
	
	@After
	public void tearDown() {
		//clear the repo after the test
		repo.deleteAll();
	}
	
	@Test
	public void testReceive() throws Exception {
	    // send the message
	    String greeting = "Hello Spring Kafka Receiver!";
	    template.sendDefault(greeting);
	    LOGGER.debug("test-sender sent message='{}'", greeting);

	    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	    // check that the message was received
	    assertThat(receiver.getLatch().getCount()).isEqualTo(0);
	}
	
	@Test
	public void testReceiveInsert() throws Exception {
		// add a batch to the repo
		Batch testBatch = new Batch();
		testBatch = service.save(testBatch);
		// add the batches Id to a set
		Set<Integer> batchId = new HashSet<Integer>();
		batchId.add(testBatch.getBatchId());
		// send message with TraineeDTO payload
		TraineeDTO trainee = new TraineeDTO(1, batchId);
		String traineeJSON = MAPPER.writeValueAsString(trainee);
		template.send(TRAINEE_REGISTER_TOPIC, traineeJSON);
		LOGGER.debug("test-sender sent insert message='{}'", traineeJSON);
		
	    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	    // check that the message was received
	    assertThat(receiver.getLatch().getCount()).isEqualTo(0);
	    // check that the batch now contains the Trainee's id
	    assertThat(service.findById(testBatch.getBatchId()).getTrainees().contains(1));
	}
	
	@Test
	public void testReceiveUpdate() throws Exception {
		// add a batch to the repo
		Batch testBatch = new Batch();
		testBatch = service.save(testBatch);
		// add the batches Id to a set
		Set<Integer> batchId = new HashSet<Integer>();
		batchId.add(testBatch.getBatchId());
		// send message with TraineeDTO payload
		TraineeDTO trainee = new TraineeDTO(1, batchId);
		String traineeJSON = MAPPER.writeValueAsString(trainee);
		template.send(TRAINEE_UPDATE_TOPIC, traineeJSON);
		LOGGER.debug("test-sender sent update message='{}'", traineeJSON);
		
	    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	    // check that the message was received
	    assertThat(receiver.getLatch().getCount()).isEqualTo(0);
	    // check that the batch now contains the Trainee's id
	    assertThat(service.findById(testBatch.getBatchId()).getTrainees().contains(1));
	}
	
	@Test
	public void testReceiveDelete() throws Exception {
		// add a batch to the repo
		Batch testBatch = new Batch();
		testBatch = service.save(testBatch);
		// add the batches Id to a set
		Set<Integer> batchId = new HashSet<Integer>();
		batchId.add(testBatch.getBatchId());
		// Create a trainee to add to the set
		TraineeDTO trainee = new TraineeDTO(1, batchId);
		// add the trainee's id to the testBatch's trainees
		Set<Integer> traineeId = new HashSet<Integer>();
		traineeId.add(trainee.getUserId());
		testBatch.setTrainees(traineeId);
		// update the batch in the repo
		testBatch = service.save(testBatch);
		// send a delete message with the trainee in the payload
		String traineeJSON = MAPPER.writeValueAsString(trainee);
		template.send(TRAINEE_DELETE_TOPIC, traineeJSON);
		LOGGER.debug("test-sender sent delete message='{}'", traineeJSON);
	    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	    // check that the message was received
	    assertThat(receiver.getLatch().getCount()).isEqualTo(0);
	    // check that the batch now doesn't contain the trainee's Id
	    assertThat(service.findById(testBatch.getBatchId()).getTrainees().contains(1)).isFalse();
		
	}
}
