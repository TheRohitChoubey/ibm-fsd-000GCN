package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class League {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String season;
	private int year;
	
	public League() {
		super();
	}

	public League(String title, String season, int year) {
		super();
		this.title = title;
		this.season = season;
		this.year = year;
	}
	
	public League(Long id, String title, String season, int year) {
		super();
		this.id = id;
		this.title = title;
		this.season = season;
		this.year = year;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "League [id=" + id + ", title=" + title + ", season=" + season + ", year=" + year + "]";
	}
	
}
