package com.example.mibitelver2.view.ui.library;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mibitelver2.model.Video;

import java.util.List;

import retrofit2.Call;

public class LibraryViewModel extends ViewModel {


    public LibraryViewModel() {
        super();
    }

    public LiveData<List<Video>> getAllVideos() {
        return null;
    }
}