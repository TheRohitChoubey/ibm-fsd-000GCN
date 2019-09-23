package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String servingTime;
	
	@ManyToMany(mappedBy = "recipe")
	private Set<Ingredients> ingredients = new HashSet();
	
	public Recipe() {
		super();
	}

	public Recipe(String name, String servingTime, Set<Ingredients> ingredients) {
		super();
		this.name = name;
		this.servingTime = servingTime;
		this.ingredients = ingredients;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServingTime() {
		return servingTime;
	}

	public void setServingTime(String servingTime) {
		this.servingTime = servingTime;
	}

	public Set<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}
}
