package com.example.demo_validation.controller;

import com.example.demo_validation.model.Contact;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {
    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("contact",new Contact());
        return "form";
    }
    @PostMapping("/add")
    // @Valid : demande si il y aura error, verifier le
    public String  addContact(@Valid @ModelAttribute("contact")Contact contact, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "form";
        }
        return "form-confirm";
    }
}

