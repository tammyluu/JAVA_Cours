package org.example.strategy_Game.personnages;

import lombok.Data;
import org.example.strategy_Game.strategies.ComportementArme;
@Data
public  abstract class Personnage {
    protected String name;
    protected int score;
    protected ComportementArme comportementArme;
    public abstract void combattre();

}
