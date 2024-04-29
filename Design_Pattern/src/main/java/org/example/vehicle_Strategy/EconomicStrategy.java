package org.example.vehicle_Strategy;

import java.util.Random;

public class EconomicStrategy implements INavigationStrategy{
    private Random ran = new Random();
    @Override
    public boolean applyNavigate(String destination) {
        System.out.println(" La navigation économique est votre choix: " + destination);
        return ran.nextBoolean();
    }
}
