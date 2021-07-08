package com.example.articlescrollingwithrecyclerview;

public class Article {

    private int imageId;
    private String title;
    private String author;

    public Article(int imageId, String title, String author) {
        this.imageId = imageId;
        this.title = title;
        this.author = author;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
