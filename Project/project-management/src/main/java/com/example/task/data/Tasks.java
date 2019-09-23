
package com.example.task.data;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Tasks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	private String taskName;
	private String taskLeader;
	private String startDate;
	private String endDate;
	private String status;
	
	@OneToMany(mappedBy = "tasks", cascade = CascadeType.ALL)
    private Set<Teams> teamsDetails;
	
	public Tasks() {
		super();
	}
	
	public Tasks(String taskName, String taskLeader, String startDate, String endDate, String status,
			Set<Teams> teamsDetails) {
		super();
		this.taskName = taskName;
		this.taskLeader = taskLeader;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.teamsDetails = teamsDetails;
	}

	public Tasks(String taskName, String taskLeader, String startDate, String endDate, String status) {
		super();
		this.taskName = taskName;
		this.taskLeader = taskLeader;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
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
	
	public Set<Teams> getTeamsDetails() {
		return teamsDetails;
	}

	public void setTeamsDetails(Set<Teams> teamsDetails) {
		this.teamsDetails = teamsDetails;
	}
	
}
