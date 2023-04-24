package com.vehicleexpensetracker.entity;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "expenses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date")
    private LocalDate date;


    @Column(name = "notes")
    private String notes;

    // add any additional fields, methods, or annotations as needed

}
