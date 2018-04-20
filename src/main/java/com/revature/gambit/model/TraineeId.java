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
	private Batch traineeBatch;
	
	@Id
	@Column(name="trainee_id")
	private int traineeId;

	public TraineeId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TraineeId(Batch traineeBatch, int traineeId) {
		super();
		this.traineeBatch = traineeBatch;
		this.traineeId = traineeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((traineeBatch == null) ? 0 : traineeBatch.hashCode());
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
		if (traineeBatch == null) {
			if (other.traineeBatch != null)
				return false;
		} else if (!traineeBatch.equals(other.traineeBatch))
			return false;
		if (traineeId != other.traineeId)
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "TraineeId [traineeBatch=" + traineeBatch + ", traineeId=" + traineeId + "]";
//	}

	public Batch getTraineeBatch() {
		return traineeBatch;
	}

	public void setTraineeBatch(Batch traineeBatch) {
		this.traineeBatch = traineeBatch;
	}

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	
	
	
	

}
