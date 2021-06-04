package com.example.mibitelver2.view.ui.trending;

import android.os.Bundle;
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
import com.example.mibitelver2.databinding.FragmentTrendingBinding;
import com.example.mibitelver2.model.Video;
import com.example.mibitelver2.view.adapter.TrendingAdapter;

import java.util.List;

public class TrendingFragment extends Fragment {

    private TrendingViewModel trendingViewModel;
    private FragmentTrendingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        trendingViewModel =
                new ViewModelProvider(this).get(TrendingViewModel.class);

        binding = FragmentTrendingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        setUpRecyclerView(root);
        return root;
    }

    private void setUpRecyclerView(View v) {
        TrendingAdapter adapter = new TrendingAdapter();
        RecyclerView recyclerView = v.findViewById(R.id.fragment_trending_RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}