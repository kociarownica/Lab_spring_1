package com.example.app.service;

import com.example.app.controller.SpeedController;
import lombok.Data;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Getter
@Service
public class AppealsCounter implements Runnable{

    private Logger logger = LoggerFactory.getLogger(SpeedController.class);
    private  int counter;

    public AppealsCounter() {
        this.counter = 0;
    }

    synchronized public void addCounter (){
        this.counter++;
        logger.info("Number of requests: " + counter);
    }

    @Override
    public void run() {
        addCounter();
    }

}
