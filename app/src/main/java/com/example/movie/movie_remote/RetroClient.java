package com.example.movie.movie_remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    private static final String ROOT_URL = "https://api.androidhive.info/";

  public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static UserService getApiService() {
        return getRetrofit().create(UserService.class);
    }


}
