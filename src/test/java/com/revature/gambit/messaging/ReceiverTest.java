package com.revature.gambit.messaging;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
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
import com.revature.gambit.repository.BatchRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class ReceiverTest {
	
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
	private Receiver receiver;
	
	@Autowired
	private BatchRepo repo;
	
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
	    template.setDefaultTopic(BATCH_REGISTER_TOPIC);
	    
	    
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
		//send the batch as a message
		Batch testBatch = new Batch();
		testBatch.setTrainingName("Test Batch");
		String batchJSON = "TestUUID "+MAPPER.writeValueAsString(testBatch);
		template.send(BATCH_REGISTER_TOPIC, batchJSON);
		LOGGER.debug("test-sender sent register message='{}'", batchJSON);
		
	    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	    // check that the message was received
	    assertThat(receiver.getLatch().getCount()).isEqualTo(0);
	    // check that a batch was added to the repo
	    assertThat(repo.count()).isEqualTo(1);
		
	}
	
	@Test
	public void testRecieveUpdate() throws Exception {
		//add a batch to the repo
		Batch testBatch = new Batch();
		testBatch = repo.save(testBatch);
		//update the batch and send it as a message
		testBatch.setTrainingName("Test Batch");
		String batchJSON = "TestUUID "+MAPPER.writeValueAsString(testBatch);
		template.send(BATCH_UPDATE_TOPIC, batchJSON);
		LOGGER.debug("test-sender sent update message='{}'", batchJSON);
		
	    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	    // check that the message was received
	    assertThat(receiver.getLatch().getCount()).isEqualTo(0);
	    // check that a batch was added to the repo
	    assertThat(repo.count()).isEqualTo(1);
	    // check that batch with testBatch's id exists
	    assertThat(repo.exists(testBatch.getBatchId()));
	    // check that the batch name was updated
	    assertThat(repo.findByBatchId(testBatch.getBatchId()).getTrainingName()).isEqualTo("Test Batch");
	}
	
	@Test
	public void testRecieveDelete() throws Exception {
		//add a batch to the repo
		Batch testBatch = new Batch();
		testBatch = repo.save(testBatch);
		int id = testBatch.getBatchId();
		//send a delete message for the testBatch
		String batchJSON = "TestUUID "+id;
		template.send(BATCH_DELETE_TOPIC, batchJSON);
		LOGGER.debug("test-sender sent delete message='{}'", batchJSON);
		
	    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	    // check that the message was received
	    assertThat(receiver.getLatch().getCount()).isEqualTo(0);
	    TimeUnit.SECONDS.sleep(5);
	    // check that the batch was deleted
	    assertThat(repo.exists(testBatch.getBatchId())).isFalse();
	}
}
