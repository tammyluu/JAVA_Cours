package org.example.tp_vendredi.music_dessign_pattern.builder;

import org.example.tp_vendredi.music_dessign_pattern.Instrument;
import org.example.tp_vendredi.music_dessign_pattern.entity.Composition;

import java.util.ArrayList;
import java.util.List;

public  abstract class CompositionBuilder {
    protected List<Instrument> instruments = new ArrayList<>();

    public abstract CompositionBuilder addInstrument(String instrumentName);

    //public abstract CompositionBuilder addMelody(String melody);


    public abstract Composition build();
}
