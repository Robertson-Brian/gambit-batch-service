/**
 * 
 */
package com.revature.gambit.messaging;

import static org.junit.Assert.*;

import com.revature.gambit.Application;
import com.revature.gambit.repository.BatchRepo;
import com.revature.gambit.services.BatchServiceImpl;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @author Revature
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class UUIDServiceTest {

	@Mock
	private Sender sender;

	@Autowired
	private UUIDService uuidService;

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

	private KafkaTemplate<String, String> template;

	@Autowired
	private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

	@ClassRule
	public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, BATCH_REGISTER_TOPIC,
			BATCH_UPDATE_TOPIC, BATCH_DELETE_TOPIC, UUID_TOPIC, TRAINEE_REGISTER_TOPIC,
			TRAINEE_UPDATE_TOPIC, TRAINEE_DELETE_TOPIC, NOTE_REGISTER_TOPIC,
			NOTE_UPDATE_TOPIC, NOTE_DELETE_TOPIC);


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		uuidService = UUIDService.getInstance();
		uuidService.setSender(sender);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		uuidService.getListUUID().clear();
	}

	/**
	 * Test method for {@link com.revature.gambit.messaging.UUIDService#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		assertNotNull(UUIDService.getInstance());
	}

	/**
	 * Test method for {@link com.revature.gambit.messaging.UUIDService#addUUIDToList(java.lang.String)}.
	 */
	@Test
	public void testAddUUIDToList() {
		uuidService.addUUIDToList("7-3-2-7-6");
		assertNotEquals(0, uuidService.getListUUID());
	}

	/**
	 * Test method for {@link com.revature.gambit.messaging.UUIDService#addUUIDToList(java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testBadAddUUIDToList() {
		uuidService.addUUIDToList("bad");
	}

	@Test
	public void testCheckUUID() {
		int checked = uuidService.getChecked();
		assertTrue(uuidService.checkuuid() == (checked==0) );
	}

	@Test
	public void testSendIfListIsEmpty(){
		boolean isEmpty = uuidService.getListUUID().isEmpty();
		assertTrue(uuidService.sendIfListIsEmpty() == isEmpty );
	}

	@Test
	public void testCheckToSeeIfUuidIsInList(){

		UUID original = uuidService.getServiceInstanceIdentifier();

		System.out.println(this.uuidService.getServiceInstanceIdentifier());

		uuidService.checkToSeeIfUuidIsInList();

		assertTrue(this.uuidService.getServiceInstanceIdentifier() == original);

		uuidService.addUUIDToList(original.toString());

		uuidService.checkToSeeIfUuidIsInList();

		assertTrue(this.uuidService.getServiceInstanceIdentifier() != original);

	}

}
