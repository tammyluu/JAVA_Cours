package org.example.strategy_Game;

import org.example.strategy_Game.personnages.Personnage;
import org.example.strategy_Game.personnages.Reine;
import org.example.strategy_Game.personnages.Roi;
import org.example.strategy_Game.personnages.Troll;
import org.example.strategy_Game.strategies.ComportementPoignard;

public class Main {
    public static void main(String[] args) {
        Personnage reine = new Reine();
        reine.combattre();

        Personnage roi = new Roi();
        roi.combattre();

        Personnage troll = new Troll();
        troll.combattre();

        System.out.println("---------------------");
        roi.setComportementArme(new ComportementPoignard());
        roi.combattre();

        System.out.println("---------------------");
        reine.combattre();
        System.out.println("---------------------");
        reine.combattre();
        System.out.println("---------------------");
        reine.combattre();
        System.out.println("---------------------");
        reine.combattre();
        System.out.println("---------------------");
        reine.combattre();

    }
}
