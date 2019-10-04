package com.example.user.model;


public class CreateUserResponseModel {
	private String username;
	private String password;
	private String ulocation;
	private String availability;
	private String email;
	private String udomain;
	private String previous_project;
	private String userType;
	private Long projectid;
	private Long taskId;
	private String uStatus;
	private String uAssigndate;
	
	public CreateUserResponseModel() {
		super();
	}

	public CreateUserResponseModel(String username, String password, String ulocation, String availability, String email,
			String udomain, String previous_project, String userType, Long projectid, Long taskId) {
		super();
		this.username = username;
		this.password = password;
		this.ulocation = ulocation;
		this.availability = availability;
		this.email = email;
		this.udomain = udomain;
		this.previous_project = previous_project;
		this.userType = userType;
		this.projectid = projectid;
		this.taskId = taskId;
	}
	
	public CreateUserResponseModel(String username, String password, String ulocation, String availability, String email,
			 String udomain, String previous_project, String userType, Long projectid, Long taskId,
			String uAssigndate) {
		super();
		this.username = username;
		this.password = password;
		this.ulocation = ulocation;
		this.availability = availability;
		this.email = email;
		this.udomain = udomain;
		this.previous_project = previous_project;
		this.userType = userType;
		this.projectid = projectid;
		this.taskId = taskId;
		this.uAssigndate = uAssigndate;
	}

	public CreateUserResponseModel(String username, String password, String ulocation, String availability, String email,
		 String udomain, String previous_project, String userType, Long projectid, Long taskId,
			String uStatus, String uAssigndate) {
		super();
		this.username = username;
		this.password = password;
		this.ulocation = ulocation;
		this.availability = availability;
		this.email = email;
		this.udomain = udomain;
		this.previous_project = previous_project;
		this.userType = userType;
		this.projectid = projectid;
		this.taskId = taskId;
		this.uStatus = uStatus;
		this.uAssigndate = uAssigndate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUlocation() {
		return ulocation;
	}

	public void setUlocation(String ulocation) {
		this.ulocation = ulocation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUdomain() {
		return udomain;
	}

	public void setUdomain(String udomain) {
		this.udomain = udomain;
	}

	public String getPrevious_project() {
		return previous_project;
	}

	public void setPrevious_project(String previous_project) {
		this.previous_project = previous_project;
	}

	public Long getProjectid() {
		return projectid;
	}

	public void setProjectid(Long projectid) {
		this.projectid = projectid;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getuStatus() {
		return uStatus;
	}

	public void setuStatus(String uStatus) {
		this.uStatus = uStatus;
	}

	public String getuAssigndate() {
		return uAssigndate;
	}

	public void setuAssigndate(String uAssigndate) {
		this.uAssigndate = uAssigndate;
	}

	@Override
	public String toString() {
		return "CreateUserResponseModel [username=" + username + ", password=" + password + ", ulocation="
				+ ulocation + ", availability=" + availability + ", email=" + email + ", udomain="
				+ udomain + ", previous_project=" + previous_project + ", userType=" + userType + ", projectid="
				+ projectid + ", taskId=" + taskId + ", uStatus=" + uStatus + ", uAssigndate=" + uAssigndate + "]";
	}
	
}
