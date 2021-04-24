package com.example.app.service;

import com.example.app.controller.SpeedController;
import com.example.app.domain.Speed;
import com.example.app.domain.SpeedCalculations;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@AllArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    private final Logger logger = LoggerFactory.getLogger(SpeedController.class);
    private final AppealsCounter appealsCounter;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public SpeedCalculations calculate(Speed speed) throws InterruptedException {
        executorService.submit(appealsCounter);
        logger.info("Speed has been successfully calculated");
        return new SpeedCalculations(speed.getDistance() / speed.getTime());
    }
}