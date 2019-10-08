package com.example.user.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.user.data.ErrorClass;
import com.example.user.data.Login;
import com.example.user.data.User;
import com.example.user.model.CreateTeamsRequestModel;
import com.example.user.model.CreateUserRequestModel;
import com.example.user.model.CreateUserResponseModel;
import com.example.user.model.PRojectIdTaskIDModel;
import com.example.user.model.ProjectIdRequestModel;
import com.example.user.service.UserService;
import com.example.user.shared.UserDto;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<?> createTask(@RequestBody ArrayList<CreateUserRequestModel> user) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CreateUserRequestModel userDetail = user.get(0);
		UserDto uDto = mapper.map(userDetail, UserDto.class);

		UserDto userDto = userService.createNewUser(uDto);
		if(userDto == null) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Email or password did not match");
		}
		CreateUserResponseModel model = mapper.map(userDto, CreateUserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(model);

	}
	
	@GetMapping("/user/{email}")
	public ResponseEntity<?> getByEmail(@PathVariable("email") String email) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		System.out.println("User Email = "+email);
		UserDto userDto = userService.getUserByEmail(email);
		CreateUserResponseModel model = mapper.map(userDto, CreateUserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(model);

	}
	
	@PostMapping("/user/login")
	public ResponseEntity<?> userbyEmail(@RequestBody ArrayList<Login> loginData) {
		Login userDetails = loginData.get(0);
		User user = userService.findEmailAndPassword(userDetails.getEmail(),userDetails.getPassword());
		if (user == null)
			return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorClass("Email or password is wrong"));
		else
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@GetMapping("/user/getalluser")
	public ResponseEntity<List<User>> getAlluser() {

		return ResponseEntity.ok(userService.getAllUser());
	}

	@PostMapping("/user/findbyid")
	public ResponseEntity<User> findById(@RequestParam("id") Long id) {

		return ResponseEntity.ok(userService.findById(id));
	}

	@GetMapping("/user/findbyname/{username}")
	public ResponseEntity<List<User>> userbyName(@PathVariable("username") String username) {

		return ResponseEntity.ok(userService.findByusername(username));
	}

	

	@GetMapping("/user/findbyavailability/{availability}")
	public ResponseEntity<List<User>> userbyAvailability(@PathVariable("availability") String availability) {

		return ResponseEntity.ok(userService.findByavailability(availability));
	}
	@GetMapping("/user/role/{urole}")
	public ResponseEntity<List<User>> userbyRole(@PathVariable("urole") String urole) {
		return ResponseEntity.ok(userService.getByRole(urole));
	}
	
	
	@GetMapping("/user/getAllUser")
	public ResponseEntity<?> getAllUser() {
		return ResponseEntity.ok(userService.getAllUser());
	}
	
	@GetMapping("/user/delete/{email}")
	public ResponseEntity<?> deleteUser(@PathVariable("email") String email) {
		userService.deleteUser(email);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorClass("Deleted"));
	}
	
	@PostMapping("/projectAssignedUserDetail")
	public ResponseEntity<?> projectAssignedUserDetail(@RequestBody ProjectIdRequestModel projectDetail){
		userService.updateAssignedProjectId(projectDetail);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorClass("Updated"));
	}
	
	@PostMapping("/projectDeletedUserDetail")
	public ResponseEntity<?> projectDeletedUserDetail(@RequestBody ProjectIdRequestModel projectDetail){
		userService.updateDeletedProjectId(projectDetail);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorClass("Deleted"));
	}
	
	@PostMapping("/taskAssignedUserDetail")
	public ResponseEntity<?> taskAssignedUserDetail(@RequestBody CreateTeamsRequestModel teamDetail){
		userService.updateAssignedtaskId(teamDetail);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorClass("Updated"));
	}

	@PostMapping("/taskDeletedUserDetail")
	public ResponseEntity<?> taskDeletedUserDetail(@RequestBody Long taskId){
		userService.updateDeletedTaskId(taskId);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ErrorClass("Deleted"));
	}
	
	@GetMapping("/getAllTeam/{id}")
	public ResponseEntity<?> getAllTeam(@PathVariable("id") Long taskId){
		List<?> teams =userService.getAllTeam(taskId);
		System.out.println(teams);
		return ResponseEntity.status(HttpStatus.CREATED).body(teams);
	}
	
	@GetMapping("/deleteTeamMember/{email}")
	public boolean deleteTeamMember(@PathVariable String email) {
		boolean teamMember = userService.deleteTeamMember(email);
		return true;
	}
	
	@PostMapping("/findUserProjectTask")
	public ResponseEntity<?> getUserFromPojectIdTaskId(@RequestBody PRojectIdTaskIDModel details) {
		System.out.println(details.toString());
		List<User> tmodel=userService.getUserFromPojectIdTaskId(details);
		return ResponseEntity.status(HttpStatus.CREATED).body(tmodel);
	}
	@GetMapping("/user/{email}/{status}")
	public ResponseEntity<?> getByStatus(@PathVariable("email") String email,@PathVariable("status") String status) {
		System.out.println("User Email = "+email);
		boolean userDto = userService.getByStatus(email,status);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDto);

	}
	
	@GetMapping("/findByProjectId/{id}")
	public ResponseEntity<?> getByProjectId(@PathVariable("id") Long projectId) {
		boolean userDto = userService.getByProjectId(projectId);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDto);

	}
	
	
	
}
