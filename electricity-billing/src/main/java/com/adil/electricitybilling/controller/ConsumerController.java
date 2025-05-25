package com.adil.electricitybilling.controller;

import com.adil.electricitybilling.model.Consumer;
import com.adil.electricitybilling.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumers")
public class ConsumerController {

    @Autowired
    private ConsumerRepository consumerRepository;

    @PostMapping
    public Consumer createConsumer(@RequestBody Consumer consumer) {
        return consumerRepository.save(consumer);
    }

    @GetMapping
    public List<Consumer> getAllConsumers() {
        return consumerRepository.findAll();

    }


}

