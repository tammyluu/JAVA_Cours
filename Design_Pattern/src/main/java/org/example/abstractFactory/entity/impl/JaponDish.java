package org.example.abstractFactory.entity.impl;

import org.example.abstractFactory.Dish;

public class JaponDish extends Dish {
    @Override
    protected void serve() {
        System.out.println("Italian serve");
    }
}
