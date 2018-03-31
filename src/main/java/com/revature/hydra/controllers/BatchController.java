package com.revature.hydra.controllers;

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

import com.revature.hydra.entities.Batch;
import com.revature.hydra.services.BatchService;

/**
 * Hydra controller for Janus Batches
 * 
 * @author Bobby McGetrick
 *
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class BatchController {

	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	@Autowired
	private BatchService batchService;

	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new BatchController
	 */
	public BatchController() {
		super();
	}

	/**
	 * Create new BatchController with a pre-defined BatchService
	 * 
	 * @param BatchService
	 *            batchService
	 */
	public BatchController(BatchService batchService) {
		super();
		this.batchService = batchService;
	}

	/************************************************************************************
	 * Create
	 ************************************************************************************/
	/**
	 * Call BatchService's save() method and insert the given Batch into the
	 * HydraBatch database as a new Batch
	 * 
	 * @param Batch newBatch
	 * 
	 * @return Batch
	 */
	@PostMapping
	public Batch save(@RequestBody Batch newBatch) {
		return batchService.save(newBatch);
	}
	
	/************************************************************************************
	 * Read
	 ************************************************************************************/
	/**
	 * Call BatchService's findById() method and return a Batch from the
	 * HydraBatch database as a new Batch
	 * 
	 * @param int id
	 * 
	 * @return Batch
	 */
	@GetMapping("{id}")
	public Batch findById(@PathVariable int id) {
		return batchService.findById(id);
	}
	
	/**
	 * Call BatchService's findByTrainerId() method and return a List of Batches from the
	 * HydraBatch database as a new Batch
	 * 
	 * @param int id
	 * 
	 * @return List<Batch>
	 */
	@GetMapping("trainers/{id}")
	public List<Batch> findByTrainerId(@PathVariable int id) {
		return batchService.findByTrainerId(id);
	}
	
	/**
	 * Call BatchRepo's findAll() method and return a List of all Batches in
	 * the HydraBatch database
	 * 
	 * @return List<Batch>
	 */
	@GetMapping
	public List<Batch> findAll() {
		return batchService.findAll();
	}
	
	/************************************************************************************
	 * Update
	 ************************************************************************************/
	/**
	 * Call BatchService's update() method and update a Batch from the HydraBatch
	 * database with the corresponding batch_id with the data from the given
	 * Batch
	 * 
	 * @param Batch updatedBatch
	 */
	@PutMapping
	public void update(@RequestBody Batch updatedBatch) {
		batchService.update(updatedBatch);
	}
	
	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	/**
	 * Call BatcService's delete() method and delete a Batch from the HydraBatch
	 * database with the corresponding batch_id
	 * 
	 * @param int id
	 */
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		batchService.delete(id);
	}
}
