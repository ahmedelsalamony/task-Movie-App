package com.example.ahmed.task_movie_app.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmed.task_movie_app.AllMovies;
import com.example.ahmed.task_movie_app.R;
import com.example.ahmed.task_movie_app.listener.ItemClickListener;
import com.example.ahmed.task_movie_app.model.MovieDetails;
import com.example.ahmed.task_movie_app.model.Movies;
import com.example.ahmed.task_movie_app.rest.ApiClient;
import com.example.ahmed.task_movie_app.rest.ApiInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ahmed on 5/10/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.RepoViewHolder> {
    private List<Movies> repos;
    private int rowLayout;
    private Context context;




    public MovieAdapter(List<Movies> repos, int rowLayout, Context context) {
        this.repos = repos;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RepoViewHolder holder, int position) {
        holder.movieName.setText(repos.get(position).getMovie_name_4());
        Picasso.with(context).load(repos.get(position).getMovie_img_4()).into(holder.movieImg);




        holder.setClickListener(new ItemClickListener() {
            ImageView imageView = null;
            TextView textView=null;
            @Override
            public void onClick(View view, final int position, boolean isLongClick)
            {

                if (isLongClick)
                {
                    Dialog d=new Dialog(context);
                    d.setContentView(R.layout.dialog);
                    imageView=(ImageView)d.findViewById(R.id.imageView);
                    textView=(TextView)d.findViewById(R.id.textView);
                    List<MovieDetails> movieDetailses=new ArrayList<MovieDetails>();
                    final ApiInterface apiInterface= ApiClient.getRetrofit().create(ApiInterface.class);

                    Call<MovieDetails> call=apiInterface.loadMovieDetails(2,1,2,repos.get(position).getMovie_id_4());

                    call.enqueue(new Callback<MovieDetails>() {
                        @Override
                        public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {


                            Toast.makeText(context, response.body().getMovieName(), Toast.LENGTH_SHORT).show();
                            Picasso.with(context).load(response.body().getMovieImg()).into(imageView);
                            textView.setText(response.body().getMovieName());

                        }

                        @Override
                        public void onFailure(Call<MovieDetails> call, Throwable t) {


                        }


                    });
                    d.setTitle("Movie Details");
                    d.show();
                }else {

                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return repos.size();
    }


    public class RepoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView movieName  ;
        ImageView movieImg;
        private ItemClickListener clickListener;
        public RepoViewHolder(View convertView) {
            super(convertView);
            movieName = (TextView) convertView.findViewById(R.id.txtmoviename);
            movieImg=(ImageView) convertView.findViewById(R.id.img);
            convertView.setOnLongClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener){
            this.clickListener=itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onClick(view, getPosition(), true);
            return true;
        }
    }


}
