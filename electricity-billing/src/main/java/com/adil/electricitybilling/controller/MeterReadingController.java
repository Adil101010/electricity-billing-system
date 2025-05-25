package com.adil.electricitybilling.controller;

import com.adil.electricitybilling.model.MeterReading;
import com.adil.electricitybilling.repository.MeterReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readings")
public class MeterReadingController {

    @Autowired
    private MeterReadingRepository meterReadingRepository;

    @GetMapping
    public List<MeterReading> getAllReadings() {
        return meterReadingRepository.findAll();
    }

    @PostMapping
    public MeterReading addReading(@RequestBody MeterReading reading) {
        return meterReadingRepository.save(reading);
    }
}
