package com.mycompny.spring_annotation_demo.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public  class SwimCoach implements Coach{
	@Value("${foo.email}")
	private String email;
	@Value("The Spring Team.")
	private String teamName;
	
	private FortuneService service;
	@Autowired
	public SwimCoach(FortuneService service) {
		super();
		this.service = service;
	}


	public SwimCoach() {
		super();
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


	public SwimCoach(String email, String teamName) {
		super();
		this.email = email;
		this.teamName = teamName;
	}


	public FortuneService getService() {
		return service;
	}

	public void setService(FortuneService service) {
		this.service = service;
	}


	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "test workout";
	}


	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return service.getFortune();
	}
	@PostConstruct
	public void setWaterLevel()
	{
		System.out.println("make water level high.");
	}
	@PreDestroy
	public void destroySwim()
	{
		System.out.println("pre destroy called..");
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
