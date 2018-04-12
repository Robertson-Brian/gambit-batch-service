package com.revature.gambit.controllers;

import java.util.List;

import com.revature.gambit.model.Batch;

public interface BatchController {

	Batch save(Batch newBatch);

	Batch findById(int id);

	List<Batch> findByTrainerId(int id);

	List<Batch> findAll();

	void update(Batch updatedBatch);

	void delete(int id);

}
