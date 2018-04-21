package com.revature.gambit.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name="BATCH")
public class Batch {
	@Id
	@Column(name="BATCH_ID")
	@SequenceGenerator(name = "BATCH_ID_SEQ", sequenceName = "BATCH_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "BATCH_ID_SEQ", strategy = GenerationType.SEQUENCE)
	private int batchId;

	@Column(name="RESOURCE_ID")
	private int resourceId;
	
	@Column(name="TRAINING_NAME")
	private String trainingName;

	@Column(name="TRAINER_ID")
	private int trainerId;

	@Column(name="COTRAINER_ID")
	private int cotrainerId;

	@Column(name="SKILL_TYPE")
	private int skillTypeId;

	@Column(name="TRAINING_TYPE")
	private String trainingType;

	@Column(name="START_DATE")
	private Timestamp startDate;

	@Column(name="END_DATE")
	private Timestamp endDate;

	@Column(name="LOCATION")
	private String location;

	@JsonIgnore
	@ElementCollection
	private Set<Integer> notes;

	@JsonIgnore
	@ElementCollection
	private Set<Integer> trainees;
	
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Batch(int resourceId, String trainingName, int trainerId, int cotrainerId, int skillTypeId, String trainingType, Timestamp startDate, Timestamp endDate, String location) {
		this.resourceId = resourceId;
		this.trainingName = trainingName;
		this.trainerId = trainerId;
		this.cotrainerId = cotrainerId;
		this.skillTypeId = skillTypeId;
		this.trainingType = trainingType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Batch{" +
				"batchId=" + batchId +
				", resourceId=" + resourceId +
				", trainingName='" + trainingName + '\'' +
				", trainerId=" + trainerId +
				", cotrainerId=" + cotrainerId +
				", skillTypeId=" + skillTypeId +
				", trainingType='" + trainingType + '\'' +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", location='" + location + '\'' +
				", notes=" + notes +
				", trainees=" + trainees +
				'}';
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public int getCotrainerId() {
		return cotrainerId;
	}

	public void setCotrainerId(int cotrainerId) {
		this.cotrainerId = cotrainerId;
	}

	public int getSkillTypeId() {
		return skillTypeId;
	}

	public void setSkillTypeId(int skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	public String getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@JsonCreator
	public Set<Integer> getNotes() {
		return notes;
	}

	public void setNotes(Set<Integer> notes) {
		this.notes = notes;
	}

	@JsonCreator
	public Set<Integer> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Integer> trainees) {
		this.trainees = trainees;
	}
}