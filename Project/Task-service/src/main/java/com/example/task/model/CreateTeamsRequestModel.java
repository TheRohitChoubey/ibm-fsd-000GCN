package com.example.task.model;

public class CreateTeamsRequestModel {
	private Long userid;
	private String uemail;
	private String uassigndate;
	private String ustatus;
	private Long taskId;
	private Long projectId;

	public CreateTeamsRequestModel() {
		super();
	}

	public CreateTeamsRequestModel(Long userid, String uemail,
			String uassigndate, String ustatus, Long taskId,Long projectId) {
		super();
		this.userid = userid;
		this.uemail = uemail;
		this.uassigndate = uassigndate;
		this.ustatus = ustatus;
		this.taskId = taskId;
		this.projectId = projectId;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUassigndate() {
		return uassigndate;
	}

	public void setUassigndate(String uassigndate) {
		this.uassigndate = uassigndate;
	}

	public String getUstatus() {
		return ustatus;
	}

	public void setUstatus(String ustatus) {
		this.ustatus = ustatus;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "CreateTeamsRequestModel [userid=" + userid + ", uemail=" + uemail + ", uassigndate=" + uassigndate
				+ ", ustatus=" + ustatus + ", taskId=" + taskId + ", projectId=" + projectId + "]";
	}

	
	
}
