package com.example.mibitelver2.view.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mibitelver2.R;
import com.example.mibitelver2.utils.Constants;
import com.example.mibitelver2.view.TrendingCategoryActivity;

import org.jetbrains.annotations.NotNull;

import static com.example.mibitelver2.R.string.sample;

public class TrendingAdapterSmallAdapter extends RecyclerView.Adapter<TrendingAdapterSmallAdapter.TrendingSmallHolder> {

    public TrendingAdapterSmallAdapter() {
        super();
    }

    @NonNull
    @NotNull
    @Override
    public TrendingSmallHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trending_main_list_item, parent, false);
        return new TrendingSmallHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TrendingAdapterSmallAdapter.TrendingSmallHolder holder, int position) {
        holder.iv.setImageResource(R.drawable.splash);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    static class TrendingSmallHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        public TrendingSmallHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.tr_main_list_item_iV);
        }
    }
}
