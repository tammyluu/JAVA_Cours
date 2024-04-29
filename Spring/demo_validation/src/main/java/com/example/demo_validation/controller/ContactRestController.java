package com.example.demo_validation.controller;

import com.example.demo_validation.model.Contact;
import jakarta.validation.Valid;
import org.apache.logging.log4j.util.StringBuilders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactRestController {
    @GetMapping
    public  Contact getOneContact(){
        return  Contact.builder()
                .firtName("toto")
                .lastName("tata")
                .age(40)
                .build();
    }

    @PostMapping
    public ResponseEntity<String> postContact(@RequestBody @Valid Contact contact, BindingResult result){
        if (result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString() + ", "));
                return  new ResponseEntity<>(errors.toString(),HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>("Contact ok ", HttpStatus.CREATED);
    }
}
