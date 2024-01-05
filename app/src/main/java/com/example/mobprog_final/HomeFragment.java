package com.example.mobprog_final;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

        //        ImageView profileView = findViewById(R.id.profileIcon);
//        profileView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home.this, Profile.class);
//                startActivity(intent);
//            }
//        });
//
//        RecyclerView tweetRecyclerView = findViewById(R.id.tweetRecyclerView);
//
//        List<Tweet> tweetList = new ArrayList<>();
//
//        tweetList.add(new Tweet("User1", "This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.",R.drawable.profile_1,R.drawable.profile_1,50,2,3));
//        tweetList.add(new Tweet("User1", "This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.",R.drawable.profile_1,null,100,10,3));
//        tweetList.add(new Tweet("User1", "This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.",R.drawable.profile_1,R.drawable.news_image1,0,0,0));
//        tweetList.add(new Tweet("User1", "This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.",R.drawable.news_image1,null,1,1,1));
//
//        TweetAdapter tweetAdapter = new TweetAdapter(this,tweetList);
//        tweetRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        tweetRecyclerView.setAdapter(tweetAdapter);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(tweetRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
//        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider_line));
//        tweetRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView profileView = view.findViewById(R.id.profileIcon);
        profileView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Profile.class);
                startActivity(intent);
            }
        });

        RecyclerView tweetRecyclerView = view.findViewById(R.id.tweetRecyclerView);

        List<Tweet> tweetList = new ArrayList<>();

        tweetList.add(new Tweet("User1", "This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.",R.drawable.profile_1,R.drawable.profile_1,50,2,3));
        tweetList.add(new Tweet("User1", "This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.",R.drawable.profile_1,null,100,10,3));
        tweetList.add(new Tweet("User1", "This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.",R.drawable.profile_1,R.drawable.news_image1,0,0,0));
        tweetList.add(new Tweet("User1", "This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.This is a sample tweet.",R.drawable.news_image1,null,1,1,1));

        TweetAdapter tweetAdapter = new TweetAdapter(this.getContext(),tweetList);
        tweetRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        tweetRecyclerView.setAdapter(tweetAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(tweetRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this.getContext(), R.drawable.divider_line));
        tweetRecyclerView.addItemDecoration(dividerItemDecoration);
    }
}