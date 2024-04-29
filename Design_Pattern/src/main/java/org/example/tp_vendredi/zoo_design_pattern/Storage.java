package org.example.tp_vendredi.zoo_design_pattern;

import lombok.Getter;
import org.example.tp_vendredi.zoo_design_pattern.entity.Animal;
import org.example.tp_vendredi.zoo_design_pattern.builder.AnimalBuilder;

import java.util.ArrayList;
import java.util.List;

public class Storage implements Subject{

       private static volatile  Storage instance = null;
        private static final Object lock = new Object();
        @Getter
        List<Animal> animalList;
        List<Observer> observers = new ArrayList<>();

    private  Storage() {
         animalList = new ArrayList<>();

        System.out.println("Init object from class object Storage");

        }

    public static  Storage getInstance() {
            if (instance == null) {
                synchronized (lock) {
                    instance = new  Storage();
                }
            }
            return instance;
        }

    public static void displayAnimalList(List<Animal> animalList) {
        for (Animal a : animalList) {
            System.out.println(a);
        }

    }

    @Override
    public String toString() {
        return "Storage { " +
                " animalList = " + animalList +
                '}';
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }


    @Override
    public void notifyObserversNewAnimal(Animal animal) {
        for ( Observer o: observers   ) {
            o.updateNewArrivalAnimals(animal);
        }
    }

    public void notifyObserversBehaviour(AnimalBuilder animalBuilder) {
        for (Observer o : observers
        ) {
            if (animalBuilder.getSpecialBehaviour() != null) {
                o.updateBehaviors(animalBuilder);
            }

        }
    }
}
