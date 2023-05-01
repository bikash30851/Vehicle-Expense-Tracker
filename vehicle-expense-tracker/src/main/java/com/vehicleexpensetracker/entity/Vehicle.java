package com.vehicleexpensetracker.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Integer year;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

	public Vehicle(String make, String model, Integer year, User user) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.user = user;
	}
    
    

}
