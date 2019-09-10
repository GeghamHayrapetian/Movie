package com.example.movie.movie_remote;

import com.example.movie.movie_model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {
    @GET("json/movies.json")
    Call<List<MovieModel>> getData();
}
