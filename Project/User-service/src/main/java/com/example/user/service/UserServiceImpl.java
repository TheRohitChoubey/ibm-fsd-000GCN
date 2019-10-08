package com.example.user.service;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.omg.CORBA.UserException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.user.data.User;
import com.example.user.model.CreateTeamsRequestModel;
import com.example.user.model.PRojectIdTaskIDModel;
import com.example.user.model.ProjectIdRequestModel;
import com.example.user.repository.UserRepository;
import com.example.user.shared.UserDto;

@Service
public class UserServiceImpl implements UserService {
	private static final String QUEUE="projectDetail-queue";
	@Autowired
	private Environment env;
	private UserRepository userRepository;
	
	private BCryptPasswordEncoder bcrypt;
	@Autowired
	private JavaMailSender mailSender;

	
	@Autowired
	public UserServiceImpl(Environment env, UserRepository userRepository, BCryptPasswordEncoder bcrypt,
			JavaMailSender mailSender) {
		super();
		this.env = env;
		this.userRepository = userRepository;
		this.bcrypt = bcrypt;
		this.mailSender = mailSender;
	}

	@Override
	public UserDto createNewUser(UserDto userDetail) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		userDetail.setPassword(bcrypt.encode(userDetail.getPassword()));
		User userEntity = mapper.map(userDetail, User.class);
		userRepository.save(userEntity);
		
		try {
			this.sendMail(userEntity.getEmail(), "User Registered ", this.getbody(userEntity));
		} catch (MessagingException e) {
			UserDto uDto = mapper.map(userEntity, UserDto.class);
			return uDto;
		}

