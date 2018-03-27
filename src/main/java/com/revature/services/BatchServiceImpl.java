package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Batch;
import com.revature.repository.BatchRepo;
import com.revature.services.interfaces.BatchService;

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
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate BatchServiceImpl hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchRepo == null) ? 0 : batchRepo.hashCode());
		return result;
	}

	/**
	 * Check if BatchServiceImpl is equivalent to another Object
	 *
	 * @param Object
	 *            obj
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BatchServiceImpl other = (BatchServiceImpl) obj;
		if (batchRepo == null) {
			if (other.batchRepo != null)
				return false;
		} else if (!batchRepo.equals(other.batchRepo))
			return false;
		return true;
	}

	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve BatchService.batchRepo
	 * 
	 * @return BatchRepo batchRepo
	 */
	public BatchRepo getBatchRepo() {
		return batchRepo;
	}

	/**
	 * Set BatchService.batchRepo to a given BatchRepo
	 * 
	 * @param BatchRepo
	 *            batchRepo
	 */
	public void setBatchRepo(BatchRepo batchRepo) {
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
