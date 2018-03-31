package com.revature.hydra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hydra.entities.Batch;
import com.revature.hydra.repository.BatchRepo;

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
	
//	@Autowired
//	private UserClient userClient;

	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new BatchServiceImpl
	 */
	public BatchServiceImpl() {
		super();
	}

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
	 * @param Batch newBatch
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
	 * Call BatchRepo's findById() method and return a Batch in the HydraBatch database
	 * with the corresponding id
	 * 
	 * @param int id
	 * 
	 * @return Batch
	 */
	@Override
	public Batch findById(int id) {
//		Batch batch = batchRepo.findByBatchId(id);
//		batch.setTrainees(userClient.findAllByBatchAndStatus(id, "placeholder").getBody()));
		return batchRepo.findByBatchId(id);
	}
	
	/**
	 * Call BatchRepo's findByTrainerId() method and return a List of Batches in the
	 * HydraBatch database with the corresponding id
	 * 
	 * @param int id
	 * 
	 * @return List<Batch>
	 */
	@Override
	public List<Batch> findByTrainerId(int id) {
		return batchRepo.findByTrainerTrainerId(id);
	}
	
	/**
	 * Call BatchRepo's findAll() method and return a List of all Batches in the
	 * HydraBatch databased
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
	 * database with the corresponding batch_id with the data from the given
	 * Batch
	 * 
	 * @param Batch updatedBatch
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
	 * @param int id
	 */
	public void delete(int id) {
		batchRepo.deleteByBatchId(id);
	}
}
