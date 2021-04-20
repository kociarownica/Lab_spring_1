package com.example.app.service;

import com.example.app.domain.Speed;
import com.example.app.domain.SpeedCalculations;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public SpeedCalculations calculate(Speed speed) {
        return new SpeedCalculations(speed.getDistance() / speed.getTime());
    }
}