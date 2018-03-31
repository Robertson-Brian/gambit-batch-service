package com.revature.hydra.entities;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
public class Batch {

	@Column(name = "resource_id")
	private int resourceId;

	@Column(name = "training_name")
	private String trainingName;

	@Embedded
	@AttributeOverrides(value = { @AttributeOverride(name = "trainerId", column = @Column(name = "trainer_id"))

	})
	private Trainer trainer;

	@Embedded
	@AttributeOverrides(value = { @AttributeOverride(name = "trainerId", column = @Column(name = "cotrainer_id"))

	})
	private Trainer cotrainer;

	@Column(name = "skill_type")
	private String skillType;

	@Column(name = "training_type")
	private String trainingType;

	@Column(name = "start_date")
	private Timestamp startDate;

	@Column(name = "end_date")
	private Timestamp endDate;

	@Column(name = "location")
	private String location;

	@Column(name = "curriculum")
	private String curriculum;

	@Transient
	private Set<Integer> skills;

	@Transient
	private List<Integer> trainees;

	@Transient
	private Set<Integer> notes;

	@Id
	@Column(name = "batch_id")
	@SequenceGenerator(name = "batch_id_seq", sequenceName = "batch_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "batch_id_seq", strategy = GenerationType.AUTO)
	private int batchId;

	public Batch() {
		super();
	}

	public Batch(int resourceId, String trainingName, Trainer trainer, Trainer cotrainer, String skillType,
			String trainingType, Timestamp startDate, Timestamp endDate, String location, String curriculum,
			Set<Integer> skills, List<Integer> trainees, Set<Integer> notes, int batchId) {
		super();
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
		this.skills = skills;
		this.trainees = trainees;
		this.notes = notes;
		this.batchId = batchId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchId;
		result = prime * result + ((cotrainer == null) ? 0 : cotrainer.hashCode());
		result = prime * result + ((curriculum == null) ? 0 : curriculum.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + resourceId;
		result = prime * result + ((skillType == null) ? 0 : skillType.hashCode());
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((trainees == null) ? 0 : trainees.hashCode());
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
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
		if (cotrainer == null) {
			if (other.cotrainer != null)
				return false;
		} else if (!cotrainer.equals(other.cotrainer))
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
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
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
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
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

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Trainer getCotrainer() {
		return cotrainer;
	}

	public void setCotrainer(Trainer cotrainer) {
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

	public Set<Integer> getSkills() {
		return skills;
	}

	public void setSkills(Set<Integer> skills) {
		this.skills = skills;
	}

	public List<Integer> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Integer> trainees) {
		this.trainees = trainees;
	}

	public Set<Integer> getNotes() {
		return notes;
	}

	public void setNotes(Set<Integer> notes) {
		this.notes = notes;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

}
