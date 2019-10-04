package com.example.task.service;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.task.data.Tasks;
import com.example.task.freignInterface.UserFeignClient;
import com.example.task.model.CreateTeamsRequestModel;
import com.example.task.repository.TasksRepository;
import com.example.task.shared.TasksDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class TasksServiceImpl implements TasksService {
	@Autowired
	private Environment env;
	private TasksRepository tasksRepository;
	@Autowired
	private UserFeignClient userFeignClient;

	@Autowired
	public TasksServiceImpl(Environment env, TasksRepository tasksRepository,UserFeignClient userFeignClient) {
		super();
		this.env = env;
		this.tasksRepository = tasksRepository;
		this.userFeignClient = userFeignClient;
	}

	@Override
	public TasksDto createNewTask(TasksDto taskDetail) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		Tasks tasksEntity = mapper.map(taskDetail, Tasks.class);
		tasksRepository.save(tasksEntity);
		TasksDto uDto = mapper.map(tasksEntity, TasksDto.class);
		return uDto;
	}

	@Override
	public TasksDto getTask(Long taskId) {
		Tasks taskEntity = tasksRepository.findById(taskId).get();
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TasksDto tDto = mapper.map(taskEntity, TasksDto.class);
		return tDto;
	}
	
	@Override
	public boolean createTeam(CreateTeamsRequestModel teamDetail) {
		userFeignClient.taskAssignedUserDetail(teamDetail);
		return true;
	}
	
	
	@Override
	public boolean deleteTask(Long id) {
		Tasks task = tasksRepository.findById(id).get();
		userFeignClient.taskDeletedUserDetail(task.getTaskId());
		tasksRepository.deleteById(id);
		return true;
	}

	@Override
	public List<?> getAllTeam(Long taskId) {
		List<?> users = userFeignClient.getAllTeam(taskId);
		return users;
	}

	@Override
	public boolean deleteTeamMember(String email) {
		boolean tmember = userFeignClient.deleteTeamMember(email);
		return true;
	}

	@Override
	public List<Tasks> getAllTasks(Long projectId) {
		return tasksRepository.findByProjectId(projectId);
	}

	@Override
	public boolean updateTask(TasksDto tDto) {
		Tasks tasksEntity = tasksRepository.findByTaskName(tDto.getTaskName());
		tasksEntity.setEndDate(tDto.getEndDate());
		tasksEntity.setStartDate(tDto.getStartDate());
		tasksEntity.setStatus(tDto.getStatus());
		tasksRepository.save(tasksEntity);
		return true;
	}

}
