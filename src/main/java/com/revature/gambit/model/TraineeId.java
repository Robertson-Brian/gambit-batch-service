package com.revature.gambit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TRAINEE_IDS")
public class TraineeId {
	
	@ManyToOne
    @JoinColumn(name="BATCH_ID")
	private Batch batch;
	
	@Id
	@Column(name="trainee_id")
	private int traineeId;

	public TraineeId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TraineeId(Batch batch, int traineeId) {
		super();
		this.batch = batch;
		this.traineeId = traineeId;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batch == null) ? 0 : batch.hashCode());
		result = prime * result + traineeId;
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
		TraineeId other = (TraineeId) obj;
		if (batch == null) {
			if (other.batch != null)
				return false;
		} else if (!batch.equals(other.batch))
			return false;
		if (traineeId != other.traineeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TraineeId [batch=" + batch + ", traineeId=" + traineeId + "]";
	}

	
	
	

}
