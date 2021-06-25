package com.example.mibitelver2.view.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.mibitelver2.model.video.OneVideo;
import com.example.mibitelver2.repository.MovieRepository;

public class VideoUserViewModel extends AndroidViewModel {
    public MutableLiveData<OneVideo> videoAcount12 = new MutableLiveData<>();
    private final MovieRepository movieRepository = new MovieRepository();
    public VideoUserViewModel(@NonNull Application application) {
        super(application);
    }


    public void getVideoAccount(int id) {
        videoAcount12 = movieRepository.getVideo(id);


    }
}
