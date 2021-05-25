package com.example.mibitelver2.view.adapter;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mibitelver2.R;
import com.example.mibitelver2.utils.Constants;
import com.example.mibitelver2.view.TrendingCategoryActivity;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

import static com.example.mibitelver2.R.string.sample;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.TrendingHolder> {

    public TrendingAdapter() {

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TrendingAdapter.TrendingHolder holder, int position) {
        TrendingAdapterSmallAdapter adapterSmallAdapter = new TrendingAdapterSmallAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.itemView.getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        holder.rv.setLayoutManager(linearLayoutManager);
        holder.nameTag.setText("SomeTag");
        holder.noView.setText("noView");
        holder.type.setText("Type");
        holder.rv.setAdapter(adapterSmallAdapter);
        holder.nameTag.setOnClickListener(v -> {
            Intent i = new Intent(holder.nameTag.getContext(), TrendingCategoryActivity.class);
            i.putExtra(Constants.trending_category, holder.nameTag.getText().toString());
            holder.nameTag.getContext().startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @NonNull
    @NotNull
    @Override
    public TrendingAdapter.TrendingHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trending_main_list, parent, false);
        return new TrendingHolder(v);
    }

    static class TrendingHolder extends RecyclerView.ViewHolder {

        TextView nameTag;
        TextView type;
        TextView noView;
        RecyclerView rv;

        public TrendingHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            nameTag = itemView.findViewById(R.id.trendingNameTag);
            type = itemView.findViewById(R.id.trendingType);
            noView = itemView.findViewById(R.id.trending_main_list_noViews);
            rv = itemView.findViewById(R.id.trending_main_list_RV);
        }
    }
}
