package org.example.tp_vendredi.zoo_design_pattern;

import org.example.tp_vendredi.zoo_design_pattern.entity.Animal;
import org.example.tp_vendredi.zoo_design_pattern.builder.AnimalBuilder;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);

    void notifyObserversNewAnimal(Animal animal);
    void notifyObserversBehaviour(AnimalBuilder animalBuilder);

}
