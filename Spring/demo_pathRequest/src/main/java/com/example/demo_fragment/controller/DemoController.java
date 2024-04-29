package com.example.demo_fragment.controller;

import com.example.demo_fragment.model.Rabbit;
import com.example.demo_fragment.service.RabbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class DemoController {
    //argument requis (final) => utiliser @RequiredArgsConstructor
    private final RabbitService rabbitService;
    @GetMapping
    public String homPage(){
        return "pagea";
    }

    @GetMapping("/pageb")

    public  String pageb(Model model){
        List<Rabbit> rabbits = rabbitService.getRabbits();
        Rabbit rabbit = rabbits.get(0);
        //transfer model -> view under system key value and construct a link
        model.addAttribute("idRabbit", rabbit.getId());
        return "pageb";
    }

    @GetMapping("/detail/{rabbitId}")
    public String detailRabbit(@PathVariable("rabbitId")UUID id, Model model){
        Rabbit rabbit = rabbitService.getRabbit(id);
        model.addAttribute("monlapin",rabbit);
        return "pagec";
    }
     @GetMapping("/all")
    public  String  allRabbit (Model model){
         List<Rabbit> rabbits = rabbitService.getRabbits();
         model.addAttribute("rabbits", rabbits);
        return "pageb";
     }

}
