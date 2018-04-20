package com.revature.gambit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.gambit.model.Batch;
import org.springframework.stereotype.Repository;

/**
 * Batch Repository Interface for Gambit Extends JpaReopsitory<Flashcard,
 * Integer>
 * 
 * @author Nick Zwierzynski
 *
 */
public interface BatchRepo extends JpaRepository<Batch, Integer> {

	Batch findByBatchId(int id);

	List<Batch> findByTrainer(int id);

}
