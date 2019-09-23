package com.example.demo.freignInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.CreatePatientRequestModel;
import com.example.demo.shared.PatientDto;

@FeignClient(name = "DOCTOR")
public interface PatientServiceFriegnClient {
	@GetMapping("/patient/{disease}")
	public ResponseEntity<?> getByDisease(String disease);
}
