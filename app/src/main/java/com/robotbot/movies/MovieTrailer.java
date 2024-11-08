package com.robotbot.movies;

import com.google.gson.annotations.SerializedName;

public class MovieTrailer {

    @SerializedName("videos")
    private Videos videos;

    public MovieTrailer(Videos videos) {
        this.videos = videos;
    }

    public Videos getVideos() {
        return videos;
    }

    @Override
    public String toString() {
        return "MovieTrailer{" +
                "videos=" + videos +
                '}';
    }
}
