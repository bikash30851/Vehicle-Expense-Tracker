package com.vehicleexpensetracker.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.vehicleexpensetracker.entity.User;
import com.vehicleexpensetracker.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);

}
