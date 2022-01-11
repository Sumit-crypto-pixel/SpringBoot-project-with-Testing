package com.dailycodebuffer.springboot.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // It is advanced to JPA, so JPA is not used. It will know it is controller
public class HelloController {
    @GetMapping("/")
    public String HelloWorld(){
        return "Welcome to localhost";
    }
}
