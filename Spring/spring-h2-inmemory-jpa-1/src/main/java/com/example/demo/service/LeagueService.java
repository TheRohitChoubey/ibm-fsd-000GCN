package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.model.League;
import com.example.demo.repository.LeagueDao;
import com.example.demo.repository.LeagueRepository;

@Service
public class LeagueService {

	private LeagueRepository leagueRepository;


	public LeagueService(LeagueRepository leagueRepository) {
		super();
		this.leagueRepository = leagueRepository;
		System.out.println("Rohit");
	}

	public boolean createLeague(League newLeague) {
		System.out.println("I am lr " + leagueRepository);
		leagueRepository.save(newLeague);
		System.out.println("Inserted");
		return true;
	}

}
