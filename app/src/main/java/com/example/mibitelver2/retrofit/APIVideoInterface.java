package com.example.mibitelver2.retrofit;

import com.example.mibitelver2.model.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIVideoInterface {
    @GET("GetItemCategoryTwo")
    Call<List<Video>> getAllVideos();
}
