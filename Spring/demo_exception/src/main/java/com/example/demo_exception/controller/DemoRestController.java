package com.example.demo_exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    @GetMapping("/hello")
    public String hello(){
        Integer error = 25/0 ;
        return "hello world";
    }
    @ExceptionHandler(ArithmeticException.class)
   // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public  String handlerArithmeticException(ArithmeticException ex){
        return "problem of Maths " + ex.getMessage();
    }
}
