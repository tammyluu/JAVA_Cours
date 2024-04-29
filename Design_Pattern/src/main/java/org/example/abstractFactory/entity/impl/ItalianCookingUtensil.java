package org.example.abstractFactory.entity.impl;

import org.example.abstractFactory.CookingUtensil;

public class ItalianCookingUtensil  extends  CookingUtensil{
    @Override
    protected void use() {
        System.out.println("Italian use");
    }
}
