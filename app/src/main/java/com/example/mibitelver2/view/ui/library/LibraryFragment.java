package com.example.mibitelver2.view.ui.library;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mibitelver2.R;
import com.example.mibitelver2.databinding.FragmentLibraryBinding;
import com.example.mibitelver2.model.Video;
import com.example.mibitelver2.retrofit.APIVideoInterface;
import com.example.mibitelver2.retrofit.VideoRetrofitClient;
import com.example.mibitelver2.view.adapter.LibraryAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LibraryFragment extends Fragment {

    LibraryAdapter adapter;
    List<Video> videoList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root =inflater.inflate(R.layout.fragment_library, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.fragment_library_RV);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(root.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new LibraryAdapter(videoList);
        recyclerView.setAdapter(adapter);

        videoList = new ArrayList<>();
        APIVideoInterface apiService = VideoRetrofitClient.
                getClient().create(APIVideoInterface.class);

        Call<List<Video>> videos = apiService.getAllVideos();
        videos.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(@NotNull Call<List<Video>> call,
                                   @NotNull Response<List<Video>> response) {
                videoList = response.body();
                adapter.setVideos(videoList);
                Log.e("Get video success: ", "");
            }

            @Override
            public void onFailure(@NotNull Call<List<Video>> call, @NotNull Throwable t) {
                Log.e("Get video error: ", t.toString());
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}