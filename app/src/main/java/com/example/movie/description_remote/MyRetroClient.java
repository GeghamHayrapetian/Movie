package com.example.movie.description_remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetroClient {
    private static final String ROOT_URL = " https://api.myjson.com/";
    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static MyService getApiService() {
        return getRetrofit().create(MyService.class);
    }
}
