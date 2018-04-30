/**
 * 
 */
package com.revature.gambit.messaging;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Revature
 *
 */
public class UUIDServiceTest {

	@Autowired
	static UUIDService uuidService;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		uuidService = UUIDService.getInstance();
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
	
}
