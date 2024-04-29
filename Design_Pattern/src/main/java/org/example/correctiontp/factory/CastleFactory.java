package org.example.correctiontp.factory;


import org.example.correctiontp.builder.BuildingBuilder;
import org.example.correctiontp.entity.Building;

public class CastleFactory extends BuildingFactory {
    @Override
    public Building createBuilding(BuildingBuilder builder) {
        //return new Castle((CastleBuilder) builder);
        return builder.build(); // c'est pour n'a pas besoins de .built() quand créer un new Obj
    }
}
