package com.example.team.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.team.data.Teams;
import com.example.team.shared.TeamsDto;


@Service
public class TeamsServiceImpl implements TeamsService {
	@Autowired
	private Environment env;
	
	@Autowired
	public TeamsServiceImpl(Environment env) {
		super();
		this.env = env;
	}

	@Override
	public TeamsDto createNewTeam(TeamsDto teamDetail) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		Teams teamEntity = mapper.map(teamDetail,Teams.class);
		TeamsDto uDto = mapper.map(teamEntity, TeamsDto.class);
		return uDto;
	}

}
