package com.example.ahmed.task_movie_app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ahmed on 5/19/2017.
 */

public class MovieDetails {

    @SerializedName("movie_id")
    @Expose
    private Integer movieId;
    @SerializedName("movie_name")
    @Expose
    private String movieName;
    @SerializedName("movie_img")
    @Expose
    private String movieImg;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(String movieImg) {
        this.movieImg = movieImg;
    }
}
