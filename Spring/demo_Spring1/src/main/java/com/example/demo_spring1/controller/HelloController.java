package com.example.demo_spring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {
@RequestMapping(value = "/")
public String sayHello(){
    System.out.println("coucou");
    return "hello"; // nom de fiche html pour return
}

@RequestMapping(value = "/coucou")
@ResponseBody
public List<String> getPersons(){
    return  List.of("John Dupont","Toto tata", "Lala Lyli");
}
@RequestMapping(value = "toto")
public String showTodo(){
    return "toto";
}
@RequestMapping("/home/person")
public String personName(Model model){
    model.addAttribute("firstName", "Tammy");
    model.addAttribute("lastName", "Luu");

    List<String> persons = List.of("John Dupont","Mama Mia", "Lala Lyli");
    //List<String> persons = List.of();
    model.addAttribute("persons", persons);

    return "person/details";
}

}
