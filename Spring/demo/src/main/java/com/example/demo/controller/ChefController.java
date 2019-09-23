package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Direction;
import com.example.demo.entity.Ingredients;
import com.example.demo.entity.Notes;
import com.example.demo.entity.Recipe;
import com.example.demo.service.ChefService;

@RestController
@RequestMapping("/api")
public class ChefController {
	private ChefService service;

	public ChefController(ChefService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/recipes")
	public void addRecipe() {
		service.getAllRecipes();
	}
	
	@PostMapping("/recipes")
	public void addRecipe(@RequestBody Recipe theRecipe) {
		service.createRecipe(theRecipe);
	}
	
	@DeleteMapping("/recipes/{id}")
	public void deleteRecipe(@PathVariable("id") Long id) {
		service.deleteRecipe(id);
	}
	
	@PostMapping("/notes")
	public void addNotes(@RequestBody Notes theNote) {
		service.createNote(theNote);
	}
	
	@PostMapping("/directions")
	public void addNotes(@RequestBody Direction theDirection) {
		service.createDirection(theDirection);
	}
	
	@PostMapping("/ingredients")
	public void addIngredients(@RequestBody Ingredients theIngredients) {
		service.createIngredients(theIngredients);
	}
	
	
}
