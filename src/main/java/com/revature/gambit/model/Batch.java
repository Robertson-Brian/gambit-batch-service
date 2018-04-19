package com.revature.gambit.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="BATCH")
public class Batch {
	@Id
	@Column(name="BATCH_ID")
	@SequenceGenerator(name = "BATCH_ID_SEQ", sequenceName = "BATCH_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "BATCH_ID_SEQ", strategy = GenerationType.AUTO)
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
	
	@ElementCollection
	private Set<Integer> notes;

	@ElementCollection
	private Set<Integer> trainees;
	
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Batch(int batchId, int resourceId, String trainingName, int trainerId, int cotrainerId, int skillTypeId, String trainingType, Timestamp startDate, Timestamp endDate, String location, Set<Integer> notes, Set<Integer> trainees) {
		this.batchId = batchId;
		this.resourceId = resourceId;
		this.trainingName = trainingName;
		this.trainerId = trainerId;
		this.cotrainerId = cotrainerId;
		this.skillTypeId = skillTypeId;
		this.trainingType = trainingType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.notes = notes;
		this.trainees = trainees;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Batch batch = (Batch) o;

		if (batchId != batch.batchId) return false;
		if (resourceId != batch.resourceId) return false;
		if (trainerId != batch.trainerId) return false;
		if (cotrainerId != batch.cotrainerId) return false;
		if (skillTypeId != batch.skillTypeId) return false;
		if (trainingName != null ? !trainingName.equals(batch.trainingName) : batch.trainingName != null) return false;
		if (trainingType != null ? !trainingType.equals(batch.trainingType) : batch.trainingType != null) return false;
		if (startDate != null ? !startDate.equals(batch.startDate) : batch.startDate != null) return false;
		if (endDate != null ? !endDate.equals(batch.endDate) : batch.endDate != null) return false;
		if (location != null ? !location.equals(batch.location) : batch.location != null) return false;
		if (notes != null ? !notes.equals(batch.notes) : batch.notes != null) return false;
		return trainees != null ? trainees.equals(batch.trainees) : batch.trainees == null;
	}

	@Override
	public int hashCode() {
		int result = batchId;
		result = 31 * result + resourceId;
		result = 31 * result + (trainingName != null ? trainingName.hashCode() : 0);
		result = 31 * result + trainerId;
		result = 31 * result + cotrainerId;
		result = 31 * result + skillTypeId;
		result = 31 * result + (trainingType != null ? trainingType.hashCode() : 0);
		result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
		result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
		result = 31 * result + (location != null ? location.hashCode() : 0);
		result = 31 * result + (notes != null ? notes.hashCode() : 0);
		result = 31 * result + (trainees != null ? trainees.hashCode() : 0);
		return result;
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

	public Set<Integer> getNotes() {
		return notes;
	}

	public void setNotes(Set<Integer> notes) {
		this.notes = notes;
	}

	public Set<Integer> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Integer> trainees) {
		this.trainees = trainees;
	}
}
