package com.example.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cache.annotation.Cacheable;

@Data
@AllArgsConstructor
@Cacheable("speedCalculations")
public class SpeedCalculations {
    private double speed;
}