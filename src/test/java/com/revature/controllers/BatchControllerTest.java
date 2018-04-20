package com.revature.controllers;

import static org.hamcrest.CoreMatchers.instanceOf;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.revature.gambit.controllers.BatchControllerImpl;
import com.revature.gambit.model.Batch;
import com.revature.gambit.services.BatchService;

@RunWith(SpringJUnit4ClassRunner.class)
public class BatchControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private BatchControllerImpl batchController;

	@Mock
	private BatchService batchService;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(batchController).build();
	}

	@Test
	public void testGetAllBatches() throws Exception {
		List<Batch> batches = new ArrayList<>();
		batches.add(new Batch());
		batches.add(new Batch());

		when(batchService.findAll()).thenReturn((List) batches);

		mockMvc.perform(MockMvcRequestBuilders.get("/batches")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$", hasSize(2)));
	}

	@Test
	public void testGetBatchById() throws Exception {
		Batch batch1 = new Batch(1, 2, "java", 10, 2, 3, "lecturing", null, null, "Reston", null, null);

		Batch batch2 = new Batch(2, 2, "pega", 20, 5, 4, "lecturing", null, null, "Reston", null, null);

		when(batchService.findById(1)).thenReturn(batch1);
		when(batchService.findById(2)).thenReturn(batch2);

		mockMvc.perform(MockMvcRequestBuilders.get("/batches/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.batchId", is(1)))
				.andExpect(jsonPath("$.resourceId", is(2))).andExpect(jsonPath("$.trainingName", is("java")))
				.andExpect(jsonPath("$.trainerId", is(10))).andExpect(jsonPath("$.cotrainerId", is(2)))
				.andExpect(jsonPath("$.skillTypeId", is(3))).andExpect(jsonPath("$.trainingType", is("lecturing")))
				.andExpect(jsonPath("$.startDate", is((Timestamp) null)))
				.andExpect(jsonPath("$.endDate", is((Timestamp) null))).andExpect(jsonPath("$.location", is("Reston")))
				.andExpect(jsonPath("$.notes", is((Set<Integer>) null)))
				.andExpect(jsonPath("$.trainees", is((Set<Integer>) null)));

		mockMvc.perform(MockMvcRequestBuilders.get("/batches/2").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.batchId", is(2)))
				.andExpect(jsonPath("$.resourceId", is(2))).andExpect(jsonPath("$.trainingName", is("pega")))
				.andExpect(jsonPath("$.trainerId", is(20))).andExpect(jsonPath("$.cotrainerId", is(5)))
				.andExpect(jsonPath("$.skillTypeId", is(4))).andExpect(jsonPath("$.trainingType", is("lecturing")))
				.andExpect(jsonPath("$.startDate", is((Timestamp) null)))
				.andExpect(jsonPath("$.endDate", is((Timestamp) null))).andExpect(jsonPath("$.location", is("Reston")))
				.andExpect(jsonPath("$.notes", is((Set<Integer>) null)))
				.andExpect(jsonPath("$.trainees", is((Set<Integer>) null)));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/batches/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.batchId", is(1)))
				.andExpect(jsonPath("$.resourceId", is(2)))
				.andExpect(jsonPath("$.trainingName", is("java")))
				.andExpect(jsonPath("$.trainerId", is(10)))
				.andExpect(jsonPath("$.cotrainerId", is(2)))
				.andExpect(jsonPath("$.skillTypeId", is(3)))
				.andExpect(jsonPath("$.trainingType", is("lecturing")))
				.andExpect(jsonPath("$.startDate", is((Timestamp)null)))
				.andExpect(jsonPath("$.endDate", is((Timestamp)null)))
				.andExpect(jsonPath("$.location", is("Reston")))
				.andExpect(jsonPath("$.notesIds", is((Set<Integer>)null)))
				.andExpect(jsonPath("$.traineesIds", is((Set<Integer>)null)));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/batches/2")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.batchId", is(2)))
				.andExpect(jsonPath("$.resourceId", is(2)))
				.andExpect(jsonPath("$.trainingName", is("pega")))
				.andExpect(jsonPath("$.trainerId", is(20)))
				.andExpect(jsonPath("$.cotrainerId", is(5)))
				.andExpect(jsonPath("$.skillTypeId", is(4)))
				.andExpect(jsonPath("$.trainingType", is("lecturing")))
				.andExpect(jsonPath("$.startDate", is((Timestamp)null)))
				.andExpect(jsonPath("$.endDate", is((Timestamp)null)))
				.andExpect(jsonPath("$.location", is("Reston")))
				.andExpect(jsonPath("$.notesIds", is((Set<Integer>)null)))
				.andExpect(jsonPath("$.traineesIds", is((Set<Integer>)null)));
	}

	@Test
	public void testGetBatchByTrainerId() throws Exception {
		Batch batch1 = new Batch(1, 2, "java", 10, 2, 3, "lecturing", null, null, "Reston", null, null);

		Batch batch2 = new Batch(2, 2, "pega", 20, 5, 4, "lecturing", null, null, "Reston", null, null);

		List<Batch> batches1 = new ArrayList<>();
		batches1.add(0, batch1);
		List<Batch> batches2 = new ArrayList<>();
		batches2.add(0, batch2);

		when(batchService.findByTrainerId(10)).thenReturn(batches1);
		when(batchService.findByTrainerId(20)).thenReturn(batches2);

		mockMvc.perform(MockMvcRequestBuilders.get("/batches/trainers/10").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].batchId", is(1))).andExpect(jsonPath("$[0].resourceId", is(2)))
				.andExpect(jsonPath("$[0].trainingName", is("java"))).andExpect(jsonPath("$[0].trainerId", is(10)))
				.andExpect(jsonPath("$[0].cotrainerId", is(2))).andExpect(jsonPath("$[0].skillTypeId", is(3)))
				.andExpect(jsonPath("$[0].trainingType", is("lecturing")))
				.andExpect(jsonPath("$[0].startDate", is((Timestamp) null)))
				.andExpect(jsonPath("$[0].endDate", is((Timestamp) null)))
				.andExpect(jsonPath("$[0].location", is("Reston")))

				.andExpect(jsonPath("$[0].notes", is((Set<Integer>) null)))
				.andExpect(jsonPath("$[0].trainees", is((Set<Integer>) null)));

		mockMvc.perform(MockMvcRequestBuilders.get("/batches/trainers/20").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].batchId", is(2)))
				.andExpect(jsonPath("$[0].resourceId", is(2))).andExpect(jsonPath("$[0].trainingName", is("pega")))
				.andExpect(jsonPath("$[0].trainerId", is(20))).andExpect(jsonPath("$[0].cotrainerId", is(5)))

				.andExpect(jsonPath("$[0].notesIds", is((Set<Integer>)null)))
				.andExpect(jsonPath("$[0].traineesIds", is((Set<Integer>)null)));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/batches/trainers/20")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].batchId", is(2)))
				.andExpect(jsonPath("$[0].resourceId", is(2)))
				.andExpect(jsonPath("$[0].trainingName", is("pega")))
				.andExpect(jsonPath("$[0].trainerId", is(20)))
				.andExpect(jsonPath("$[0].cotrainerId", is(5)))
				.andExpect(jsonPath("$[0].skillTypeId", is(4)))
				.andExpect(jsonPath("$[0].trainingType", is("lecturing")))
				.andExpect(jsonPath("$[0].startDate", is((Timestamp) null)))
				.andExpect(jsonPath("$[0].endDate", is((Timestamp) null)))
				.andExpect(jsonPath("$[0].location", is("Reston")))
				.andExpect(jsonPath("$[0].notes", is((Set<Integer>) null)))
				.andExpect(jsonPath("$[0].trainees", is((Set<Integer>) null)));
				.andExpect(jsonPath("$[0].notesIds", is((Set<Integer>)null)))
				.andExpect(jsonPath("$[0].traineesIds", is((Set<Integer>)null)));
	}

	@Test
	public void testSave() throws Exception {
		Batch batch = new Batch();
		// Batch res = new Batch();
		batch.setBatchId(7);
		batch.setLocation("HERE");

		assertEquals(7, batch.getBatchId());
		assertEquals("HERE", batch.getLocation());

		Gson gson = new Gson();
		String jsonBatch = gson.toJson(batch);

	    mockMvc.perform(
	            post("/batches")
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(jsonBatch))
	            .andExpect(status().isOk());
	    }

	@Test
	public void testUpdate() throws Exception {
		Batch batch = new Batch();
		Batch res = new Batch();
		batch.setBatchId(7);
		batch.setLocation("HERE");
		
		Gson gson = new Gson();
		String jsonBatch = gson.toJson(batch);


		when(batchService.findById(batch.getBatchId())).thenReturn(batch);

		mockMvc.perform(
				put("/batches/{id}", batch.getBatchId()).contentType(MediaType.APPLICATION_JSON)
				.content(jsonBatch))
				.andExpect(status().isOk());
	}

	@Test
	public void testDelete() throws Exception {
		Batch batch = new Batch();
		batch.setBatchId(2);

		when(batchService.findById(batch.getBatchId())).thenReturn(batch);
		
		doNothing().when(batchService).delete(batch.getBatchId());
		mockMvc.perform(delete("/batches/{id}", batch.getBatchId())).andExpect(status().isOk());

	}
}
