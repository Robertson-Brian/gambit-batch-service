package com.revature.hydra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.hydra.entities.BatchTrainee;

/**
* Batch Repository Interface for Hydra
* Extends JpaReopsitory<Flashcard, Integer>
* 
* @author Bobby McGetrick
*
*/
public interface BatchTraineeRepo extends JpaRepository<BatchTrainee, Integer>{

}
