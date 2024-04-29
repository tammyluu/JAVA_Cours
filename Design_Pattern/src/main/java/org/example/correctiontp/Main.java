package org.example.correctiontp;


import org.example.correctiontp.builder.CastleBuilder;
import org.example.correctiontp.entity.Building;
import org.example.correctiontp.factory.CastleFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Building> buildings = new ArrayList<>();
        CastleFactory castleFactory = new CastleFactory();

        //Ajouter un castle
        buildings.add(castleFactory.createBuilding(new CastleBuilder()
                .name("castle 1")
                .size(10)
                .style("Big One")
        ));

    }
}
