package org.example.abstractFactory.entity.impl;

import org.example.abstractFactory.Dish;


public class ItalianDish extends Dish {
    @Override
    protected void serve() {
        System.out.println("Italian serve");
    }
}