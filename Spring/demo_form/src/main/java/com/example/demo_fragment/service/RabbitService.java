package com.example.demo_fragment.service;

import com.example.demo_fragment.model.Rabbit;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Service
public class RabbitService {
    private final Map<UUID, Rabbit> rabbits;

    public RabbitService() {
        rabbits = new HashMap<>();
        Rabbit rabbitA = Rabbit.builder()
                .id(UUID.randomUUID())
                .name("Sunny")
                .breed("angora")
                .build();
        Rabbit rabbitB = Rabbit.builder()
                .id(UUID.randomUUID())
                .name("Moon")
                .breed("belier")
                .build();
        Rabbit rabbitC = Rabbit.builder()
                .id(UUID.randomUUID())
                .name("Rainbow")
                .breed("angora")
                .build();
        Rabbit rabbitD = Rabbit.builder()
                .id(UUID.randomUUID())
                .name("Rainy")
                .breed("jersey wooly")
                .build();
        rabbits.put(rabbitA.getId(),rabbitA);
        rabbits.put(rabbitB.getId(),rabbitB);
        rabbits.put(rabbitC.getId(),rabbitC);
        rabbits.put(rabbitD.getId(),rabbitD);

    }
    public List<Rabbit> getRabbits(){
        // declarer en Map, return List donc :
        return rabbits.values().stream().toList();
    }
    public  Rabbit getRabbit(UUID id){
        return rabbits.values().stream().filter(rabbit -> rabbit.getId().equals(id)).findFirst().orElse(null);
      //return  rabbits.get(id);
    }
    public  boolean addRabbit(Rabbit rabbit){
//        Rabbit rabbitToAdd = Rabbit.builder()
//                .id(UUID.randomUUID())
//                .name(rabbit.getName())
//                .breed(rabbit.getBreed())
//                .build();

        if ((rabbit.getId() == null)) {
            rabbit.setId(UUID.randomUUID());
            rabbits.put(rabbit.getId(), rabbit);
            return true;
        }else {
            return false;
        }
    }
    public Rabbit getRabbitByName(String name){
        return rabbits.values().stream().filter(rabbit -> rabbit.getName().equals(name)).findFirst().orElse(null);
    }


}
