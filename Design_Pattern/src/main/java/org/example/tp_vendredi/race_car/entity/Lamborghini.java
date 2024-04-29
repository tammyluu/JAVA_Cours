package org.example.tp_vendredi.race_car.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Lamborghini extends Car{
    private String  engine;
    private double performance;
    private int chaissis;

    @Override
    public String toString() {
        return " Lamborghini { " +
                " |engine='" + engine + '\'' +
                " |performance=" + performance +
                " |chaissis=" + chaissis +
                '}';
    }
}
