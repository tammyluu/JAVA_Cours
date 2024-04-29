package org.example.strategy_Game.personnages;

import org.example.strategy_Game.strategies.ComportementArcEtFleche;
import org.example.strategy_Game.strategies.ComportementPoignard;

public class Troll extends Personnage {
    public Troll() {
        this.comportementArme = new ComportementPoignard();
    }

    @Override
    public void combattre() {
        score += 1;
        System.out.println("Je suis un Troll.........");
        this.comportementArme.utiliserArme();
        System.out.println("Score =  " + score);
    }
}
