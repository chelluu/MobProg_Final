package com.example.mobprog_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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

        if (savedInstanceState == null ){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragmentContainerView, HomeFragment.class, null)
                    .commit();
        }
//
//        if (savedInstanceState == null ){
//            getSupportFragmentManager().beginTransaction()
//                    .setReorderingAllowed(true)
//                    .add(R.id.fragmentContainerView2, SearchFragment.class, null)
//                    .commit();
//        }

        ImageView profileView = findViewById(R.id.profileIcon);
        profileView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Profile.class);
                startActivity(intent);
            }
        });

        RecyclerView tweetRecyclerView = findViewById(R.id.tweetRecyclerView);

        List<Tweet> tweetList = new ArrayList<>();

        tweetList.add(new Tweet("User1", "This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.",R.drawable.profile_1,R.drawable.profile_1,50,2,3));
        tweetList.add(new Tweet("User1", "This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.",R.drawable.profile_1,null,100,10,3));
        tweetList.add(new Tweet("User1", "This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.",R.drawable.profile_1,R.drawable.news_image1,0,0,0));
        tweetList.add(new Tweet("User1", "This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.",R.drawable.news_image1,null,1,1,1));

        TweetAdapter tweetAdapter = new TweetAdapter(this,tweetList);
        tweetRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tweetRecyclerView.setAdapter(tweetAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(tweetRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider_line));
        tweetRecyclerView.addItemDecoration(dividerItemDecoration);
    }



}