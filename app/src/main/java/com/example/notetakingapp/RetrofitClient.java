package com.example.notetakingapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// this class creates a RetrofitClient we can use to connect to the internet and access
// APIs with. We give it a base url where it will be accessing to work from.
public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://my-json-server.typicode.com";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }
        return retrofit;
    }
}
