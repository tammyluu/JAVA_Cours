package org.example.tp_vendredi.music_dessign_pattern;

import org.example.tp_vendredi.music_dessign_pattern.builder.CompositionBuilder;
import org.example.tp_vendredi.music_dessign_pattern.builder.MusicCompositionBuilder;
import org.example.tp_vendredi.music_dessign_pattern.entity.Composition;

public class Main {
    public static void main(String[] args) {
    GlobalSetting globalSetting = GlobalSetting.getInstance();
    globalSetting.setVolume(20);
        CompositionBuilder compositionBuilder = new MusicCompositionBuilder();
        Composition composition = compositionBuilder
                .addInstrument("Piano")
                .addInstrument("Guitard")
                .build();
        composition.play();
    }
}
