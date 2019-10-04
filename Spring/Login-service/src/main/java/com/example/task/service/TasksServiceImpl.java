package com.example.task.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.task.data.Login;
import com.example.task.repository.TasksRepository;
import com.example.task.shared.TasksDto;


@Service
public class TasksServiceImpl implements TasksService {
	@Autowired
	private Environment env;
	private TasksRepository tasksRepository;

	@Autowired
	public TasksServiceImpl(Environment env, TasksRepository tasksRepository) {
		super();
		this.env = env;
		this.tasksRepository = tasksRepository;
	}

	@Override
	public TasksDto createNewTask(TasksDto taskDetail) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		Login tasksEntity = mapper.map(taskDetail, Login.class);
		tasksRepository.save(tasksEntity);
		TasksDto uDto = mapper.map(tasksEntity, TasksDto.class);
		return uDto;
	}

	@Override
	public TasksDto getTask(String taskName) {
		Login taskEntity = tasksRepository.findByTaskName(taskName);
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TasksDto tDto = mapper.map(taskEntity, TasksDto.class);
		return tDto;
	}

}
