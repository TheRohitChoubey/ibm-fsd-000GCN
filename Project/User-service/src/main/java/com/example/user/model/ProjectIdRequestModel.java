package com.example.user.model;

public class ProjectIdRequestModel {
	private Long projectId;
	private String plocation;
	private String pmanagerEmail;
	
	
	public ProjectIdRequestModel() {
		super();
	}
	
	public ProjectIdRequestModel(Long projectId, String plocation, String pmanagerEmail) {
		super();
		this.projectId = projectId;
		this.plocation = plocation;
		this.pmanagerEmail = pmanagerEmail;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getPlocation() {
		return plocation;
	}

	public void setPlocation(String plocation) {
		this.plocation = plocation;
	}

	public String getPmanagerEmail() {
		return pmanagerEmail;
	}

	public void setPmanagerEmail(String pmanagerEmail) {
		this.pmanagerEmail = pmanagerEmail;
	}

	@Override
	public String toString() {
		return "ProjectIdRequestModel [projectId=" + projectId + ", plocation=" + plocation + ", pmanagerEmail="
				+ pmanagerEmail + "]";
	}
	
	
	
}
