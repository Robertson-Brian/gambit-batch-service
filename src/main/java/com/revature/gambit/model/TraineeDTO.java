package com.revature.gambit.model;

import java.util.Set;

/**
 * @author klath
 *	Used for adding Trainees to batches received from messages
 */
public class TraineeDTO {

	private int userId;
	
	private Set<Integer> batches;
	
	public TraineeDTO() {
		super();
	}


	public TraineeDTO(int userId, Set<Integer> batches) {
		super();
		this.userId = userId;
		this.batches = batches;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public Set<Integer> getBatches() {
		return batches;
	}


	public void setBatches(Set<Integer> batches) {
		this.batches = batches;
	}
	
	
	
}