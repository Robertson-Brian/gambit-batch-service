package com.revature.hydra.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Trainer {

	@Transient
	private int userId;
	@Transient
	private String title;
	@Transient
	private Set<Batch> batches;
	@Column(name = "trainer_id")
	private int trainerId;
	
	public Trainer() {
		super();
	}

	public Trainer(int userId, String title, Set<Batch> batches, int trainerId) {
		super();
		this.userId = userId;
		this.title = title;
		this.batches = batches;
		this.trainerId = trainerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batches == null) ? 0 : batches.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + trainerId;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainer other = (Trainer) obj;
		if (batches == null) {
			if (other.batches != null)
				return false;
		} else if (!batches.equals(other.batches))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (trainerId != other.trainerId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Batch> getBatches() {
		return batches;
	}

	public void setBatches(Set<Batch> batches) {
		this.batches = batches;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}	
	
}
