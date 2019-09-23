package com.example.task.service;

import com.example.task.shared.TasksDto;
import com.example.task.shared.TeamsDto;

public interface TasksService {
	
	public TasksDto createNewTask(TasksDto taskDetail);
	public TeamsDto createNewTeam(TeamsDto teamDetail);
	public TasksDto getTask(String taskName);
}
