package com.vehicleexpensetracker.service;

import java.util.Arrays;

import com.vehicleexpensetracker.entity.Role;
import com.vehicleexpensetracker.entity.User;
import com.vehicleexpensetracker.entity.Vehicle;
import com.vehicleexpensetracker.repository.UserRepository;
import com.vehicleexpensetracker.repository.VehicleRepository;
import com.vehicleexpensetracker.web.dto.UserRegistrationDto;
import com.vehicleexpensetracker.web.dto.VehicleRegistrationDto;

public class VehicleService {

	private UserRepository userRepository;
	
	private VehicleRepository vehicleRepository;


	public VehicleService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public Vehicle save(VehicleRegistrationDto vehicleRegistrationDto, User user) {
		Vehicle vehicle = new Vehicle(vehicleRegistrationDto.getMake(), 
										vehicleRegistrationDto.getModel(),
										vehicleRegistrationDto.getYear(), 
										user);
		return vehicleRepository.save(vehicle);
	}

}
