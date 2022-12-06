package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/get")
    public String getTest() {
        return "spring security";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return " admin spring security";
    }

}
