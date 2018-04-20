package com.revature.gambit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TRAINEE_IDS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TraineeId {

	@Id
	@Column(name="TRAINEE_ID")
	private int traineeId;

	@Column(name="BATCH_ID")
	private int batchId;

	public TraineeId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TraineeId(int traineeId, int batchId) {
		this.traineeId = traineeId;
		this.batchId = batchId;
	}

	@Override
	public String toString() {
		return "TraineeId{" +
				"traineeId=" + traineeId +
				", batchId=" + batchId +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraineeId traineeId1 = (TraineeId) o;

		if (traineeId != traineeId1.traineeId) return false;
		return batchId == traineeId1.batchId;
	}

	@Override
	public int hashCode() {
		int result = traineeId;
		result = 31 * result + batchId;
		return result;
	}

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
}
