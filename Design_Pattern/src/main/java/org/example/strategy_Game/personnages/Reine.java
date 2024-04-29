package org.example.strategy_Game.personnages;

import lombok.Data;
import org.example.strategy_Game.strategies.ComportementArcEtFleche;
import org.example.strategy_Game.strategies.ComportementArme;
import org.example.strategy_Game.strategies.ComportementHache;
@Data
public class Reine extends Personnage {
    public Reine() {
        this.comportementArme = new ComportementArcEtFleche();
    }

    @Override
    public void combattre() {
        score += 3;
        System.out.println("Je suis une reine.........");
        this.comportementArme.utiliserArme();
        System.out.println("Score =  " + score);
        if (score >= 12) {
            this.setComportementArme(new ComportementHache());
        }
    }
}
