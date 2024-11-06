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
    private final Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach thisCoach,
                          @Qualifier("cricketCoach") Coach thatCoach) {
        System.out.println("In constructor: " + this.getClass().getSimpleName());
        myCoach = thisCoach;
        anotherCoach = thatCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: Is my coach equal to another coach? " + String.valueOf(myCoach == anotherCoach).toUpperCase();
    }
}
