package org.example.strategy_Game.strategies;

public class ComportementArcEtFleche implements ComportementArme {
    @Override
    public void utiliserArme() {
        System.out.println("Je combat en utilisant un Arc et Flèche! ");
    }
}
