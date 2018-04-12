package com.revature.gambit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.gambit.model.Batch;

/**
 * Batch Repository Interface for Hydra Extends JpaReopsitory<Flashcard,
 * Integer>
 * 
 * @author Bobby McGetrick
 *
 */
public interface BatchRepo extends JpaRepository<Batch, Integer> {

	Batch findByBatchId(int id);

	List<Batch> findByTrainer(int id);

}
