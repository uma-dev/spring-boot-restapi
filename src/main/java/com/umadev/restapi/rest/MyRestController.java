package com.umadev.restapi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyRestController {
    
    // Add code the  "/hello" endpoint    
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello from endpoint";
    }
    
}
