package com.adil.electricitybilling.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeterReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate readingDate;

    private int unitsConsumed;

    @ManyToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;
}
