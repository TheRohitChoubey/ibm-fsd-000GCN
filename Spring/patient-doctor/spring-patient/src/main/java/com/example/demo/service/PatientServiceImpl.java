package com.example.demo.service;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.data.PatientEntity;
import com.example.demo.data.PatientRepository;
import com.example.demo.shared.PatientDto;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private Environment env;
	private PatientRepository patientRepository;

	@Autowired
	public PatientServiceImpl(Environment env, PatientRepository patientRepository) {
		super();
		this.env = env;
		this.patientRepository = patientRepository;
	}

	@Override
	public PatientDto createPatient(PatientDto patientDetail) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		PatientEntity userEntity = mapper.map(patientDetail, PatientEntity.class);
		patientRepository.save(userEntity);
		PatientDto uDto = mapper.map(userEntity, PatientDto.class);

		return uDto;
	}

}
