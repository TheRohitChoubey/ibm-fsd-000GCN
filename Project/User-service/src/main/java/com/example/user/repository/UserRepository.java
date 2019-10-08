package com.example.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user.data.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
	List<User> findByUsername(String username);

	List<User> findByAvailability(String availability);

	User findByEmailAndPassword(String email, String password);

	List<User> findByUserTypeAndAvailability(String role,String availability);
	
	List<User> findByTaskId(Long taskId);
	
	List<User> findByUserType(String role);
	
	List<User> findAllByProjectidAndTaskIdIn(Long projectId,List<Long> taskId);
	
	List<User> findByProjectid(Long projectId);
	
	List<User> findByUserTypeOrUserType(String role1,String role2);
	
	User findByProjectidAndUserType(Long id, String role);
}
