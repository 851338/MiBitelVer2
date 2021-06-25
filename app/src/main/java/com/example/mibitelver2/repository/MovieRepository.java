package com.example.mibitelver2.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.example.mibitelver2.model.video.OneVideo;
import com.example.mibitelver2.retrofit.RetrofitClient;
import com.example.mibitelver2.retrofit.retrofitInterface.APIVideoInterface;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieRepository {

    private final APIVideoInterface apiInterface;

    public MovieRepository() {
        apiInterface = RetrofitClient.getClient().create(APIVideoInterface.class);
    }

    public MutableLiveData<OneVideo> getVideo(int id) {

        MutableLiveData<OneVideo> videoAccountMutableLiveData = new MutableLiveData<>();
        apiInterface.getVideoActivity(2, id).enqueue(new Callback<OneVideo>() {
            @Override
            public void onResponse(@NotNull Call<OneVideo> call,
                                   @NotNull Response<OneVideo> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    videoAccountMutableLiveData.setValue(response.body());
                    Log.d("error",response.body().getData().getLinkVideo());
                }
            }

            @Override
            public void onFailure(@NotNull Call<OneVideo> call, @NotNull Throwable t) {

            }

        });
        return videoAccountMutableLiveData;
    }


}
