package org.example.stock_observer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data

public class Product {
    private int stockLevel;
    private List<Observer> observers ;
    private String name;

    public Product(){
        //éviter null pointer
           this.observers = new ArrayList<>();
    }
    public Product( String name ,int stockInitial) {
        this();// éviter null pointer, on appelle le constructor au dessus
        this.stockLevel = stockInitial;
        this.name = name;
    }

    public void setStockLevel(int newStockLevel) {
        if (newStockLevel != stockLevel) {
            stockLevel = newStockLevel;
            notifyObservers();
        }
    }
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
