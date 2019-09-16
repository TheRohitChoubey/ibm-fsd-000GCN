package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Direction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String recipeDirection;
	@Transient
	private Long recipe_id;
	@OneToOne
	private Recipe recipe;

	public Direction(String recipeDirection, Long recipe_id, Recipe recipe) {
		super();
		this.recipeDirection = recipeDirection;
		this.recipe_id = recipe_id;
		this.recipe = recipe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecipeDirection() {
		return recipeDirection;
	}

	public void setRecipeDirection(String recipeDirection) {
		this.recipeDirection = recipeDirection;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Long getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(Long recipe_id) {
		this.recipe_id = recipe_id;
	}
}
