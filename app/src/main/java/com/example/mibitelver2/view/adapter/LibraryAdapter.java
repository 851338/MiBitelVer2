package com.example.mibitelver2.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mibitelver2.R;

import org.jetbrains.annotations.NotNull;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryHolder> {

    public LibraryAdapter() {
        super();
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
        holder.iV.setImageResource(R.drawable.splash);
        holder.nameTag.setText("Something #TestA");
        holder.user.setImageResource(R.drawable.user);
        holder.nOViews.setText("nOViews");
        holder.timeUpload.setText("3 days ago");
        holder.owner.setText("video owner");
    }

    @Override
    public int getItemCount() {
        return 5;
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
