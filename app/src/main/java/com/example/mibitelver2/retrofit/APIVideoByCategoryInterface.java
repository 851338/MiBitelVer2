package com.example.mibitelver2.retrofit;

import com.example.mibitelver2.model.VideoByCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIVideoByCategoryInterface {
    @GET("videos/categories/1")
    Call<List<VideoByCategory>> getAllVideosByCategory();
}