		UserDto uDto = mapper.map(userEntity, UserDto.class);
		return uDto;
	}

	@Override
	public UserDto getUserByEmail(String email) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		User userEntity = userRepository.findByEmail(email);
		UserDto uDto = mapper.map(userEntity, UserDto.class);
		return uDto;
	}


	@Override
	public List<User> findByusername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public List<User> findByavailability(String availability) {
		// TODO Auto-generated method stub
		return userRepository.findByAvailability(availability);
	}

	@Override
	public User findEmailAndPassword(String email, String password) {
		User user = userRepository.findByEmail(email);
		if(user == null) {
			return user;
		}
		boolean check = bcrypt.matches(password, user.getPassword());
		if(check == false) {
			return null;
		}
		return user;
	}

	@Override
	public List<User> getByRole(String role) {
		return userRepository.findByUserTypeAndAvailability(role, "yes");
	}

	public void sendMail(String to, String subject, String body) throws MessagingException {

		MimeMessage mail = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail, true);

		helper.setTo(to);
		helper.setSubject(subject);
		helper.setFrom("ibmtectraining007@gmail.com");
		mail.setContent(body, "text/html");

		mailSender.send(mail);
	}

	public String getbody(User user) {

		return "<!DOCTYPE html>\n" + 
				"<html xmlns:th=\"http://www.thymeleaf.org\">\n" + 
				"<head>\n" + 
				"<meta charset=\"ISO-8859-1\">\n" + 
				"<title>Sign-Form</title>\n" + 
				"<!-- Latest compiled and minified CSS -->\n" + 
				"<link rel=\"stylesheet\"\n" + 
				"	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n" + 
				"\n" + 
				"<!-- jQuery library -->\n" + 
				"<script\n" + 
				"	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" + 
				"\n" + 
				"<!-- Popper JS -->\n" + 
				"<script\n" + 
				"	src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n" + 
				"\n" + 
				"<!-- Latest compiled JavaScript -->\n" + 
				"<script\n" + 
				"	src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n" + 
				"	<style>\n" + 
				"	h2{\n" + 
				"	color: green;\n" + 
				"	}\n" + 
				"	</style>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"\n" + 
				"	<div class=\"container\">\n" + 
				"		<div class=\"row\">\n" + 
				"			<h2>You have been added into portal</h2>\n" + 
				"		</div>\n" + 
				"		<br>\n" + 
				"		<br>\n" + 
				"		<hr>\n" + 
				"		<div class=\"row\">\n" + 
				"	<img src=\"https://contenthub-static.grammarly.com/blog/wp-content/uploads/2019/04/thumbnail-7075f02d50b2e1b87acaac02e0592003-760x400.jpeg\">\n" + 
				"		</div>\n" + 
				"		<br> <br>\n" + 
				"		<hr>\n" + 
				"		<table class=\"table table-light\">\n" + 
				"			<thead class=\" table  table-dark\">\n" + 
				"				<tr>\n" + 
				"					<th>User Name</th>\n" + 
				"					<th>Email</th>\n" + 
				"					<th>Password</th>\n" + 
				"					<th>Location</th>\n" + 
				"					<th>User type</th>\n" + 
				"				</tr>\n" + 
				"			</thead>	\n" + 
				"			<tbody class=\"table-light\">\n" + 
				"			<tr>\n" + 
				"			<td>"+user.getUsername()+"</td>\n" + 
				"			<td>"+user.getEmail()+"</td>\n" + 
				"			<td>"+user.getPassword()+"</td>\n" + 
				"			<td>"+user.getUlocation()+"</td>\n" + 
				"			<td>"+user.getUserType()+"</td>\n" + 
				"			\n" + 
				"			</tr>\n" + 
				"		</tbody>\n" + 
				"			\n" + 
				"	</table>\n" + 
				"	</div>\n" + 
				"</body>\n" + 
				"</html> ";
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findByUserTypeOrUserType("manager", "user");
	}

	@Override
	public void deleteUser(String email) {
		User userDetails = userRepository.findByEmail(email);
		userRepository.delete(userDetails);
	}

	@Override
	//@RabbitListener(queues = QUEUE)
	public void updateAssignedProjectId(ProjectIdRequestModel projectDetail) {
		System.out.println(projectDetail.toString());
		User user = userRepository.findByProjectidAndUserType(projectDetail.getProjectId(),"manager");
		
		if(user != null) {
			System.out.println(user.toString());
			user.setAvailability("yes");
			user.setProjectid(null);
			userRepository.save(user);
		}
		User userDetail = userRepository.findByEmail(projectDetail.getPmanagerEmail());
		if(userDetail == null) {
			System.out.println("Null");
		}
		System.out.println(userDetail.toString());
		userDetail.setAvailability("no");
		userDetail.setUlocation(projectDetail.getPlocation());
		userDetail.setProjectid(projectDetail.getProjectId());
		userRepository.save(userDetail);
		try {
			this.sendMail(userDetail.getEmail(), "Project Manager Assigned ", this.getProjectManagerBody(userDetail,projectDetail));
		} catch (MessagingException e) {
			
		}
		
	}
	
	public String getProjectManagerBody(User user,ProjectIdRequestModel projectDetail) {

		return "<!DOCTYPE html>\n" + 
				"<html xmlns:th=\"http://www.thymeleaf.org\">\n" + 
				"<head>\n" + 
				"<meta charset=\"ISO-8859-1\">\n" + 
				"<title>Sign-Form</title>\n" + 
				"<!-- Latest compiled and minified CSS -->\n" + 
				"<link rel=\"stylesheet\"\n" + 
				"	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n" + 
				"\n" + 
				"<!-- jQuery library -->\n" + 
				"<script\n" + 
				"	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" + 
				"\n" + 
				"<!-- Popper JS -->\n" + 
				"<script\n" + 
				"	src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n" + 
				"\n" + 
				"<!-- Latest compiled JavaScript -->\n" + 
				"<script\n" + 
				"	src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n" + 
				"	<style>\n" + 
				"	h2{\n" + 
				"	color: green;\n" + 
				"	}\n" + 
				"	</style>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"\n" + 
				"	<div class=\"container\">\n" + 
				"		<div class=\"row\">\n" + 
				"			<h2>You have been added into portal</h2>\n" + 
				"		</div>\n" + 
				"		<br>\n" + 
				"		<br>\n" + 
				"		<hr>\n" + 
				"		<div class=\"row\">\n" + 
				"	<img src=\"https://contenthub-static.grammarly.com/blog/wp-content/uploads/2019/04/thumbnail-7075f02d50b2e1b87acaac02e0592003-760x400.jpeg\">\n" + 
				"		</div>\n" + 
				"		<br> <br>\n" + 
				"		<hr>\n" + 
				"		<table class=\"table table-light\">\n" + 
				"			<thead class=\" table  table-dark\">\n" + 
				"				<tr>\n" + 
				"					<th>User Name</th>\n" + 
				"					<th>Email</th>\n" + 
				"					<th>Project Id</th>\n" + 
				"					<th>Project Location</th>\n" + 
				"					<th>User type</th>\n" + 
				"				</tr>\n" + 
				"			</thead>	\n" + 
				"			<tbody class=\"table-light\">\n" + 
				"			<tr>\n" + 
				"			<td>"+user.getUsername()+"</td>\n" + 
				"			<td>"+user.getEmail()+"</td>\n" + 
				"			<td>"+projectDetail.getProjectId()+"</td>\n" + 
				"			<td>"+projectDetail.getPlocation()+"</td>\n" + 
				"			<td>"+user.getUserType()+"</td>\n" + 
				"			\n" + 
				"			</tr>\n" + 
				"		</tbody>\n" + 
				"			\n" + 
				"	</table>\n" + 
				"	</div>\n" + 
				"</body>\n" + 
				"</html> ";
	}

	@Override
	public boolean updateDeletedProjectId(ProjectIdRequestModel projectDetail) {
		List<User> userDetail = userRepository.findByProjectid(projectDetail.getProjectId());
		
		for(int i=0; i<userDetail.size(); i++) {
			userDetail.get(i).setAvailability("yes");
			userDetail.get(i).setUlocation(projectDetail.getPlocation());
			userDetail.get(i).setProjectid(null);
			userDetail.get(i).setTaskId(null);
			userRepository.save(userDetail.get(i));
		}
		return true;
	}

	@Override
	public void updateDeletedTaskId(Long taskId) {
		List<User> userDetail = userRepository.findByTaskId(taskId);
		for(int i=0; i<userDetail.size(); i++) {
			userDetail.get(i).setTaskId(null);
			userDetail.get(i).setAvailability("yes");
		}
		
		userRepository.saveAll(userDetail);
	}

	@Override
	public void updateAssignedtaskId(CreateTeamsRequestModel teamDetail) {
		User userDetail = userRepository.findByEmail(teamDetail.getUemail());
		userDetail.setAvailability("no");
		userDetail.setuAssigndate(teamDetail.getUassigndate());
		userDetail.setTaskId(teamDetail.getTaskId());
		userDetail.setProjectid(teamDetail.getProjectId());
		userRepository.save(userDetail);
		
	}

	@Override
	public List<?> getAllTeam(Long taskId) {
		List<?> teams = userRepository.findByTaskId(taskId);
		return teams;
	}

	@Override
	public boolean deleteTeamMember(String email) {
		User userDetail = userRepository.findByEmail(email);
		userDetail.setAvailability("yes");
		userDetail.setTaskId(null);
		userDetail.setuStatus(null);
		userRepository.save(userDetail);
		return true;
	}
	
	@Override
	public List<User> getUserFromPojectIdTaskId(PRojectIdTaskIDModel teamDetail) {
		List<User> user = userRepository.findAllByProjectidAndTaskIdIn(teamDetail.getProjectId(),teamDetail.getTaskIDs());
		System.out.println(user.toString());
		return user;
	}

	@Override
	public boolean getByStatus(String email, String status) {
		User user = userRepository.findByEmail(email);
		user.setuStatus(status);
		userRepository.save(user);
		return true;
	}

	@Override
	public boolean getByProjectId(Long projectId) {
		userRepository.findByProjectid(projectId);
		return false;
	}
	

	
}
