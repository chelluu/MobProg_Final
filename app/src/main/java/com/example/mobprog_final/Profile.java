package com.example.mobprog_final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.kwabenaberko.newsapilib.models.Article;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Profile extends AppCompatActivity {

    private ImageView likeButton;
    private TextView likeCountText;
    private int likeCount = 0;
    private boolean isLiked = false;

    RecyclerView recyclerView;
    List<Article> articleList = new ArrayList<>();
//    NewsRecyclerAdapter adapter;
    LinearProgressIndicator progressIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        FrameLayout backgroundFrame = findViewById(R.id.background_img_frame);

//        ImageView backgroundImg = findViewById(R.id.background_img);
        ImageView profilePicture1 = findViewById(R.id.profile_picture1);
//        ImageView profilePicture2 = findViewById(R.id.profile_picture2);
//        ImageView newsImage = findViewById(R.id.news_img);
        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        String userNameLogin = sharedPreferences.getString("username", ""); // "" is the default value if the username is not found
        TextView name = findViewById(R.id.name);
//        TextView username = findViewById(R.id.username);
//        TextView description = findViewById(R.id.description);
//        TextView name2 = findViewById(R.id.name2);
//        TextView username2 = findViewById(R.id.username2);
//        TextView day = findViewById(R.id.day);
        TextView newsTitle = findViewById(R.id.news_title);

        likeButton = findViewById(R.id.like);
        likeCountText = findViewById(R.id.like_text);

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isLiked) {
                    // buat reset count jadi 0 kalo misalnya udah mencet like
                    likeCount = 0;
                } else {
                    likeCount++;
                }

                likeCountText.setText(String.valueOf(likeCount));

                // buat toggle state dari likenya
                isLiked = !isLiked;

                updateLikeButtonImage();
            }
        });

        newsTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, Home.class);
                startActivity(intent);
            }
        });

        ImageView hamburgerButton = findViewById(R.id.hamburgerButton);
        hamburgerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });

        name.setText(userNameLogin);

        backgroundFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateBackgroundImage();
            }
        });

        profilePicture1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProfilePictureDialog();
            }
        });


    }

    private void updateLikeButtonImage() {
        if(isLiked) {
            likeButton.setImageResource(R.drawable.like_red_btn);
        } else {
            likeButton.setImageResource(R.drawable.like_btn);
        }
    }

    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.hamburger_menu);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.home_menu) {
                    startActivity(new Intent(Profile.this, Home.class));
                    return true;
                }
                return false;
            }
        });

        popupMenu.show();
    }

    // Method to perform the expanding animation
    private void animateBackgroundImage() {
        ImageView backgroundImg = findViewById(R.id.background_img);

        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1f, 1.2f,
                1f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        scaleAnimation.setDuration(500);
        scaleAnimation.setFillAfter(true);

        backgroundImg.startAnimation(scaleAnimation);
    }

    private void showProfilePictureDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.profile_picture_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);

        ImageView enlargedProfilePicture = dialogView.findViewById(R.id.enlarged_profile_picture);

        AlertDialog dialog = builder.create();
        dialog.show();
    }


}