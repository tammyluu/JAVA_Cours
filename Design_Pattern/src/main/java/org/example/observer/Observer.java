package org.example.observer;

public interface Observer {
    //méthode pop
    public void update(Observable observable);
    //methode push : on mets params direct dans ()
    //public  void updatePush(int state);
}
