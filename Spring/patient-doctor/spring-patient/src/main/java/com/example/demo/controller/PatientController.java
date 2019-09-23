package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.freignInterface.PatientServiceFriegnClient;
import com.example.demo.model.CreatePatientRequestModel;
import com.example.demo.model.CreatePatientResponseModel;
import com.example.demo.service.PatientService;
import com.example.demo.shared.PatientDto;

@RestController
@RequestMapping("/")
public class PatientController {
	@Autowired
	private PatientService userService;

	@Autowired
	PatientServiceFriegnClient patientServiceFriegnClient;

	@PostMapping("/patient")
	public ResponseEntity<CreatePatientResponseModel> create(@RequestBody CreatePatientRequestModel patientDetail) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		PatientDto pDto = mapper.map(patientDetail, PatientDto.class);

		PatientDto tempDto = userService.createPatient(pDto);
		CreatePatientResponseModel model = mapper.map(tempDto, CreatePatientResponseModel.class);
		;
		return ResponseEntity.status(HttpStatus.CREATED).body(model);

	}

	@GetMapping("/patient/{disease}")
	public ResponseEntity<?> fetchProduct(@PathVariable("disease") String disease) {

		return patientServiceFriegnClient.getByDisease(disease);
	}
}
