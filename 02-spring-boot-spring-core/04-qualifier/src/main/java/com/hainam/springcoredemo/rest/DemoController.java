package com.hainam.springcoredemo.rest;

import com.hainam.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private constant for dependency
    private final Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach coach) {
        myCoach = coach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
