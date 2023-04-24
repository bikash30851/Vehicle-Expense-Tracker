package com.vehicleexpensetracker.service;

import org.springframework.stereotype.Service;

import com.vehicleexpensetracker.entity.User;
import com.vehicleexpensetracker.repository.UserRepository;
import com.vehicleexpensetracker.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	
	public User save(UserRegistrationDto userRegistrationDto) {
		
		User user = new User(userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
				userRegistrationDto.getEmail(), userRegistrationDto.getPassword());
		return user;
				
		
	}
	
	

}
