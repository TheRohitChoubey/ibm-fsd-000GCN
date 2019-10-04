package com.example.demo.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.CreateTasksRequestModel;
import com.example.demo.model.ProjectIdRequestModel;

@FeignClient(name = "USER")
public interface UserFeignClient {
	@PostMapping("/projectAssignedUserDetail")
	public ResponseEntity<?> projectAssignedUserDetail(ProjectIdRequestModel projectDetail);

	@PostMapping("/projectDeletedUserDetail")
	public ResponseEntity<?> projectDeletedUserDetail(ProjectIdRequestModel projectDetail);
	
	
}
