package org.example.tp_vendredi.zoo_design_pattern;

import org.example.tp_vendredi.zoo_design_pattern.entity.Animal;
import org.example.tp_vendredi.zoo_design_pattern.factory.CarnivoreFactory;
import org.example.tp_vendredi.zoo_design_pattern.factory.HerbivoreFactrory;
import org.example.tp_vendredi.zoo_design_pattern.factory.OmnivoreFactory;
import org.example.tp_vendredi.zoo_design_pattern.builder.CarnivoreBuilder;
import org.example.tp_vendredi.zoo_design_pattern.builder.HerbivoreBuilder;
import org.example.tp_vendredi.zoo_design_pattern.builder.OmnivoreBuilder;

import java.util.List;

public class ZooTest {
    public static void main(String[] args) {
        List<Animal> animals = Storage.getInstance().getAnimalList();

        CarnivoreFactory carnivoreFactory = new CarnivoreFactory();
        HerbivoreFactrory herbivoreFactrory = new HerbivoreFactrory();
        OmnivoreFactory omnivoreFactory = new OmnivoreFactory();

        animals.add(carnivoreFactory.createAnimal(new CarnivoreBuilder()
                .name("Tropical Tiger")
                .age(3)
                .weight(100)
                .speed(60)
                .behavior("Tiger")));
        Storage.displayAnimalList(animals);
        animals.add(herbivoreFactrory.createAnimal(new HerbivoreBuilder()
                .name("Cerf")
                .age(2)
                .weight(180)
                .speed(15)
                .behavior("Cerf")));
        Storage.displayAnimalList(animals);
        animals.add(omnivoreFactory.createAnimal(new OmnivoreBuilder()
                .name("Monkey")
                .age(8)
                .weight(5)
                .speed(10)
                .behavior("Monkey")));
        Storage.displayAnimalList(animals);
    }
}
