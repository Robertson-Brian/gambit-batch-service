package com.revature.gambit.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

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
import javax.persistence.Transient;

@Entity
@EntityScan("Batch")
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
	private int trainer;

	@Column(name="COTRAINER_ID")
	private int cotrainer = 0;

	@Column(name="SKILL_TYPE")
	private String skillType;

	@Column(name="TRAINING_TYPE")
	private String trainingType;

	@Column(name="START_DATE")
	private Timestamp startDate;

	@Column(name="END_DATE")
	private Timestamp endDate;

	@Column(name="LOCATION")
	private String location;

	@Column(name="CURRICULUM")
	private String curriculum;
	
	@Transient
	private Set<Integer> notes;

	@Transient
	private Set<Integer> trainees;
	
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Batch(int batchId, int resourceId, String trainingName, int trainer, int cotrainer, String skillType,
			String trainingType, Timestamp startDate, Timestamp endDate, String location, String curriculum,
			Set<Integer> notes, Set<Integer> trainees) {
		super();
		this.batchId = batchId;
		this.resourceId = resourceId;
		this.trainingName = trainingName;
		this.trainer = trainer;
		this.cotrainer = cotrainer;
		this.skillType = skillType;
		this.trainingType = trainingType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.curriculum = curriculum;
		this.notes = notes;
		this.trainees = trainees;
	}

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", resourceId=" + resourceId + ", trainingName=" + trainingName
				+ ", trainer=" + trainer + ", cotrainer=" + cotrainer + ", skillType=" + skillType + ", trainingType="
				+ trainingType + ", startDate=" + startDate + ", endDate=" + endDate + ", location=" + location
				+ ", curriculum=" + curriculum + ", notes=" + notes + ", trainees=" + trainees + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchId;
		result = prime * result + cotrainer;
		result = prime * result + ((curriculum == null) ? 0 : curriculum.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + resourceId;
		result = prime * result + ((skillType == null) ? 0 : skillType.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((trainees == null) ? 0 : trainees.hashCode());
		result = prime * result + trainer;
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
		if (cotrainer != other.cotrainer)
			return false;
		if (curriculum == null) {
			if (other.curriculum != null)
				return false;
		} else if (!curriculum.equals(other.curriculum))
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
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (resourceId != other.resourceId)
			return false;
		if (skillType == null) {
			if (other.skillType != null)
				return false;
		} else if (!skillType.equals(other.skillType))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (trainees == null) {
			if (other.trainees != null)
				return false;
		} else if (!trainees.equals(other.trainees))
			return false;
		if (trainer != other.trainer)
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

	public int getTrainer() {
		return trainer;
	}

	public void setTrainer(int trainer) {
		this.trainer = trainer;
	}

	public int getCotrainer() {
		return cotrainer;
	}

	public void setCotrainer(int cotrainer) {
		this.cotrainer = cotrainer;
	}

	public String getSkillType() {
		return skillType;
	}

	public void setSkillType(String skillType) {
		this.skillType = skillType;
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

	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
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
