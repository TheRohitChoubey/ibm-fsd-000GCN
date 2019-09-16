package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.League;
import com.example.demo.repository.LeagueRepository;
import com.example.demo.service.LeagueService;

@RestController
@RequestMapping("/api")
public class LeagueController {

	private LeagueService service;
	
	
	public LeagueController(LeagueService service) {
		super();
		this.service = service;
	}


	/*
	 * private LeagueRepository leagueRepository;
	 * 
	 * public LeagueController(LeagueRepository leagueRepository) { super();
	 * this.leagueRepository = leagueRepository; }
	 */
	@PostMapping("/leagues")
	public void addLeague(@RequestBody League theLeague) {
		//leagueRepository.save(theLeague);
		service.createLeague(theLeague);
	}
}
