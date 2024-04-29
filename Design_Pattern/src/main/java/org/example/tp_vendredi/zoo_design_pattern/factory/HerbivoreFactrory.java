package org.example.tp_vendredi.zoo_design_pattern.factory;

import org.example.tp_vendredi.zoo_design_pattern.entity.Animal;
import org.example.tp_vendredi.zoo_design_pattern.Storage;
import org.example.tp_vendredi.zoo_design_pattern.builder.AnimalBuilder;

public class HerbivoreFactrory extends AnimalFactory{
    @Override
    public Animal createAnimal(AnimalBuilder builder) {
        Animal herbivore= builder.build();
        if(builder.getSpecialBehaviour() != null) {
            Storage.getInstance().notifyObserversBehaviour(builder);
        }
        Storage.getInstance().notifyObserversNewAnimal(herbivore);
        return herbivore;
    }
}
