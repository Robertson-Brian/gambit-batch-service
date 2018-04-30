package com.revature.gambit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.gambit.model.Batch;
import com.revature.gambit.repository.BatchRepo;

/**
 * Hydra service implementation for Janus Batches
 * 
 * @author Bobby McGetrick, Ian Perfitt, Jason Morgan, Matt Mark
 *
 */
@Service
public class BatchServiceImpl implements BatchService {

	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	
	@Autowired
	private BatchRepo batchRepo;

	/**
	 * Create new BatchServiceImpl with predefined BatchRepo
	 */
	public BatchServiceImpl(BatchRepo batchRepo) {
		super();
		this.batchRepo = batchRepo;
	}

	/************************************************************************************
	 * Create
	 ************************************************************************************/
	/**
	 * Call BatchRepos' save() method and insert the given Batch into the HydraBatch
	 * database as a new Batch
	 * 
	 * @param newBatch
	 *            newBatch
	 * 
	 * @return Batch
	 */
	@Override
	public Batch save(Batch newBatch) {
		return batchRepo.save(newBatch);
	}

	/************************************************************************************
	 * Read
	 ************************************************************************************/
	/**
	 * Call BatchRepo's findById() method and return a Batch in the HydraBatch
	 * database with the corresponding id
	 * 
	 * @param id
	 *            id
	 * 
	 * @return Batch
	 */
	@Override
	public Batch findById(int id) {
		return batchRepo.findByBatchId(id);
	}

	/**
	 * Call BatchRepo's findByTrainer() method and return a List of Batches in the
	 * HydraBatch database with the corresponding id
	 * 
	 * @param id
	 *            id
	 * 
	 * @return List<Batch>
	 */
	@Override
	public List<Batch> findByTrainerId(int id) {
		return batchRepo.findByTrainerId(id);
	}

	/**
	 * Call BatchRepo's findAll() method and return a List of all Batches in the
	 * HydraBatch database
	 * 
	 * @return List<Batch>
	 */
	@Override
	public List<Batch> findAll() {
		return batchRepo.findAll();
	}

	/************************************************************************************
	 * Update
	 ************************************************************************************/
	/**
	 * Call BatchRepo's update() method and update a Batch from the HydraBatch
	 * database with the corresponding batch_id with the data from the given Batch
	 * 
	 * @param updatedBatch
	 *            updatedBatch
	 */
	@Override
	public void update(Batch updatedBatch) {
		batchRepo.save(updatedBatch);
	}

	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	/**
	 * Call BatchRepo's delete() method and delete a Batch from the HydraBatch
	 * database with the corresponding batch_id
	 * 
	 * @param id
	 *            id
	 */
	@Override
	public void delete(int id) {
		batchRepo.delete(id);
	}

}
