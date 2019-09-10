package com.example.movie.description_remote;


import com.example.movie.description_model.MovieDescription;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface MyService {
    @Headers("Content-Type: application/json")
    @GET("bins/q3ab3")
    Call<List<MovieDescription>>getData();
}
