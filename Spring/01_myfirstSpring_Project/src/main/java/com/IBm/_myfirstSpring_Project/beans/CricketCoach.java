package com.IBm._myfirstSpring_Project.beans;

public class CricketCoach implements Coach {
	private String email;
	private String teamName;
	
	public CricketCoach() {
		super();
	}

	public CricketCoach(String email, String teamName) {
		super();
		this.email = email;
		this.teamName = teamName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getDailyWorkout() {
		
		return "practice 5k running today";
	}

	@Override
	public String toString() {
		return "CricketCoach [email=" + email + ", teamName=" + teamName + "]";
	}
	
	
}
