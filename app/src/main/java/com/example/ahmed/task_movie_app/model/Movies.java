package com.example.ahmed.task_movie_app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ahmed on 5/18/2017.
 */

public class Movies {


    @SerializedName("movie_id_4")
    @Expose
    private int movie_id_4;
    @SerializedName("movie_name_4")
    @Expose
    private String movie_name_4;
    @SerializedName("movie_img_4")
    @Expose
    private String movie_img_4;


    public int getMovie_id_4() {
        return movie_id_4;
    }

    public void setMovie_id_4(int movie_id_4) {
        this.movie_id_4 = movie_id_4;
    }

    public String getMovie_name_4() {
        return movie_name_4;
    }

    public void setMovie_name_4(String movie_name_4) {
        this.movie_name_4 = movie_name_4;
    }

    public String getMovie_img_4() {
        return movie_img_4;
    }

    public void setMovie_img_4(String movie_img_4) {
        this.movie_img_4 = movie_img_4;
    }
}
