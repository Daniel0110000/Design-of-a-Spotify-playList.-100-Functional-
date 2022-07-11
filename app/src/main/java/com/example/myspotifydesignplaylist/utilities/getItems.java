package com.example.myspotifydesignplaylist.utilities;

public class getItems {
    private String textNameMusic, textDateMusic;
    private int musicImage;

    public getItems(String textNameMusic, String textDateMusic, int musicImage) {
        this.textNameMusic = textNameMusic;
        this.textDateMusic = textDateMusic;
        this.musicImage = musicImage;
    }

    public String getTextNameMusic() {
        return textNameMusic;
    }

    public String getTextDateMusic() {
        return textDateMusic;
    }

    public int getMusicImage() {
        return musicImage;
    }
}

// Programer: Daniel Carias
