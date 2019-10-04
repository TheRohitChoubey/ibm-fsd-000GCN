package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateTasksResponseModel {
	private String taskName;
	private String taskLeader;
	private String startDate;
	private String endDate;
	private String status;
	private Long projectId;
	
	public CreateTasksResponseModel() {
		super();
	}
	

	public CreateTasksResponseModel(String taskName) {
		super();
		this.taskName = taskName;
	}

	public CreateTasksResponseModel(String taskName, String taskLeader, String startDate, String endDate,
			String status, Long projectId) {
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
}
