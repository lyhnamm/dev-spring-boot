package com.hainam.springboot.demo.myfirstapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/doSomething")
    public String doSomething() {
        return "Run 5 kilometers everyday";
    }
}
