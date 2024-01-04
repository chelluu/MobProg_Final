package com.example.mobprog_final;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        RecyclerView tweetRecyclerView = findViewById(R.id.tweetRecyclerView);

        // Assuming this code is within your activity or wherever you're setting up the RecyclerView

// Create a list to hold tweets
        List<Tweet> tweetList = new ArrayList<>();

// Populate the list with dummy data (replace this with your actual data)
        tweetList.add(new Tweet("User1", "This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.",R.drawable.profile_1,R.drawable.profile_1,50,2,3));
        tweetList.add(new Tweet("User1", "This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.",R.drawable.profile_1,null,100,10,3));
        tweetList.add(new Tweet("User1", "This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.",R.drawable.profile_1,R.drawable.news_image1,0,0,0));
        tweetList.add(new Tweet("User1", "This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.",R.drawable.news_image1,null,1,1,1));
// Now, create the adapter and set it to the RecyclerView
        TweetAdapter tweetAdapter = new TweetAdapter(this,tweetList);
        tweetRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tweetRecyclerView.setAdapter(tweetAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(tweetRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider_line));
        tweetRecyclerView.addItemDecoration(dividerItemDecoration);
    }
}