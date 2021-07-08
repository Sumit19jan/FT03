package com.example.birdsgridview;

public class BirdModel {

    private String name;
    private int imageId;

    public BirdModel(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
