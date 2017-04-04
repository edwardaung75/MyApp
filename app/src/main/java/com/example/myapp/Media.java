package com.example.myapp;

/**
 * Created by aungaung on 10/8/2016.
 */

public class Media {
    private String title;
    String artist;

    private Media(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
}
