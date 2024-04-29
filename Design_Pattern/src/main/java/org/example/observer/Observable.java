package org.example.observer;

public interface Observable {
    public void subscribe(Observer o); //addObserver
    public  void  unsubscribe(Observer o); //removeObserver
    public  void  notifyObserver();
}
