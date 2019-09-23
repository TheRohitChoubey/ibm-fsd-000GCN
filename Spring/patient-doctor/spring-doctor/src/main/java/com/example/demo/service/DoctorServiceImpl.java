package com.example.demo.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.data.DoctorEntity;
import com.example.demo.data.DoctorRepository;
import com.example.demo.shared.DoctorDto;
@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private Environment env;
	private DoctorRepository userRepository;

	@Autowired
	public DoctorServiceImpl(Environment env, DoctorRepository userRepository) {
		super();
		this.env = env;
		this.userRepository = userRepository;
	}

	@Override
	public DoctorDto findbyDisease(String disease) {
		// TODO Auto-generated method stub
		
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		DoctorEntity userEntity=userRepository.findBySpeciality(disease);
		System.out.println(userEntity.toString());
		DoctorDto uDto=mapper.map(userEntity, DoctorDto.class);
		
		return uDto;
	}



}
