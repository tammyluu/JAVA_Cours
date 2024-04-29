package org.example.observer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ObservableImpl implements Observable {
    private int state = 10;
    private List<Observer> observers = new ArrayList<>();
    @Override
    public void subscribe(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o:observers ) {
            o.update(this);
        }
    }

    public void setState(int state) {
        this.state = state;
        // Dès qu'état change -> update état
        this.notifyObserver();
    }


}
