package com.example.team.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;



@Entity
public class Teams {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamId;
	private String userid;
	private String ufirstName;
	private String ulastName;
	private String uemail;
	private String uassigndate;
	private String ustatus;
	private Long taskId;

	public Teams() {
		super();
	}

	public Teams(String userid, String ufirstName, String ulastName, String uemail, String uassigndate, String ustatus,
			Long taskId) {
		super();
		this.userid = userid;
		this.ufirstName = ufirstName;
		this.ulastName = ulastName;
		this.uemail = uemail;
		this.uassigndate = uassigndate;
		this.ustatus = ustatus;
		this.taskId = taskId;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUfirstName() {
		return ufirstName;
	}

	public void setUfirstName(String ufirstName) {
		this.ufirstName = ufirstName;
	}

	public String getUlastName() {
		return ulastName;
	}

	public void setUlastName(String ulastName) {
		this.ulastName = ulastName;
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

	@Override
	public String toString() {
		return "Teams [teamId=" + teamId + ", userid=" + userid + ", ufirstName=" + ufirstName + ", ulastName="
				+ ulastName + ", uemail=" + uemail + ", uassigndate=" + uassigndate + ", ustatus=" + ustatus
				+ ", taskId=" + taskId + "]";
	}

	
}
