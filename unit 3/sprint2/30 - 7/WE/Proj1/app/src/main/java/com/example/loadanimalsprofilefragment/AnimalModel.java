package com.example.loadanimalsprofilefragment;

public class AnimalModel {

    private String animalImage;
    private String animalName;

    public AnimalModel(String animalImage, String animalName) {
        this.animalImage = animalImage;
        this.animalName = animalName;
    }

    public String getAnimalImage() {
        return animalImage;
    }

    public String getAnimalName() {
        return animalName;
    }
}
