package org.example.strategy_Game.personnages;

import org.example.strategy_Game.strategies.ComportementArcEtFleche;
import org.example.strategy_Game.strategies.ComportementHache;

public class Roi extends Personnage {
    public Roi() {
        this.comportementArme = new ComportementHache();
    }

    @Override
    public void combattre() {
        score += 4;
        System.out.println("Je suis un Roi.........");
        this.comportementArme.utiliserArme();
        System.out.println("Score =  " + score);
    }
}
