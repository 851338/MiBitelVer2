package com.example.mibitelver2.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "http://192.168.1.88:9999/api/v1/";
    public static Retrofit retrofit;

    public static Retrofit getClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(chain -> {
            Request request = chain.request().newBuilder().addHeader(
                    "Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9." +
                            "eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNjI0NTU0Mjc3LCJpYXQiOjE2Mj" +
                            "Q1MTgyNzd9.6ybLhtfZx1J74U-lppx8rigk11J8_NvUlPuclUct3hs").build();
            return chain.proceed(request);
        });

        if (retrofit == null)
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }
}
