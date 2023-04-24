package com.vehicleexpensetracker.service;

import com.vehicleexpensetracker.entity.User;
import com.vehicleexpensetracker.web.dto.UserRegistrationDto;

public interface UserService {
	User save(UserRegistrationDto registrationDto);

}
