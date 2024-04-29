package org.example.tp_vendredi.zoo_design_pattern.builder;

import org.example.tp_vendredi.zoo_design_pattern.entity.Animal;

public abstract class AnimalBuilder {
    public  abstract  AnimalBuilder name(String name);
    public  abstract  AnimalBuilder age(int age);
    public  abstract  AnimalBuilder  weight(double weight);
    public  abstract  AnimalBuilder speed(double speed);
    public  abstract AnimalBuilder behavior(String behavior);
    public abstract String getSpecialBehaviour();
    public abstract Animal build();


}
