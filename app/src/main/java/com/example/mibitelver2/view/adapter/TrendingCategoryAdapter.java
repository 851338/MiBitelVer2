package com.example.mibitelver2.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mibitelver2.R;
import com.example.mibitelver2.model.VideoByCategory;
import com.example.mibitelver2.utils.GlideLoader;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TrendingCategoryAdapter extends
        RecyclerView.Adapter<TrendingCategoryAdapter.TrendingCategoryHolder>{

    List<VideoByCategory> videos;

    public TrendingCategoryAdapter(List<VideoByCategory> videos) {
        super();
        this.videos = videos;
    }

    @NonNull
    @NotNull
    @Override
    public TrendingCategoryHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_trending_category_item, parent, false);
        return new TrendingCategoryHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TrendingCategoryAdapter
            .TrendingCategoryHolder holder, int position) {

        holder.name.setText(videos.get(position).getData().getTitle());
        holder.noView.setText(videos.get(position).getData().getTotalView());
        //holder.time.setText(videos.get(position).getData().);
        //holder.owner.setText(videos.get(position).getData().);
        GlideLoader glideLoader = new GlideLoader();
        glideLoader.loadPicture(videos.get(position).getData().getLinkVerticalCoverImage(),
                holder.imageView, holder.imageView.getContext());
    }

    @Override
    public int getItemCount() {
        if(videos != null){
            return videos.size();
        }
        return 0;
    }

    public static class TrendingCategoryHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView icon;
        TextView owner;
        TextView noView;
        TextView time;
        ImageView imageView;

        public TrendingCategoryHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.videoAvatar);
            name = itemView.findViewById(R.id.trending_category_videoTitle);
            icon = itemView.findViewById(R.id.trending_category_user_icon);
            owner = itemView.findViewById(R.id.trending_category_videOwner);
            noView = itemView.findViewById(R.id.trending_category_noView);
            time = itemView.findViewById(R.id.trending_category_time);
        }
    }
}
