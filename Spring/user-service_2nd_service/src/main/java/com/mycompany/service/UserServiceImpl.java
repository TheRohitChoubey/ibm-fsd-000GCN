package com.mycompany.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.data.UserEntity;
import com.mycompany.data.UserRepository;
import com.mycompany.shared.UserDto;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private Environment env;
	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(Environment env, UserRepository userRepository) {
		super();
		this.env = env;
		this.userRepository = userRepository;
	}

	@Override
	public UserDto findbyEmail(UserDto userDetail) {
		// TODO Auto-generated method stub
		
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserEntity userEntity=userRepository.findByEmail(userDetail.getEmail());
		System.out.println(userEntity.toString());
		UserDto uDto=mapper.map(userEntity, UserDto.class);
		
		return uDto;
	}



}
