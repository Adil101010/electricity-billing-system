package com.adil.electricitybilling.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @Column(nullable = false)
    private boolean paid = false;

    private LocalDate billDate;

    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "consumer_id")
    @com.fasterxml.jackson.annotation.JsonBackReference
    private Consumer consumer;
}
