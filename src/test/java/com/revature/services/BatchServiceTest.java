package com.revature.services;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.gambit.Application;
import com.revature.gambit.model.Batch;
import com.revature.gambit.repository.BatchRepo;
import com.revature.gambit.services.BatchService;
import com.revature.gambit.services.BatchServiceImpl;

/*
 * 
 * Authors:
 * Yuri Felicio
 * Malik Biddle
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class BatchServiceTest {
	
	
	@Autowired
	private BatchService batchService;

	
	Batch batch1;
	Batch batch2;

	List<Batch> batches;

//	@BeforeClass
//	public void setUp() throws Exception {
//		batch1 = new Batch(1, 2, "java", 10, 2, 3, "lecturing",null, null, "Reston",
//				null, null);
//
//		batch2 = new Batch(2, 2, "pega", 20, 5, 4, "lecturing", null, null, "Reston", null,
//				null);
//
//		batches = Arrays.asList(batch1, batch2);
//
//		batchService.save(batch1);
//		batchService.save(batch2);
//
//	}

	@Test
	public void testGetAllBatches() throws Exception {
		System.out.println("in test");
		

	}
	
//	@Test
//	public void testGetBatchById() throws Exception {
//		
//
//		assertEquals(batch1, batchService.findById(1));
//
//		assertEquals(batch2, batchService.findById(2));
//
//	}
//
//	
//	@Test
//	public void testGetBatchesByTrainerId() throws Exception {
//		
//		List<Batch> batchTest1 = batchService.findByTrainerId(10);
//
//		assertEquals(batches.subList(0, 1), batchTest1);
//		
//		
//		List<Batch> batchTest2 = batchService.findByTrainerId(20);
//
//		assertEquals(batches.subList(1, 2), batchTest2);
//
//	}
//	
//	
//	@After
//	public void tearDown() throws Exception {
//		batchService.delete(batch1.getBatchId());
//		batchService.delete(batch2.getBatchId());
//	}

}
