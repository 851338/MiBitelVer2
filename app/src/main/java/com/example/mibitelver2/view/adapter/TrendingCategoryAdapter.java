package com.example.mibitelver2.view.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mibitelver2.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class TrendingCategoryAdapter extends RecyclerView.Adapter<TrendingCategoryAdapter.TrendingCategoryHolder> {

    @NonNull
    @NotNull
    @Override
    public TrendingCategoryHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_trending_category_item, parent, false);
        return new TrendingCategoryHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TrendingCategoryAdapter.TrendingCategoryHolder holder, int position) {
        holder.iv.setImageResource(R.drawable.splash);
        holder.icon.setImageResource(R.drawable.user);
        holder.name.setText("Tomorrowland #RelaxHouse #Music..");
        holder.noView.setText("noView");
        holder.time.setText("3 days ago");
        holder.owner.setText("Someone's name");
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class TrendingCategoryHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView name;
        ImageView icon;
        TextView owner;
        TextView noView;
        TextView time;

        public TrendingCategoryHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.trending_category_item_iv);
            name = itemView.findViewById(R.id.trending_category_videoTitle);
            icon = itemView.findViewById(R.id.trending_category_user_icon);
            owner = itemView.findViewById(R.id.trending_category_videOwner);
            noView = itemView.findViewById(R.id.trending_category_noView);
            time = itemView.findViewById(R.id.trending_category_time);
        }
    }
}
