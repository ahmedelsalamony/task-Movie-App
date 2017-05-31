package com.example.ahmed.task_movie_app.rest;

import com.example.ahmed.task_movie_app.model.MSG;
import com.example.ahmed.task_movie_app.model.MovieDetails;
import com.example.ahmed.task_movie_app.model.Movies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ahmed on 5/10/2017.
 */

public interface ApiInterface {



    @FormUrlEncoded
    @POST("register.php")
    Call<MSG> userSignUp(@Field("fname") String fname,
                         @Field("lname") String lname,
                         @Field("email") String email,
                         @Field("password") String password);

    @FormUrlEncoded
    @POST("login.php")
    Call<MSG> userLogIn(@Field("email") String email,
                        @Field("password") String password);

    @GET("getAllMovies.php")
    Call<List<Movies>> loadAllMovies(@Query("studentNumber") int studentNumber, @Query("studentSec") int studentSec
            ,@Query("studentDep") int studentDep);


    @GET("getMovieDetailWithId.php")
    Call<MovieDetails> loadMovieDetails(@Query("studentNumber") int studentNumber, @Query("studentSec") int studentSec
            , @Query("studentDep") int studentDep, @Query("mID") int mID);

}
