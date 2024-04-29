package org.example.tp_vendredi.music_dessign_pattern;

import lombok.Data;

@Data
public class CategoryInstrument implements Instrument{
    private String name;
    public CategoryInstrument(String name) {
        this.name = name;
    }
    @Override
    public void play() {
        System.out.println("Playing " + name);
    }
}
