package org.example.tp_vendredi.race_car.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HennesseyVenomF5  extends  Car{
    private String  engine;
    private double performance;
    private int chaissis;

    @Override
    public String toString() {
        return " HennesseyVenomF5 { " +
                " |engine='" + engine + '\'' +
                " |performance=" + performance +
                " |chaissis=" + chaissis +
                '}';
    }
}
