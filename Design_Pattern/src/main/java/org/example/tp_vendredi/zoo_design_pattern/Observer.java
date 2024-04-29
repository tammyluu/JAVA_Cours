package org.example.tp_vendredi.zoo_design_pattern;

import org.example.tp_vendredi.zoo_design_pattern.entity.Animal;
import org.example.tp_vendredi.zoo_design_pattern.builder.AnimalBuilder;

public interface Observer {
    void updateNewArrivalAnimals(Animal animal);
    void updateBehaviors(AnimalBuilder animalBuilder);
}
