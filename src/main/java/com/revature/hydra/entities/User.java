package com.revature.hydra.entities;

public class User {
	private int userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	private String backupPassword;
	private int role;
	private int homePhone;
	private int mobilePhone;
	private String token;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String firstName, String middleName, String lastName, String email, String password,
			String backupPassword, int role, int homePhone, int mobilePhone, String token) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.backupPassword = backupPassword;
		this.role = role;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.token = token;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBackupPassword() {
		return backupPassword;
	}
	public void setBackupPassword(String backupPassword) {
		this.backupPassword = backupPassword;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(int homePhone) {
		this.homePhone = homePhone;
	}
	public int getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(int mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backupPassword == null) ? 0 : backupPassword.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + homePhone;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + mobilePhone;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + role;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		User other = (User) obj;
		if (backupPassword == null) {
			if (other.backupPassword != null)
				return false;
		} else if (!backupPassword.equals(other.backupPassword))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (homePhone != other.homePhone)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (mobilePhone != other.mobilePhone)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role != other.role)
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
}
