package com.example.mibitelver2.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideoByCategoryClient {
    private static final String BASE_URL = "http://localhost:8081/api/v1/";
    public static Retrofit retrofit;

    public static Retrofit getClient() {
        if(retrofit==null)
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }
}
