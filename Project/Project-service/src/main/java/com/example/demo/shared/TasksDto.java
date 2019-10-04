package com.example.demo.shared;

public class TasksDto {

	private String taskName;
	private String taskLeader;
	private String startDate;
	private String endDate;
	private String status;
	private Long projectId;
	
	public TasksDto() {
		super();
	}

	public TasksDto(String taskName, String taskLeader, String startDate, String endDate, String status,
			 Long projectId) {
		super();
		this.taskName = taskName;
		this.taskLeader = taskLeader;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.projectId = projectId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskLeader() {
		return taskLeader;
	}

	public void setTaskLeader(String taskLeader) {
		this.taskLeader = taskLeader;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	
}
