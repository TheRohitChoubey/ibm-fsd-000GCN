package com.example.team.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.team.model.CreateTeamsRequestModel;
import com.example.team.model.CreateTeamsResponseModel;
import com.example.team.service.TeamsService;
import com.example.team.shared.TeamsDto;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TeamsController {
	@Autowired
	private TeamsService teamsService;


	@PostMapping("/team")
	public ResponseEntity<?> createTeam(@RequestBody CreateTeamsRequestModel teamDetail) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TeamsDto tDto = mapper.map(teamDetail, TeamsDto.class);
		TeamsDto tempDto = teamsService.createNewTeam(tDto);
		CreateTeamsResponseModel model = mapper.map(tempDto, CreateTeamsResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(model);
	}

	
}
