package com.example.task.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateTeamsResponseModel {
	
	private String userid;
	private String ufirstName;
	private String ulastName;
	private String uemail;
	private String uassigndate;
	private Long taskid;
	private String ustatus;
	
	public CreateTeamsResponseModel() {
		super();
	}

	public CreateTeamsResponseModel(String userid, String ufirstName, String ulastName, String uemail,
			String uassigndate, String ustatus) {
		super();
		this.userid = userid;
		this.ufirstName = ufirstName;
		this.ulastName = ulastName;
		this.uemail = uemail;
		this.uassigndate = uassigndate;
		this.ustatus = ustatus;
	}
	
	public CreateTeamsResponseModel(String userid, String ufirstName, String ulastName, String uemail,
			String uassigndate, Long taskid, String ustatus) {
		super();
		this.userid = userid;
		this.ufirstName = ufirstName;
		this.ulastName = ulastName;
		this.uemail = uemail;
		this.uassigndate = uassigndate;
		this.taskid = taskid;
		this.ustatus = ustatus;
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
	
	public Long getTaskid() {
		return taskid;
	}

	public void setTaskid(Long taskid) {
		this.taskid = taskid;
	}

	@Override
	public String toString() {
		return "CreateTeamsResponseModel [userid=" + userid + ", ufirstName=" + ufirstName + ", ulastName=" + ulastName
				+ ", uemail=" + uemail + ", uassigndate=" + uassigndate + ", ustatus=" + ustatus + "]";
	}
}
