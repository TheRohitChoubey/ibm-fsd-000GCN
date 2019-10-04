package com.example.task.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.example.task.data.ErrorClass;
import com.example.task.data.Tasks;
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


	@PostMapping("/tasks")
	public ResponseEntity<?> createTask(@RequestBody CreateTasksRequestModel taskDetail) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TasksDto tDto = mapper.map(taskDetail, TasksDto.class);

		TasksDto tempDto = tasksService.createNewTask(tDto);
		
		if(tempDto == null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorClass("Data not Found !"));
		}
		
		CreateTasksResponseModel model = mapper.map(tempDto, CreateTasksResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(model);

	}
	
	@PostMapping("/updateTask")
	public ResponseEntity<?> updateTask(@RequestBody ArrayList<CreateTasksRequestModel> task) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CreateTasksRequestModel taskDetail = task.get(0);
		TasksDto tDto = mapper.map(taskDetail, TasksDto.class);
		boolean check =tasksService.updateTask(tDto);
		if(check == false) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorClass("Not Updated"));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorClass("Updated"));

	}
	
	@GetMapping("/taskById/{taskId}")
	public ResponseEntity<?> getTaskByName(@PathVariable Long taskId) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		TasksDto tempDto = tasksService.getTask(taskId);
		
		if(tempDto == null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorClass("Data not Found !"));
		}

		CreateTasksResponseModel model = mapper.map(tempDto, CreateTasksResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(model);
	}
	
	@GetMapping("/deleteTask/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable("id") Long id) {
		boolean check =tasksService.deleteTask(id);
		
		if(check == false) {
			return ResponseEntity.ok("Error in deletion");
		}
		return ResponseEntity.ok("deleted");
	}
	
	@GetMapping("/getAllTasks/{projectId}")
	public ResponseEntity<?> getAllTasks(@PathVariable Long projectId) {
		List<Tasks> tmodel = tasksService.getAllTasks(projectId);
		if(tmodel == null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorClass("Data not Found !"));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(tmodel);
	}

	@PostMapping("/tasks/team")
	public ResponseEntity<?> createTeam(@RequestBody ArrayList<CreateTeamsRequestModel> team) {
		System.out.println(team.toString());
		CreateTeamsRequestModel teamDetail = team.get(0);
		boolean check =tasksService.createTeam(teamDetail);
		if(check == false ) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorClass("Not Created"));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorClass("Created"));
	}

	@GetMapping("/tasks/teams/{id}")
	public ResponseEntity<?> getAllTeams(@PathVariable Long taskId) {
		List<?> tmodel = tasksService.getAllTeam(taskId);
		if(tmodel == null) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Data not Found !");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(tmodel);
	}
	
	@GetMapping("/tasks/team/{email}")
	public ResponseEntity<?> deleteTeamMember(@PathVariable String email) {
		boolean tmodel = tasksService.deleteTeamMember(email);
		if(tmodel == false) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Data not Found !");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(tmodel);
	}
	
	
	
}
