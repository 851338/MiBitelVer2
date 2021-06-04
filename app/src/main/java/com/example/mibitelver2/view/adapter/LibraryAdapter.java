package com.example.mibitelver2.view.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mibitelver2.R;
import com.example.mibitelver2.model.Video;
import com.example.mibitelver2.utils.GlideLoader;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryHolder> {

    private List<Video> videos;

    public LibraryAdapter(List<Video> videos) {
        super();
        this.videos = videos;
    }

    @NonNull
    @NotNull
    @Override
    public LibraryHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.library_history_item, parent, false);
        return new LibraryHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull LibraryAdapter.LibraryHolder holder, int position) {
        Video currentVideo = videos.get(position);
        GlideLoader glideLoader = new GlideLoader();
        glideLoader.loadPicture(videos.get(position).getAvatar(),
                holder.iV, holder.iV.getContext());
        holder.nameTag.setText(currentVideo.getTitle());
        holder.user.setImageResource(R.drawable.user);
        holder.nOViews.setText(currentVideo.getCategory_id());
        holder.timeUpload.setText(currentVideo.getId());
        holder.owner.setText(currentVideo.getCategory_id());
    }

    @Override
    public int getItemCount() {
        if(videos != null){
            return videos.size();
        }
        return 0;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
        notifyDataSetChanged();
    }

    static class LibraryHolder extends RecyclerView.ViewHolder {

        ImageView iV;
        ImageView user;
        TextView nameTag;
        TextView nOViews;
        TextView timeUpload;
        TextView owner;
        public LibraryHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            iV = itemView.findViewById(R.id.library_history_iV);
            user = itemView.findViewById(R.id.library_history_user_icon);
            nameTag = itemView.findViewById(R.id.library_history_nameNTag);
            nOViews = itemView.findViewById(R.id.library_history_nOViews);
            timeUpload = itemView.findViewById(R.id.library_history_time_upload);
            owner = itemView.findViewById(R.id.library_history_video_owner);
        }
    }
}
