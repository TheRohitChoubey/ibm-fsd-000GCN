package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Direction;
import com.example.demo.entity.Ingredients;
import com.example.demo.entity.Notes;
import com.example.demo.entity.Recipe;
import com.example.demo.repository.DirectionRepository;
import com.example.demo.repository.IngredientsRepository;
import com.example.demo.repository.NotesRepository;
import com.example.demo.repository.RecipeRepository;

@Service
public class ChefService {
	private RecipeRepository recipeRepository;
	private IngredientsRepository ingredientsRepository;
	private NotesRepository notesRepository;
	private DirectionRepository directionRepository;

	public ChefService(RecipeRepository recipeRepository, IngredientsRepository ingredientsRepository,
			NotesRepository notesRepository, DirectionRepository directionRepository) {
		super();
		this.recipeRepository = recipeRepository;
		this.ingredientsRepository = ingredientsRepository;
		this.notesRepository = notesRepository;
		this.directionRepository = directionRepository;
	}
	
	public void createRecipe(Recipe recipe) {
		recipeRepository.save(recipe);
		System.out.println("Inserted");
	}
	
	public void deleteRecipe(Long recipe_id) {
		Recipe recipe;
		recipe = recipeRepository.findByid(recipe_id);
		recipeRepository.delete(recipe);
		System.out.println("Inserted");
	}
	
	public void createNote(Notes note) {
		Recipe recipe;
		Long recipe_id = note.getRecipe_id();
		recipe = recipeRepository.findByid(recipe_id);
		note.setRecipe(recipe);
		notesRepository.save(note);
		System.out.println("Inserted");
	}
	
	public void createDirection(Direction direction) {
		Recipe recipe;
		Long recipe_id = direction.getRecipe_id();
		recipe = recipeRepository.findByid(recipe_id);
		direction.setRecipe(recipe);
		directionRepository.save(direction);
		System.out.println("Inserted");
	}
	
	public void createIngredients(Ingredients ingredient) {
		Recipe recipe;
		Long recipe_id = ingredient.getRecipe_id();
		recipe = recipeRepository.findByid(recipe_id);
		ingredient.getRecipe().add(recipe);
		ingredientsRepository.save(ingredient);
		System.out.println("Inserted");
	}

	public void getAllRecipes() {
		
	}
}
