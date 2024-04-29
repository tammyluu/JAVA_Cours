package org.example.strategy_Game.strategies;

public class ComportementHache implements ComportementArme {
    @Override
    public void utiliserArme() {
        System.out.println("Je combat en utilisant une Hâche!");
    }
}
