package com.example.mobprog_final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.kwabenaberko.newsapilib.models.Article;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Profile extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Article> articleList = new ArrayList<>();
//    NewsRecyclerAdapter adapter;
    LinearProgressIndicator progressIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        FrameLayout backgroundFrame = findViewById(R.id.background_img_frame);

        ImageView backgroundImg = findViewById(R.id.background_img);
        ImageView profilePicture1 = findViewById(R.id.profile_picture1);
        ImageView profilePicture2 = findViewById(R.id.profile_picture2);
        ImageView newsImage = findViewById(R.id.news_img);
        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        String userNameLogin = sharedPreferences.getString("username", ""); // "" is the default value if the username is not found
        TextView name = findViewById(R.id.name);
        TextView username = findViewById(R.id.username);
        TextView description = findViewById(R.id.description);
        TextView name2 = findViewById(R.id.name2);
        TextView username2 = findViewById(R.id.username2);
        TextView day = findViewById(R.id.day);
        TextView newsTitle = findViewById(R.id.news_title);

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

    // Method to perform the expanding animation
    private void animateBackgroundImage() {
        ImageView backgroundImg = findViewById(R.id.background_img);

        // Define the scale animation
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1f, 1.2f, // Start and end scale on x-axis
                1f, 1.2f, // Start and end scale on y-axis
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point (X-axis) - center
                Animation.RELATIVE_TO_SELF, 0.5f // Pivot point (Y-axis) - center
        );

        scaleAnimation.setDuration(500); // Duration of the animation in milliseconds
        scaleAnimation.setFillAfter(true); // Ensure the view stays at the end scale

        // Start the animation
        backgroundImg.startAnimation(scaleAnimation);
    }

    private void showProfilePictureDialog() {
        // Inflate the dialog layout
        View dialogView = getLayoutInflater().inflate(R.layout.profile_picture_dialog, null);

        // Create the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);

        // Get the enlarged ImageView from the dialog layout
        ImageView enlargedProfilePicture = dialogView.findViewById(R.id.enlarged_profile_picture);

        // Set the image for the enlarged ImageView (if needed)
        // For example:
        // enlargedProfilePicture.setImageResource(R.drawable.profile_picture);

        // Create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}