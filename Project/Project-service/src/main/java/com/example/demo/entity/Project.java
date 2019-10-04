package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;
	private String pname;
	private String plocation;
	private String start_date;
	private String end_date;
	private String pmanagerEmail;

	public Project() {
		super();
	}

	public Project(String pname, String plocation, String start_date, String end_date,
			String pmanagerEmail) {
		super();
		this.pname = pname;
		this.plocation = plocation;
		this.start_date = start_date;
		this.end_date = end_date;
		this.pmanagerEmail = pmanagerEmail;
	}
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPlocation() {
		return plocation;
	}

	public void setPlocation(String plocation) {
		this.plocation = plocation;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getPmanagerEmail() {
		return pmanagerEmail;
	}

	public void setPmanagerEmail(String pmanagerEmail) {
		this.pmanagerEmail = pmanagerEmail;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", pname=" + pname + ", plocation=" + plocation + ", start_date="
				+ start_date + ", end_date=" + end_date + ", pmanagerEmail="
				+ pmanagerEmail + "]";
	}

	

}
