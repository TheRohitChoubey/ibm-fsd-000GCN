package com.example.team.UserFeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "USER")
public interface UserFeignClient {
	@PostMapping("/taskAssignedUserDetail")
	public ResponseEntity<?> taskAssignedUserDetail(Long projectId);

	@PostMapping("/taskmemberDeletedUserDetail")
	public ResponseEntity<?> memberDeletedUserDetail(Long projectId);
	
	
}
