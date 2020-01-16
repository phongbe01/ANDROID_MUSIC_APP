package com.example.my_music;

public class Song {
    private String title;
    private int File;
    private String type;

    public Song(String title, int file, String type) {
        this.title = title;
        File = file;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public int getFile() {
        return File;
    }

    public String getType() {
        return type;
    }
}
