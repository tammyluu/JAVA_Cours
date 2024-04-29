package org.example.vehicle_Strategy;

import java.util.Random;

public class OffroadStrategy implements  INavigationStrategy{
    private Random ran = new Random();

    @Override
    public boolean applyNavigate(String destination) {
        System.out.println("Déviation hors-route: " + destination);
        return ran.nextBoolean();
    }
}
