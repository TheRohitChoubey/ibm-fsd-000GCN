package com.example.task.freignInterface;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.task.model.CreateTeamsRequestModel;

@FeignClient(name = "USER")
public interface UserFeignClient {
	
	@PostMapping("/taskAssignedUserDetail")
	public ResponseEntity<?> taskAssignedUserDetail(CreateTeamsRequestModel teamDetail);

	@PostMapping("/taskDeletedUserDetail")
	public ResponseEntity<?> taskDeletedUserDetail(Long taskId);

	@GetMapping("/getAllTeam")
	public List<?> getAllTeam(Long taskId);

	@GetMapping("/deleteTeamMember")
	public boolean deleteTeamMember(String email);
	
	
}
