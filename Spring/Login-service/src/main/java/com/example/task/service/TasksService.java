package com.example.task.service;

import com.example.task.shared.TasksDto;

public interface TasksService {
	
	public TasksDto createNewTask(TasksDto taskDetail);
	public TasksDto getTask(String taskName);
}
