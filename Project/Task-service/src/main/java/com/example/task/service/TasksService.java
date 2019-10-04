package com.example.task.service;

import java.util.List;

import com.example.task.data.Tasks;
import com.example.task.model.CreateTeamsRequestModel;
import com.example.task.shared.TasksDto;

public interface TasksService {
	
	public TasksDto createNewTask(TasksDto taskDetail);
	public TasksDto getTask(Long taskId);
	public List<?> getAllTeam(Long taskId);
	public boolean createTeam(CreateTeamsRequestModel teamDetail);
	public boolean deleteTask(Long id);
	public boolean deleteTeamMember(String email);
	public List<Tasks> getAllTasks(Long projectId);
	public boolean updateTask(TasksDto tDto);
}
