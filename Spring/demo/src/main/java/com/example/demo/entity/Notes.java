package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String recipeNotes;
	
	@Transient
	private Long recipe_id;
	
	@OneToOne
	private Recipe recipe;
	
	public Notes() {
		super();
	}

	public Notes(String recipeNotes, Long recipe_id, Recipe recipe) {
		super();
		this.recipeNotes = recipeNotes;
		this.recipe_id = recipe_id;
		this.recipe = recipe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecipeNotes() {
		return recipeNotes;
	}

	public void setRecipeNotes(String recipeNotes) {
		this.recipeNotes = recipeNotes;
	}

	public Long getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(Long recipe_id) {
		this.recipe_id = recipe_id;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	
}
