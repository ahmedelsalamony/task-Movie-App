package com.example.ahmed.task_movie_app.rest;



import com.example.ahmed.task_movie_app.MyApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ahmed on 5/10/2017.
 */

public class ApiClient {



    public static final String BASE_URL="http://haladoctor.com/testSec/";
    public static Retrofit retrofit=null;



    public static Retrofit getRetrofit()
    {


        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        if (retrofit==null)
        {
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                //.client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        }
        return retrofit;
    }
}
