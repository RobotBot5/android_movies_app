package com.robotbot.movies;

import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("id")
    private int id;

    @SerializedName("author")
    private String author;

    @SerializedName("review")
    private String text;

    @SerializedName("type")
    private String type;


    public Review(int id, String author, String text, String type) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
