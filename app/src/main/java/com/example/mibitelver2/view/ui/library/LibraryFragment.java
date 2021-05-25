package com.example.mibitelver2.view.ui.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mibitelver2.R;
import com.example.mibitelver2.databinding.FragmentLibraryBinding;
import com.example.mibitelver2.view.adapter.LibraryAdapter;

public class LibraryFragment extends Fragment {

    LibraryAdapter adapter;
    private LibraryViewModel libraryViewModel;
    private FragmentLibraryBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        libraryViewModel =
                new ViewModelProvider(this).get(LibraryViewModel.class);

        View root =inflater.inflate(R.layout.fragment_library, container, false);
        setUpRecyclerView(root);
        return root;
    }

    private void setUpRecyclerView(View v) {
        adapter = new LibraryAdapter();
        RecyclerView recyclerView = v.findViewById(R.id.fragment_library_RV);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}