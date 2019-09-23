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

import com.example.demo.model.CreateDoctorRequestModel;
import com.example.demo.model.CreateDoctorResponseModel;
import com.example.demo.service.DoctorService;
import com.example.demo.shared.DoctorDto;

@RestController
@RequestMapping("/")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	@GetMapping("/patient/{disease}")
	public ResponseEntity<?> getByDisease(@PathVariable("disease") String disease) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		DoctorDto tempDto = doctorService.findbyDisease(disease);
		CreateDoctorResponseModel model = mapper.map(tempDto, CreateDoctorResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(model);

	}

}
