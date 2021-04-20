package com.example.app.controller;

import com.example.app.domain.Speed;
import com.example.app.domain.SpeedCalculations;
import com.example.app.service.CalculatorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@RestController
@AllArgsConstructor
@Validated
public class SpeedController {

    private CalculatorService calculatorService;
    private final Logger logger = LoggerFactory.getLogger(SpeedController.class);

    @GetMapping("/")
    public SpeedCalculations getParams(@RequestParam ("d")
                                       @Min(value = 1, message = "Distance should be more than 1")
                                       double distance,
                                       @RequestParam ("t")
                                       @Min(value = 1, message = "Time should be more than 1")
                                       double time) throws ConstraintViolationException{
        Speed speed = new Speed(distance, time);
        return calculatorService.calculate(speed);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        logger.warn(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
