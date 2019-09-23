package com.example.task.freignInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.task.model.CreateTasksRequestModel;
import com.example.task.model.CreateTeamsRequestModel;
import com.example.task.shared.TasksDto;
import com.example.task.shared.TeamsDto;

@FeignClient(name = "TEAMS")
public interface TasksServiceFriegnClient {
	@PostMapping("/teams")
	public TeamsDto createTeam(CreateTeamsRequestModel teamDetail);
}
