package com.revature.hydra.entities;

import java.util.Set;

public class Trainee {
	
	private int userId;
	private int resourcesId;
	private int trainingStatus;
	private String phoneNumber;
	private String skypeId;
	private String profileURL;
	private String recruiterName;
	private String college;
	private String degree;
	private String major;
	private String techScreener;
	private String projectCompletion;
	private int flagStatus;
	private int flagNotes;
	private Set<Integer> grades;
	private Set<Integer> notes;
	private Set<Integer> panelInterviews;
	private int totals;
	private String marketingStatus;
	private String client;
	private String endClient;
	private int traineeId;
	private User traineeUserInfo;
	
	public Trainee() {
		super();
	}

	public Trainee(int userId, int resourcesId, int trainingStatus, String phoneNumber, String skypeId,
			String profileURL, String recruiterName, String college, String degree, String major, String techScreener,
			String projectCompletion, int flagStatus, int flagNotes, Set<Integer> grades, Set<Integer> notes,
			Set<Integer> panelInterviews, int totals, String marketingStatus, String client, String endClient,
			int traineeId, User traineeUserInfo) {
		super();
		this.userId = userId;
		this.resourcesId = resourcesId;
		this.trainingStatus = trainingStatus;
		this.phoneNumber = phoneNumber;
		this.skypeId = skypeId;
		this.profileURL = profileURL;
		this.recruiterName = recruiterName;
		this.college = college;
		this.degree = degree;
		this.major = major;
		this.techScreener = techScreener;
		this.projectCompletion = projectCompletion;
		this.flagStatus = flagStatus;
		this.flagNotes = flagNotes;
		this.grades = grades;
		this.notes = notes;
		this.panelInterviews = panelInterviews;
		this.totals = totals;
		this.marketingStatus = marketingStatus;
		this.client = client;
		this.endClient = endClient;
		this.traineeId = traineeId;
		this.traineeUserInfo = traineeUserInfo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getResourcesId() {
		return resourcesId;
	}

	public void setResourcesId(int resourcesId) {
		this.resourcesId = resourcesId;
	}

	public int getTrainingStatus() {
		return trainingStatus;
	}

	public void setTrainingStatus(int trainingStatus) {
		this.trainingStatus = trainingStatus;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getProfileURL() {
		return profileURL;
	}

	public void setProfileURL(String profileURL) {
		this.profileURL = profileURL;
	}

	public String getRecruiterName() {
		return recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTechScreener() {
		return techScreener;
	}

	public void setTechScreener(String techScreener) {
		this.techScreener = techScreener;
	}

	public String getProjectCompletion() {
		return projectCompletion;
	}

	public void setProjectCompletion(String projectCompletion) {
		this.projectCompletion = projectCompletion;
	}

	public int getFlagStatus() {
		return flagStatus;
	}

	public void setFlagStatus(int flagStatus) {
		this.flagStatus = flagStatus;
	}

	public int getFlagNotes() {
		return flagNotes;
	}

	public void setFlagNotes(int flagNotes) {
		this.flagNotes = flagNotes;
	}

	public Set<Integer> getGrades() {
		return grades;
	}

	public void setGrades(Set<Integer> grades) {
		this.grades = grades;
	}

	public Set<Integer> getNotes() {
		return notes;
	}

	public void setNotes(Set<Integer> notes) {
		this.notes = notes;
	}

	public Set<Integer> getPanelInterviews() {
		return panelInterviews;
	}

	public void setPanelInterviews(Set<Integer> panelInterviews) {
		this.panelInterviews = panelInterviews;
	}

	public int getTotals() {
		return totals;
	}

	public void setTotals(int totals) {
		this.totals = totals;
	}

	public String getMarketingStatus() {
		return marketingStatus;
	}

	public void setMarketingStatus(String marketingStatus) {
		this.marketingStatus = marketingStatus;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getEndClient() {
		return endClient;
	}

	public void setEndClient(String endClient) {
		this.endClient = endClient;
	}

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public User getTraineeUserInfo() {
		return traineeUserInfo;
	}

	public void setTraineeUserInfo(User traineeUserInfo) {
		this.traineeUserInfo = traineeUserInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((college == null) ? 0 : college.hashCode());
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result + ((endClient == null) ? 0 : endClient.hashCode());
		result = prime * result + flagNotes;
		result = prime * result + flagStatus;
		result = prime * result + ((grades == null) ? 0 : grades.hashCode());
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((marketingStatus == null) ? 0 : marketingStatus.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((panelInterviews == null) ? 0 : panelInterviews.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((profileURL == null) ? 0 : profileURL.hashCode());
		result = prime * result + ((projectCompletion == null) ? 0 : projectCompletion.hashCode());
		result = prime * result + ((recruiterName == null) ? 0 : recruiterName.hashCode());
		result = prime * result + resourcesId;
		result = prime * result + ((skypeId == null) ? 0 : skypeId.hashCode());
		result = prime * result + ((techScreener == null) ? 0 : techScreener.hashCode());
		result = prime * result + totals;
		result = prime * result + traineeId;
		result = prime * result + ((traineeUserInfo == null) ? 0 : traineeUserInfo.hashCode());
		result = prime * result + trainingStatus;
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
		Trainee other = (Trainee) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (college == null) {
			if (other.college != null)
				return false;
		} else if (!college.equals(other.college))
			return false;
		if (degree == null) {
			if (other.degree != null)
				return false;
		} else if (!degree.equals(other.degree))
			return false;
		if (endClient == null) {
			if (other.endClient != null)
				return false;
		} else if (!endClient.equals(other.endClient))
			return false;
		if (flagNotes != other.flagNotes)
			return false;
		if (flagStatus != other.flagStatus)
			return false;
		if (grades == null) {
			if (other.grades != null)
				return false;
		} else if (!grades.equals(other.grades))
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (marketingStatus == null) {
			if (other.marketingStatus != null)
				return false;
		} else if (!marketingStatus.equals(other.marketingStatus))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (panelInterviews == null) {
			if (other.panelInterviews != null)
				return false;
		} else if (!panelInterviews.equals(other.panelInterviews))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (profileURL == null) {
			if (other.profileURL != null)
				return false;
		} else if (!profileURL.equals(other.profileURL))
			return false;
		if (projectCompletion == null) {
			if (other.projectCompletion != null)
				return false;
		} else if (!projectCompletion.equals(other.projectCompletion))
			return false;
		if (recruiterName == null) {
			if (other.recruiterName != null)
				return false;
		} else if (!recruiterName.equals(other.recruiterName))
			return false;
		if (resourcesId != other.resourcesId)
			return false;
		if (skypeId == null) {
			if (other.skypeId != null)
				return false;
		} else if (!skypeId.equals(other.skypeId))
			return false;
		if (techScreener == null) {
			if (other.techScreener != null)
				return false;
		} else if (!techScreener.equals(other.techScreener))
			return false;
		if (totals != other.totals)
			return false;
		if (traineeId != other.traineeId)
			return false;
		if (traineeUserInfo == null) {
			if (other.traineeUserInfo != null)
				return false;
		} else if (!traineeUserInfo.equals(other.traineeUserInfo))
			return false;
		if (trainingStatus != other.trainingStatus)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
}
