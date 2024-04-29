package org.example.tp_vendredi.music_dessign_pattern.entity;

import lombok.Data;
import org.example.tp_vendredi.music_dessign_pattern.Instrument;
import org.example.tp_vendredi.music_dessign_pattern.builder.MusicCompositionBuilder;

import java.util.List;
@Data
public class Composition {
    private List<Instrument> instruments;


    public Composition(List<Instrument> instruments) {
        this.instruments = instruments;
    }



    public void play() {
        System.out.println("Playing the music composition:");
        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }
}
