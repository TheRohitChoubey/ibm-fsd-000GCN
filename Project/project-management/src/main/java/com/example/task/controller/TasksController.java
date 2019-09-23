package com.example.task.controller;

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

import com.example.task.data.Tasks;
import com.example.task.freignInterface.TasksServiceFriegnClient;
import com.example.task.model.CreateTasksRequestModel;
import com.example.task.model.CreateTasksResponseModel;
import com.example.task.model.CreateTeamsRequestModel;
import com.example.task.model.CreateTeamsResponseModel;
import com.example.task.service.TasksService;
import com.example.task.shared.TasksDto;
import com.example.task.shared.TeamsDto;

@RestController
public class TasksController {
	@Autowired
	private TasksService tasksService;

	@Autowired
	TasksServiceFriegnClient tasksServiceFriegnClient;

	@PostMapping("/tasks")
	public ResponseEntity<CreateTasksResponseModel> createTask(@RequestBody CreateTasksRequestModel taskDetail) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		System.out.println();
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
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TeamsDto res = tasksServiceFriegnClient.createTeam(teamDetail);
		System.out.println("Create = " +res.toString());
		TeamsDto tempDto = tasksService.createNewTeam(res);
		CreateTeamsResponseModel model = mapper.map(tempDto, CreateTeamsResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(model);
	}

}
