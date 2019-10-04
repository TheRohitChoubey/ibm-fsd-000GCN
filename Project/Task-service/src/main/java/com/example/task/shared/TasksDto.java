package com.example.task.shared;


public class TasksDto {

	private String taskName;
	private String startDate;
	private String endDate;
	private String status;
	private Long projectId;
	
	public TasksDto() {
		super();
	}

	public TasksDto(String taskName,String startDate, String endDate, String status,
			 Long projectId) {
		super();
		this.taskName = taskName;
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
