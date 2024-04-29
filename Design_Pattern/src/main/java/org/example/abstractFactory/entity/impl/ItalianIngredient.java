package org.example.abstractFactory.entity.impl;

import org.example.abstractFactory.Ingredient;

public class ItalianIngredient extends Ingredient {
    @Override
    protected void prepare() {
        System.out.println("Italian prepare");
    }
}
