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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.gambit.model.Batch;
import com.revature.gambit.repository.BatchRepo;
import com.revature.gambit.services.BatchService;
import com.revature.gambit.services.BatchServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class BatchServiceTest {

	@InjectMocks	
	private BatchServiceImpl batchService;

	@Mock
	BatchRepo batchRepo;
	
	Batch batch1;
	Batch batch2;

	List<Batch> batches;

	@Before
	public void setUp() throws Exception {
		batch1 = new Batch(1, 2, "java", 10, 2, 3, "lecturing",null, null, "Reston",
				null, null);

		batch2 = new Batch(2, 2, "pega", 20, 5, 4, "lecturing", null, null, "Reston", null,
				null);

		batches = Arrays.asList(batch1, batch2);

		batchService.save(batch1);
		batchService.save(batch2);


		when(batchService.findAll()).thenReturn(batches);

		when(batchService.findById(1)).thenReturn(batch1);
		when(batchService.findById(2)).thenReturn(batch2);
		
		when(batchService.findByTrainerId(10)).thenReturn(batches.subList(0, 1));
		when(batchService.findByTrainerId(20)).thenReturn(batches.subList(1, 2));
		
	}

	@Test
	public void testGetAllBatches() throws Exception {
		
		List<Batch> batchTest = batchService.findAll();

		assertEquals(batches, batchTest);

	}
	
	@Test
	public void testGetBatchById() throws Exception {
		
		Batch batchTest1 = batchService.findById(1);

		assertEquals(batch1, batchTest1);
		
		
		Batch batchTest2 = batchService.findById(2);

		assertEquals(batch2, batchTest2);

	}

	
	@Test
	public void testGetBatchesByTrainerId() throws Exception {
		
		List<Batch> batchTest1 = batchService.findByTrainerId(10);

		assertEquals(batches.subList(0, 1), batchTest1);
		
		
		List<Batch> batchTest2 = batchService.findByTrainerId(20);

		assertEquals(batches.subList(1, 2), batchTest2);

	}
	
	
	@After
	public void tearDown() throws Exception {
		batchService.delete(batch1.getBatchId());
		batchService.delete(batch2.getBatchId());
	}

}
