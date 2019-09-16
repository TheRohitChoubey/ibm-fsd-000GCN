package com.example.demo.controller;

import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Jokes;
import com.example.demo.service.JokeService;

@RestController
@RequestMapping("/api")
public class ChefController {
	private JokeService service;

	public ChefController(JokeService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/recipes")
	public void getJokes(Model theModel) {
		Optional<Jokes> jokes = service.getJoke();
		theModel.addAttribute("jokes", jokes);
	}
	
	@PostMapping("/recipes")
	public void addJokes(@RequestBody Jokes theJoke) {
		service.createJokes(theJoke);
	}
	
}
