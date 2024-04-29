package org.example.abstractFactory;

import org.example.abstractFactory.factory.impl.ItalianCuisineFactory;
import org.example.abstractFactory.factory.impl.JapaneseCuisineFactory;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(new ItalianCuisineFactory());
        restaurant.runPlate();
        restaurant.setCuisineFactory(new JapaneseCuisineFactory());
        restaurant.runPlate();
    }



    }

