package com.example.demo_spring1.service;

import org.springframework.stereotype.Service;

@Service("salutations")
public class GreetingServiceFrench implements GreetingService{

    @Override
    public String sayHello() {
        return "Bonjour à tous !!!";
    }
}
