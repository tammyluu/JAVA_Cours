package org.example.correctiontp.factory;


import org.example.correctiontp.builder.BuildingBuilder;
import org.example.correctiontp.entity.Building;

public abstract class BuildingFactory {
    abstract Building createBuilding(BuildingBuilder builder);


}
