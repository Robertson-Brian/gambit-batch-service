package com.revature.hydra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.hydra.entities.Batch;

/**
* Batch Repository Interface for Hydra
* Extends JpaReopsitory<Flashcard, Integer>
* 
* @author Bobby McGetrick
*
*/
public interface BatchRepo extends JpaRepository<Batch, Integer>{

	Batch findByBatchId(int id);

	List<Batch> findByTrainerTrainerId(int id);

	@Transactional
	void deleteByBatchId(int id);

}
