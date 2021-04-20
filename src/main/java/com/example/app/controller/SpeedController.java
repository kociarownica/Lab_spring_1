package com.example.app.controller;

import com.example.app.domain.Speed;
import com.example.app.domain.SpeedCalculations;
import com.example.app.service.CalculatorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SpeedController {

    private CalculatorService calculatorService;

    @GetMapping("/")
    public SpeedCalculations getParams(@RequestParam ("d") double distance, @RequestParam ("t") double time) {
        Speed speed = new Speed(distance, time);
        return calculatorService.calculate(speed);
    }
}
