package com.revature.gambit.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

/**
 * 
 * @author Sam Harmon, Travis Rigg, Yuri Felicio, Peter Farber
 *
 */
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
	
	@Column(name="GOOD_GRADE_THRESHOLD")
	private int goodGradeThreshold;
	
	@Column(name="ADDRESS_ID")
	private int addressId;
	
	@Column(name="BORDERLINE_GRADE_THRESHOLD")
	private int borderlineGradeThreshold;
	
	@Column(name="WEEK")
	private int week;

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
		goodGradeThreshold = 80;
		borderlineGradeThreshold = 70;
	}
	
	/**
	 * Constructor for batch with initial grade thresholds
	 * @param goodGradeThreshold initializes the good grade threshold
	 * @param borderlineGradeThreshold initializes the borderline gradeThreshold
	 */
	public Batch(int goodGradeThreshold, int borderlineGradeThreshold) {
		this();
		this.goodGradeThreshold = goodGradeThreshold;
		this.borderlineGradeThreshold = borderlineGradeThreshold;
	}

	@Override
	public String toString() {
		return "Batch{" +
				"batchId=" + batchId +
				", resourceId=" + resourceId +
				", goodGradeThreshold=" + goodGradeThreshold +
				", addressId=" + addressId +
				", borderlineGradeThreshold=" + borderlineGradeThreshold +
				", week=" + week + 
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
	
	public int getGoodGradeThreshold() {
		return goodGradeThreshold;
	}

	public void setGoodGradeThreshold(int goodGradeThreshold) {
		this.goodGradeThreshold = goodGradeThreshold;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getBorderlineGradeThreshold() {
		return borderlineGradeThreshold;
	}

	public void setBorderlineGradeThreshold(int borderlineGradeThreshold) {
		this.borderlineGradeThreshold = borderlineGradeThreshold;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
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
