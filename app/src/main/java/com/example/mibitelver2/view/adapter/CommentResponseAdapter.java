package com.example.mibitelver2.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mibitelver2.R;
import com.example.mibitelver2.model.Comment;

import java.util.List;

public class CommentResponseAdapter extends RecyclerView.Adapter<CommentResponseAdapter.ViewHolder> {
    private Context context;
    private List<Comment> commentListResponse;

    public CommentResponseAdapter(Context context, List<Comment> commentListResponse) {
        this.context = context;
        this.commentListResponse = commentListResponse;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_response_comment,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

     //   Glide.with(context).load(commentListResponse.get(position).getCommentImage()).into(holder.commentImage);
        holder.commentName.setText(commentListResponse.get(position).getCommentName());
        holder.commentTime.setText(commentListResponse.get(position).getCommentTime());
        holder.commentContent.setText(commentListResponse.get(position).getCommentContent());
        holder.commentLike.setText(commentListResponse.get(position).getCommentLike()+"");
    }

    @Override
    public int getItemCount() {
        return commentListResponse.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView commentImage;

        TextView commentContent,commentName,commentLike,commentTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            commentName = itemView.findViewById(R.id.commentName);
            commentImage = itemView.findViewById(R.id.commentimage);
            commentContent = itemView.findViewById(R.id.commentContent);
            commentTime = itemView.findViewById(R.id.commentTime);
            commentLike=itemView.findViewById(R.id.commentLike);

        }
    }
}
