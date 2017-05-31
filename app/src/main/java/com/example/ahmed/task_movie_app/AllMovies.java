package com.example.ahmed.task_movie_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.ahmed.task_movie_app.adapter.MovieAdapter;
import com.example.ahmed.task_movie_app.model.Movies;
import com.example.ahmed.task_movie_app.rest.ApiClient;
import com.example.ahmed.task_movie_app.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllMovies extends AppCompatActivity {

    public static final String TAG = AllMovies.class.getSimpleName();
    RecyclerView recyclerView;
    MovieAdapter adapter;
    List<Movies> movieResults=new ArrayList<Movies>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movies);

        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter=new MovieAdapter(movieResults, R.layout.single__row, AllMovies.this);
        recyclerView.setAdapter(adapter);
        getMoviedata();



    }

    private void getMoviedata(){


        final ApiInterface apiInterface= ApiClient.getRetrofit().create(ApiInterface.class);

        Call<List<Movies>> call=apiInterface.loadAllMovies(2,1,2);

        call.enqueue(new Callback<List<Movies>>() {
            @Override
            public void onResponse(Call<List<Movies>> call, Response<List<Movies>> response) {


               // movieResults.addAll( response.body() );
               // adapter.notifyDataSetChanged();

                for(Movies mm: response.body()) {

                    Log.i("WHYNULL",mm.getMovie_name_4()+"");
                    movieResults.add(mm);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Movies>> call, Throwable t) {
                Log.i(TAG,t.getMessage());
                Log.i("movieResults",movieResults.size()+"");
            }


        });
    }

}
