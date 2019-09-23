package com.mycompany.freignInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mycompany.model.CreateUserRequestModel;
import com.mycompany.shared.UserDto;

@FeignClient(name = "USER-SECOND")
public interface UserServiceFriegnClient {
	@PostMapping("/getusers")
	public ResponseEntity<?> getByEmail(CreateUserRequestModel userDetail);
}
