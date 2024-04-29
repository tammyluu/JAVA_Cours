package com.example.demo_fragment.controller;

import com.example.demo_fragment.model.Rabbit;
import com.example.demo_fragment.service.RabbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
     //afficher une formulaire
     @GetMapping("/add")
    public String addRabbit(Model model){
        model.addAttribute("rabbit", new Rabbit());
        return "form/form";
     }
     // action add
     @PostMapping("/add")
     //transmis en lapin en formulaire et renvoie
    public String submitRabbit(@ModelAttribute("rabbit") Rabbit rabbit){
         System.out.println(rabbit.getName());
         System.out.println(rabbit.getBreed());
         rabbitService.addRabbit(rabbit);
         // redirect à la racine
        return  "redirect:/";
     }
//    @GetMapping("/look")
//    // afficher ce qui n'est pas obligé
//    public String showRabbit(@RequestParam("name")String name, Model model){
//        System.out.println(name);
//        Rabbit rabbit =new Rabbit(UUID.randomUUID(), "test", "test");
//        model.addAttribute("monlapin",rabbit);
//        return "pagec";
//    }
    @GetMapping("/look")
    // afficher ce qui n'est pas obligé
    public String showRabbitA(@RequestParam(name = "namerabbit", required = false) String name, Model model){
        System.out.println(name);

        Rabbit rabbit = rabbitService.getRabbitByName(name);
        model.addAttribute("monlapin",rabbit);
        if (rabbit != null){
            return "pagec";
        }else
            return "paged";
    }

    // utiliser methode Get pour create
    @GetMapping("/addrabbit")
    public String submitRabbitVTwo(@RequestParam("name") String name,@RequestParam("breed") String breed){
        System.out.println(name);
        System.out.println(breed);
        rabbitService.addRabbit(new Rabbit(null,name,breed));
        return "redirect:/";
    }



}
