package com.example.idenditycard;

public class IdentityCard {
    private String companyName;
    private int imageId;
    private int age;
    private String profession;

    public IdentityCard(String companyName, int imageId, int age, String profession) {
        this.companyName = companyName;
        this.imageId = imageId;
        this.age = age;
        this.profession = profession;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getImageId() {
        return imageId;
    }

    public int getAge() {
        return age;
    }

    public String getProfession() {
        return profession;
    }
}
