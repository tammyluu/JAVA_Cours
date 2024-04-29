package com.example.demo_exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class DemoController {
    @GetMapping("/salut")
    public  String handleError(Model model){
        Integer error = 12/0;
        return "salut";
    }
    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleArithmeticException(ArithmeticException ex, Model model){
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }
}
