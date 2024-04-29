package com.example.demo_exception.controller;

import com.example.demo_exception.exception.CustomException;
import com.example.demo_exception.exception.SecondCustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondRestController {
    @GetMapping("/bye")
    public String hello(){
        Integer error = 25/0 ;
        return "Bye bye world";
    }
    @GetMapping("/byebye")
    public  String byebye() {
        if (true) {
            throw new CustomException("oh là la !!!!");
        }
        return "Bye bye World !!!!";
    }

    @GetMapping("/hellothere")
    public  String helloThere() {
        if (true) {
            throw new SecondCustomException("General!!!!");
        }
        return "Bye bye World !!!!";
    }

}
