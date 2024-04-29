package org.example.tp_vendredi.zoo_design_pattern.factory;

import org.example.tp_vendredi.zoo_design_pattern.builder.AnimalBuilder;
import org.example.tp_vendredi.zoo_design_pattern.entity.Animal;

public abstract class AnimalFactory {
    public abstract Animal createAnimal(AnimalBuilder builder);
}
