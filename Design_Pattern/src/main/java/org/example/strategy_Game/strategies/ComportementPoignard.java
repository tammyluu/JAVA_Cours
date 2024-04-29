package org.example.strategy_Game.strategies;

public class ComportementPoignard implements ComportementArme {
    @Override
    public void utiliserArme() {
        System.out.println("Je combat en utilisant un Poingard! ");
    }
}
