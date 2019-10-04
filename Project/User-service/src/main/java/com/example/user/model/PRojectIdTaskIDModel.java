package com.example.user.model;

import java.util.Arrays;
import java.util.List;

public class PRojectIdTaskIDModel {
	private Long projectId;
	private List<Long> taskIDs;
	
	public PRojectIdTaskIDModel() {
		super();
	}

	public PRojectIdTaskIDModel(Long projectId, List<Long> taskIDs) {
		super();
		this.projectId = projectId;
		this.taskIDs = taskIDs;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public List<Long> getTaskIDs() {
		return taskIDs;
	}

	public void setTaskIDs(List<Long> taskIDs) {
		this.taskIDs = taskIDs;
	}

	@Override
	public String toString() {
		return "PRojectIdTaskIDModel [projectId=" + projectId + ", taskIDs=" + taskIDs + "]";
	}

}
