package org.example.tp_vendredi.zoo_design_pattern.builder;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.example.tp_vendredi.zoo_design_pattern.entity.Animal;
import org.example.tp_vendredi.zoo_design_pattern.entity.Herbivore;

@Getter
@EqualsAndHashCode(callSuper = true)
@Data
public class HerbivoreBuilder extends AnimalBuilder{

    private String name;
    private int age;
    private double weight;
    private double speed;
    private  String behavior;
    @Override
    public AnimalBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public AnimalBuilder age(int age) {
        this.age = age;
        return this;
    }

    @Override
    public AnimalBuilder weight(double weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public AnimalBuilder speed(double speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public Animal build() {
        return new Herbivore(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    @Override
    public AnimalBuilder behavior(String behavior) {
        this.behavior = behavior;
        return this;
    }

    @Override
    public String getSpecialBehaviour() {
        return null;
    }

    @Override
    public String toString() {
        return "HerbivoreBuilder{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", speed=" + speed +
                ", behavior='" + behavior + '\'' +
                '}';
    }
}
