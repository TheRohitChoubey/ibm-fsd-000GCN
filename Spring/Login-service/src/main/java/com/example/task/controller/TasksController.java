package com.example.task.controller;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.data.Login;
import com.example.task.freignInterface.TasksServiceFriegnClient;
import com.example.task.model.CreateTasksRequestModel;
import com.example.task.model.CreateTasksResponseModel;
import com.example.task.model.CreateTeamsRequestModel;
import com.example.task.service.TasksService;
import com.example.task.shared.TasksDto;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TasksController {
	@Autowired
	private TasksService tasksService;


	@PostMapping("/login")
	public ResponseEntity<?> createTask(@RequestBody CreateTasksRequestModel taskDetail) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TasksDto tDto = mapper.map(taskDetail, TasksDto.class);

		TasksDto tempDto = tasksService.createNewTask(tDto);
		CreateTasksResponseModel model = mapper.map(tempDto, CreateTasksResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(model);

	}

	@GetMapping("/tasks/{taskName}")
	public ResponseEntity<CreateTasksResponseModel> getTaskByName(@PathVariable String taskName) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		TasksDto tempDto = tasksService.getTask(taskName);

		CreateTasksResponseModel model = mapper.map(tempDto, CreateTasksResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(model);
	}

	@PostMapping("/tasks/team")
	public ResponseEntity<?> createTeam(@RequestBody CreateTeamsRequestModel teamDetail) {
		System.out.println(teamDetail.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(tasksServiceFriegnClient.createTeam(teamDetail));
	}

}
