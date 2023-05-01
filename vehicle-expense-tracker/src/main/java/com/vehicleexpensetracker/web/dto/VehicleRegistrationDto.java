package com.vehicleexpensetracker.web.dto;

public class VehicleRegistrationDto {
	
	private String make;
	private String model;
	private Integer year;
	private Long userId;
	
	public VehicleRegistrationDto() {
		
	}

	
	public VehicleRegistrationDto(String make, String model, Integer year, Long userId) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.userId = userId;
	}


	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	

}
