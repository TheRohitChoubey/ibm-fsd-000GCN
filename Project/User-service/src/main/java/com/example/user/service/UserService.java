package com.example.user.service;

import java.util.List;
import com.example.user.data.User;
import com.example.user.model.CreateTeamsRequestModel;
import com.example.user.model.PRojectIdTaskIDModel;
import com.example.user.model.ProjectIdRequestModel;
import com.example.user.shared.UserDto;

public interface UserService {
	
	public UserDto createNewUser(UserDto userDetail);
	public UserDto getUserByEmail(String email);
	public List<User> findByusername(String username);
	public User findById(Long id);
	public void deleteUser(Long id);
	public List<User> findByavailability(String availability);
	public User findEmailAndPassword(String email,String password);
	public List<User> getByRole(String urole);
	public List<User> getAllUser();
	public void deleteUser(String email);
	public boolean updateAssignedProjectId(ProjectIdRequestModel projectDetail);
	public boolean updateDeletedProjectId(ProjectIdRequestModel projectDetail);
	public void updateAssignedtaskId(CreateTeamsRequestModel teamDetail);
	public void updateDeletedTaskId(Long taskId);
	public List<?> getAllTeam(Long taskId);
	public boolean deleteTeamMember(String email);
	public List<User> getUserFromPojectIdTaskId(PRojectIdTaskIDModel teamDetail);
	public boolean getByStatus(String email,String status);
	public boolean getByProjectId(Long projectId);
}
