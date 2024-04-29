package org.example.tp_vendredi.music_dessign_pattern.builder;

import org.example.tp_vendredi.music_dessign_pattern.CategoryInstrument;
import org.example.tp_vendredi.music_dessign_pattern.Instrument;
import org.example.tp_vendredi.music_dessign_pattern.entity.Composition;

import java.util.List;

public class MusicCompositionBuilder extends CompositionBuilder{
    @Override
    public CompositionBuilder addInstrument(String instrumentName) {
        Instrument instrument = new CategoryInstrument(instrumentName);
        instruments.add(instrument);
        return this;
    }


    @Override
    public Composition build() {
        return new Composition(instruments) {
        };
    }



}
