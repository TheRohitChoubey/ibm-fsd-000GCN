package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Jokes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Lob
	private String jokes;
	
	public Jokes(Long id, String jokes) {
		super();
		this.id = id;
		this.jokes = jokes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJokes() {
		return jokes;
	}

	public void setJokes(String jokes) {
		this.jokes = jokes;
	}

	
}
