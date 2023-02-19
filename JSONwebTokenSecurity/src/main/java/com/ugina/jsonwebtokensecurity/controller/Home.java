package com.ugina.jsonwebtokensecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class Home {
    @GetMapping
    public String homePage(){
        return "This is home page";
    }
}
