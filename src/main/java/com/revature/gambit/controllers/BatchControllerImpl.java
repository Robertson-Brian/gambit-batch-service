package com.revature.gambit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.gambit.messaging.Sender;
import com.revature.gambit.model.Batch;
import com.revature.gambit.services.BatchService;

/**
 * Hydra controller for Janus Batches
 * 
 * @author Bobby McGetrick
 *
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "batches")
@CrossOrigin
public class BatchControllerImpl implements BatchController {

	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	@Autowired
	private Sender sender;
	
	@Autowired
	private BatchService batchService;

	/************************************************************************************
	 * Create
	 ************************************************************************************/
	/**
	 * Call BatchService's save() method and insert the given Batch into the
	 * HydraBatch database as a new Batch
	 * 
	 * @param Batch
	 *            newBatch
	 * 
	 * @return Batch
	 */
	@PostMapping
	@Override
	public Batch save(@RequestBody Batch newBatch) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(newBatch);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sender.sendInsert(json);
		return batchService.save(newBatch);
	}

	/************************************************************************************
	 * Read
	 ************************************************************************************/
	/**
	 * Call BatchService's findById() method and return a Batch from the HydraBatch
	 * database as a new Batch
	 * 
	 * @param int
	 *            id
	 * 
	 * @return Batch
	 */
	@GetMapping("{id}")
	@Override
	public Batch findById(@PathVariable int id) {
		return batchService.findById(id);
	}

	/**
	 * Call BatchService's findByTrainerId() method and return a List of Batches
	 * from the HydraBatch database as a new Batch
	 * 
	 * @param int
	 *            id
	 * 
	 * @return List<Batch>
	 */
	@GetMapping("trainers/{id}")
	@Override
	public List<Batch> findByTrainerId(@PathVariable int id) {
		return batchService.findByTrainerId(id);
	}

	/**
	 * Call BatchRepo's findAll() method and return a List of all Batches in the
	 * HydraBatch database
	 * 
	 * @return List<Batch>
	 */
	@GetMapping
	@Override
	public List<Batch> findAll() {
		return batchService.findAll();
	}

	/************************************************************************************
	 * Update
	 ************************************************************************************/
	/**
	 * Call BatchService's update() method and update a Batch from the HydraBatch
	 * database with the corresponding batch_id with the data from the given Batch
	 * 
	 * @param Batch
	 *            updatedBatch
	 */
	@PutMapping
	@Override
	public void update(@RequestBody Batch updatedBatch) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(updatedBatch);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sender.sendUpdate(json);
		batchService.update(updatedBatch);
	}

	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	/**
	 * Call BatcService's delete() method and delete a Batch from the HydraBatch
	 * database with the corresponding batch_id
	 * 
	 * @param int
	 *            id
	 */
	@DeleteMapping("{id}")
	@Override
	public void delete(@PathVariable int id) {
		sender.sendDelete(String.valueOf(id));
		batchService.delete(id);
	}
}
