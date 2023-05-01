package com.vehicleexpensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicleexpensetracker.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	

}
