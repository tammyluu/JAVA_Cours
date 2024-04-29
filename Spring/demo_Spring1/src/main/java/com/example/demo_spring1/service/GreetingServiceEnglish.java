package com.example.demo_spring1.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("greetings")
//@Primary
public class GreetingServiceEnglish implements GreetingService {


    @Override
    public String sayHello() {
        return "Hello everyone !!!";
    }
}
