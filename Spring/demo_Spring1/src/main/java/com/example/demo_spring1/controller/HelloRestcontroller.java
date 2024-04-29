package com.example.demo_spring1.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/home")
public class HelloRestcontroller {
    //par défault sur la racine si ne montrer path préciser
    @GetMapping
    //@RequestMapping(method = RequestMethod.GET)
    public String sayHello(){
        System.out.println("hello");
        return "Hello World !!!!!!!";
    }
    @GetMapping(value ="persons" )
    public List<String> sayCoucouJson(){
        return  List.of("John Dupont","Toto tata", "Tata titi");

    }
}
