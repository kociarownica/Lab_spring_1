package com.example.app.service;

import com.example.app.controller.SpeedController;
import com.example.app.domain.Speed;
import com.example.app.domain.SpeedCalculations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private final Logger logger = LoggerFactory.getLogger(SpeedController.class);

    public SpeedCalculations calculate(Speed speed) {
        logger.info("Speed has been successfully calculated");
        return new SpeedCalculations(speed.getDistance() / speed.getTime());
    }
}