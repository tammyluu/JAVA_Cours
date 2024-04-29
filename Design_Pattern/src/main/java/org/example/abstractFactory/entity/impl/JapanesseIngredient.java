package org.example.abstractFactory.entity.impl;

import org.example.abstractFactory.Ingredient;

public class JapanesseIngredient extends Ingredient {
    @Override
    protected void prepare() {
        System.out.println("Japansese prepare");
    }
}
