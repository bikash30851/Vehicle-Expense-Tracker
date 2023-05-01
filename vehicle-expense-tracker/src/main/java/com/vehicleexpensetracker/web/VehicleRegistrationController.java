package com.vehicleexpensetracker.web;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vehicleexpensetracker.entity.User;
import com.vehicleexpensetracker.entity.Vehicle;
import com.vehicleexpensetracker.repository.VehicleRepository;
import com.vehicleexpensetracker.service.UserService;
import com.vehicleexpensetracker.service.VehicleService;

@Controller
public class VehicleRegistrationController {

	private VehicleRepository vehicleRepository;
	
	private UserService userService;
	
	

	public VehicleRegistrationController(VehicleRepository vehicleRepository, UserService userService) {
		super();
		this.vehicleRepository = vehicleRepository;
		this.userService = userService;
	}



	@PostMapping("/vehicles")
	public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {

		vehicleRepository.save(vehicle);
		return "redirect:/";
	}

}
