package com.IBm._myfirstSpring_Project.beans;

public class BaseballCoach implements Coach {
	private String id,name;
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "practice back volley";
	}
	
	public BaseballCoach() {
		super();
	}
	
	public BaseballCoach(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "BaseballCoach [id=" + id + ", name=" + name + "]";
	}

}
