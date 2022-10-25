package com.mastermicroservices.microservices.limitsservice.controller;

import com.mastermicroservices.microservices.limitsservice.bean.Limits;
import com.mastermicroservices.microservices.limitsservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    private final Configuration configuration;

    @Autowired
    public LimitsController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping(path = "/limits")
    public Limits retrieveLimits() {

        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }
}
