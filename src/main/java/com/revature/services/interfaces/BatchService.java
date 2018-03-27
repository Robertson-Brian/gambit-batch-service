package com.revature.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.entities.Batch;

/**
 * Hydra service for Janus Batches
 * 
 * @author Bobby McGetrick, Ian Perfitt, Jason Morgan, Matt Mark
 *
 */
public interface BatchService {

	/************************************************************************************
	 * Create
	 ************************************************************************************/
	public Batch save(Batch newBatch);

	/************************************************************************************
	 * Read
	 ************************************************************************************/
	public Batch findById(int id);

	public List<Batch> findByTrainerId(int id);

	public List<Batch> findAll();

	/************************************************************************************
	 * Update
	 ************************************************************************************/
	public void update(Batch updatedBatch);

	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	public void delete(int id);
	
}
