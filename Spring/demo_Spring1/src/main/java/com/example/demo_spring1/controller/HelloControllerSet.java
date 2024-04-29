package com.example.demo_spring1.controller;

import com.example.demo_spring1.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloControllerSet {

    // Injection, de dependence

    private  final GreetingService greetingService;
    //@Autowired
    // si il y a qu'un seul pas besoins
    // mettre la page on veut afficher greetind/ salutations,.... si on ne veut pas d'utiliser @Primary
    public HelloControllerSet(@Qualifier("salutations") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @RequestMapping(value = "/hello-set")
    public String sayHello(){
        System.out.println(greetingService.sayHello());
        return "home";
    }
}
