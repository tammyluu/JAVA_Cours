package org.example.tp_vendredi.zoo_design_pattern.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.example.tp_vendredi.zoo_design_pattern.builder.OmnivoreBuilder;
@EqualsAndHashCode(callSuper = true)
@Data
public class Omnivore extends  Animal{
    private String name;
    private int age;
    private double weight;
    private double speed;
    private String behavior;

    public Omnivore(OmnivoreBuilder builder) {
        name = builder.getName();
        age = builder.getAge();
        weight = builder.getWeight();
        speed = builder.getSpeed();
        behavior = builder.getBehavior();
    }
}
