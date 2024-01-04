package com.example.mobprog_final;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.TweetViewHolder> {

    private List<Tweet> tweetList;
    private Context context;

    public TweetAdapter(Context context, List<Tweet> tweetList) {
        this.tweetList = tweetList;
        this.context=context;
    }

    @NonNull
    @Override
    public TweetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tweet, parent, false);
        return new TweetViewHolder(view);
    }

    private Bitmap cropToSquare(Bitmap bitmap) {
        int size = Math.min(bitmap.getWidth(), bitmap.getHeight());

        // Calculate the coordinates to crop the bitmap to a square
        int x = (bitmap.getWidth() - size) / 2;
        int y = (bitmap.getHeight() - size) / 2;

        // Create the final squared bitmap by cropping
        return Bitmap.createBitmap(bitmap, x, y, size, size);
    }



    @Override
    public void onBindViewHolder(@NonNull TweetViewHolder holder, int position) {
        Tweet tweet = tweetList.get(position);
        holder.usernameTextView.setText(tweet.getUsername());
        holder.tweetTextView.setText(tweet.getTweetText());
        int userProfileImageRes = tweet.getUserProfileImage();
        Bitmap originalBitmap = BitmapFactory.decodeResource(context.getResources(), userProfileImageRes);
        Bitmap squaredBitmap = cropToSquare(originalBitmap);
        holder.profileImageView.setImageBitmap(squaredBitmap);
        Integer tweetImage = tweet.getTweetImage();
        if (tweetImage != null) {
            holder.tweetImageView.setVisibility(View.VISIBLE);
            holder.tweetImageView.setImageResource(tweetImage);
        } else {
            holder.tweetImageView.setVisibility(View.GONE);
        }
        holder.likeTextView.setText(String.valueOf(tweet.getLikeCount()));
        holder.commentTextView.setText(String.valueOf(tweet.getCommentCount()));
        holder.dislikeTextView.setText(String.valueOf(tweet.getDislikeCount()));

    }


    @Override
    public int getItemCount() {
        return tweetList.size();
    }

    public static class TweetViewHolder extends RecyclerView.ViewHolder {
        TextView likeTextView;
        ImageView profileImageView;
        TextView usernameTextView;
        TextView tweetTextView;
        ImageView tweetImageView;
        TextView commentTextView;
        TextView dislikeTextView;

        public TweetViewHolder(View itemView) {
            super(itemView);
            usernameTextView = itemView.findViewById(R.id.usernameTextView);
            tweetTextView = itemView.findViewById(R.id.tweetTextView);
            profileImageView = itemView.findViewById(R.id.profileImageView);
            tweetImageView = itemView.findViewById(R.id.tweetImageView);
            commentTextView= itemView.findViewById(R.id.CommentTxtView);
            likeTextView = itemView.findViewById(R.id.likeTextView);
            dislikeTextView = itemView.findViewById(R.id.dislikeTextView);

        }
    }
}
