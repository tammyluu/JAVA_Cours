package org.example.tp_vendredi.zoo_design_pattern.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.tp_vendredi.zoo_design_pattern.builder.HerbivoreBuilder;
@EqualsAndHashCode(callSuper = true)
@Data
public class Herbivore extends Animal{
    private String name;
    private int age;
    private double weight;
    private double speed;
    private String behavior;

    public Herbivore(HerbivoreBuilder builder) {
        name = builder.getName();
        age = builder.getAge();
        weight = builder.getWeight();
        speed = builder.getSpeed();
        behavior = builder.getBehavior();
    }

}
