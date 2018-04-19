package com.revature.gambit.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	@OneToMany(mappedBy="noteBatch", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<NoteID> notesIds;

	@OneToMany(mappedBy="traineeBatch")
	private Set<TraineeId> traineesIds;
	
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Batch(int batchId, int resourceId, String trainingName, int trainerId, int cotrainerId, int skillTypeId,
			String trainingType, Timestamp startDate, Timestamp endDate, String location, Set<NoteID> notesIds,
			Set<TraineeId> traineesIds) {
		super();
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
		this.notesIds = notesIds;
		this.traineesIds = traineesIds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchId;
		result = prime * result + cotrainerId;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((notesIds == null) ? 0 : notesIds.hashCode());
		result = prime * result + resourceId;
		result = prime * result + skillTypeId;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((traineesIds == null) ? 0 : traineesIds.hashCode());
		result = prime * result + trainerId;
		result = prime * result + ((trainingName == null) ? 0 : trainingName.hashCode());
		result = prime * result + ((trainingType == null) ? 0 : trainingType.hashCode());
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
		Batch other = (Batch) obj;
		if (batchId != other.batchId)
			return false;
		if (cotrainerId != other.cotrainerId)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (notesIds == null) {
			if (other.notesIds != null)
				return false;
		} else if (!notesIds.equals(other.notesIds))
			return false;
		if (resourceId != other.resourceId)
			return false;
		if (skillTypeId != other.skillTypeId)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (traineesIds == null) {
			if (other.traineesIds != null)
				return false;
		} else if (!traineesIds.equals(other.traineesIds))
			return false;
		if (trainerId != other.trainerId)
			return false;
		if (trainingName == null) {
			if (other.trainingName != null)
				return false;
		} else if (!trainingName.equals(other.trainingName))
			return false;
		if (trainingType == null) {
			if (other.trainingType != null)
				return false;
		} else if (!trainingType.equals(other.trainingType))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "Batch [batchId=" + batchId + ", resourceId=" + resourceId + ", trainingName=" + trainingName
//				+ ", trainerId=" + trainerId + ", cotrainerId=" + cotrainerId + ", skillTypeId=" + skillTypeId
//				+ ", trainingType=" + trainingType + ", startDate=" + startDate + ", endDate=" + endDate + ", location="
//				+ location + ", notesIds=" + notesIds + ", traineesIds=" + traineesIds + "]";
//	}

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

	public Set<NoteID> getNotesIds() {
		return notesIds;
	}

	public void setNotesIds(Set<NoteID> notesIds) {
		this.notesIds = notesIds;
	}

	public Set<TraineeId> getTraineesIds() {
		return traineesIds;
	}

	public void setTraineesIds(Set<TraineeId> traineesIds) {
		this.traineesIds = traineesIds;
	}

	
	
	
	
	

	

	
	
}
