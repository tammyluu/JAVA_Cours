package org.example.abstractFactory.factory.impl;

import org.example.abstractFactory.CookingUtensil;
import org.example.abstractFactory.Dish;
import org.example.abstractFactory.Ingredient;

public abstract class CuisineFactory {
    public abstract Ingredient createIngredient();
    public abstract CookingUtensil createUtensil();
    public abstract Dish createDish();
}