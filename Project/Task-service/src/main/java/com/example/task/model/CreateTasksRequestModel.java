package com.example.task.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateTasksRequestModel {
	private String taskName;
	private String startDate;
	private String endDate;
	private String status;
	private Long projectId;
	
	public CreateTasksRequestModel() {
		super();
	}

	public CreateTasksRequestModel(String taskName,String startDate, String endDate,
			String status, Long projectId) {
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

	@Override
	public String toString() {
		return "CreateTasksRequestModel [taskName=" + taskName + ",startDate="
				+ startDate + ", endDate=" + endDate + ", status=" + status + "]";
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
}
