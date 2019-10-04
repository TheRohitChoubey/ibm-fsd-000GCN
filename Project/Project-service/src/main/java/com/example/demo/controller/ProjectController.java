package com.example.demo.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ErrorClass;
import com.example.demo.entity.Project;
import com.example.demo.model.CreateProjectRequestModel;
import com.example.demo.model.CreateProjectResponseModel;
import com.example.demo.model.CreateTasksRequestModel;
import com.example.demo.model.CreateTasksResponseModel;
import com.example.demo.service.ProjectService;
import com.example.demo.shared.ProjectDto;

@RestController
public class ProjectController {
	@Autowired
	private ProjectService service;

	@RequestMapping("/projects/getallproject")
	public ResponseEntity<?> getAllproject() {
		
		List<?> projects = service.findAll();
		if(projects == null) {
			return ResponseEntity.ok(new ErrorClass("Data not Found !"));
		}
		return ResponseEntity.ok(projects);
	}

	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		
		Project project = service.findById(id);
		if(project == null) {
			return ResponseEntity.ok(new ErrorClass("Data not Found !"));
		}
		return ResponseEntity.ok(project);
	}
	

	@GetMapping("/findbyemail/{email}")
	public ResponseEntity<?> findByEmail(@PathVariable String email) {
		System.out.println(email);
		Project project = service.getByEmail(email);
		if(project == null) {
			return ResponseEntity.ok(new ErrorClass("Data not Found !"));
		}
		return ResponseEntity.ok(project);
	}

	@PostMapping("/projects")
	public ResponseEntity<?> create(@RequestBody ArrayList<CreateProjectRequestModel> pData)
			throws ParseException {
		// TODO Auto-generated method stub
		ModelMapper model = new ModelMapper();
		model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CreateProjectRequestModel projectreq = pData.get(0);
		ProjectDto pDto = model.map(projectreq, ProjectDto.class);
		ProjectDto tempDto = service.saveProject(pDto);
		
		CreateProjectResponseModel proRes = model.map(tempDto, CreateProjectResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(proRes);
	}
	
	@PostMapping("/project/updateproject")
	public ResponseEntity<?> updateProject(@RequestBody ArrayList<Project>  projectData)
			throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("Rohit");
		ModelMapper model = new ModelMapper();
		model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		//System.out.println(pData.get(0).toString());
		Project projectreq = (Project)projectData.get(0);
		System.out.println(projectreq.toString());
		ProjectDto tempDto = service.updateProject(projectreq);
		if(tempDto == null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorClass("Data not Found !"));
		}
		CreateProjectResponseModel proRes = model.map(tempDto, CreateProjectResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(proRes);
	}

	@GetMapping("/deleteproject/{id}")
	public ResponseEntity<?> deleteProject(@PathVariable("id") Long id) {
		service.deleteProject(id);
		return ResponseEntity.ok("deleted");
	}

	@PostMapping("/projects/tasks")
	public ResponseEntity<?> createTeam(@RequestBody ArrayList<CreateTasksRequestModel> taskDetail) {
		CreateTasksRequestModel taskmodel = taskDetail.get(0);
		CreateTasksResponseModel tmodel = service.createTask(taskmodel);
		
		if(tmodel.getTaskName().equals("Task Server Down"))
			return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorClass("Task Server Down") );
		return ResponseEntity.status(HttpStatus.CREATED).body(tmodel);
	}
	
	@GetMapping("/projects/getAllTasks")
	public ResponseEntity<?> getAllTasks() {
		List<?> tmodel = service.getAllTasks();
		if(tmodel == null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorClass("Task Server Down"));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(tmodel);
	}
}
