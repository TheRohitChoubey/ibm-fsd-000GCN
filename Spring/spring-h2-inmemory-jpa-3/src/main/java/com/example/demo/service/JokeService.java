package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Jokes;
import com.example.demo.repository.JokesRepository;

@Service
public class JokeService {
	
	private JokesRepository jokesRepository;
	
	public JokeService(JokesRepository jokesRepository) {
		super();
		this.jokesRepository = jokesRepository;
	}

	public void createJokes(Jokes joke) {
		jokesRepository.save(joke);
		System.out.println("Inserted");
	}
	
	public Optional<Jokes> getJoke() {
		Optional<Jokes> jokes;
		int max = 10; 
        int min = 1; 
        int range = max - min + 1;
        int l = (int)(Math.random() * range) + min;
        Long id= new Long(l);
        jokes = jokesRepository.findById(id);
        return jokes;
	}
	
}
