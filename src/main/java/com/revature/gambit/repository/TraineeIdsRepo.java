package com.revature.gambit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.gambit.model.TraineeId;

public interface TraineeIdsRepo extends JpaRepository<TraineeId, Integer>{
	
	

}
