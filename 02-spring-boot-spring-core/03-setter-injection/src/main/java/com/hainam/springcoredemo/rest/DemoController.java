package com.hainam.springcoredemo.rest;

import com.hainam.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private constant for dependency
    private Coach myCoach;

    @Autowired
    public void setMyCoach(Coach coach) {
        myCoach = coach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
