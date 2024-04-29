package org.example.vehicle_Strategy;

import java.util.Random;

public class RoadStrategy implements INavigationStrategy{
    private Random ran = new Random();
    @Override
    public boolean applyNavigate(String destination) {
        System.out.println(" Déviation par les routières:  " + destination);
        return ran.nextBoolean();
    }
}
