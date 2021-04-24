package com.example.app.service;

import com.example.app.domain.Speed;
import com.example.app.domain.SpeedCalculations;

public interface CalculatorService {
    public SpeedCalculations calculate(Speed speed) throws  InterruptedException;
}
