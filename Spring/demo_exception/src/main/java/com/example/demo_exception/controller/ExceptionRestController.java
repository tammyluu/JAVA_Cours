package com.example.demo_exception.controller;

import com.example.demo_exception.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//@RestControllerAdvice
@ControllerAdvice
public class ExceptionRestController {
    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public  String handlerArithmeticException(ArithmeticException ex){
        return "problem of Maths (je suis dans le rest controller advice) " + ex.getMessage();
    }
    @ExceptionHandler(CustomException.class)
    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    public String customExceptionHandler(CustomException ex){
        return "We have a problem(je suis dans le rest controller advice )" + ex.getMessage();
    }


}
