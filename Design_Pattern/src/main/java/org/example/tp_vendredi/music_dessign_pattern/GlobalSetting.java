package org.example.tp_vendredi.music_dessign_pattern;

public class GlobalSetting {
    private static volatile GlobalSetting instance = null;
    private static final Object lock = new Object();
    private int volume;

    private GlobalSetting() {

    }

    public static GlobalSetting getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new GlobalSetting();
            }
        }
        return instance;
    }
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume)  {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
            System.out.println("Volume set to: " + volume);
        } else {
            throw new IllegalArgumentException("Invalid volume. Volume should be between 0 and 100.");

        }
    }

}
