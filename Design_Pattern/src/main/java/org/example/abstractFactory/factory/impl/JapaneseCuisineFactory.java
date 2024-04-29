package org.example.abstractFactory.factory.impl;

import org.example.abstractFactory.CookingUtensil;
import org.example.abstractFactory.Dish;
import org.example.abstractFactory.Ingredient;

public class JapaneseCuisineFactory extends  CuisineFactory {
    @Override
    public Ingredient createIngredient() {
        return null;
    }

    @Override
    public CookingUtensil createUtensil() {
        return null;
    }

    @Override
    public Dish createDish() {
        return null;
    }
}
