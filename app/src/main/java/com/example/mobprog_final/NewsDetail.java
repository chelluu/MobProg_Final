package com.example.mobprog_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String source = intent.getStringExtra("source");
//        String publishedDate = intent.getStringExtra("publishedDate");
        String imageUrl = intent.getStringExtra("imageUrl");
        String content = intent.getStringExtra("content");

        TextView titleTextView = findViewById(R.id.article_title);
        TextView sourceTextView = findViewById(R.id.article_source);
//        TextView dateTextView = findViewById(R.id.news_date);
        TextView contentTextView = findViewById(R.id.news_content);

        titleTextView.setText(title);
        sourceTextView.setText(source);
//        dateTextView.setText(publishedDate);
        contentTextView.setText(content);

        ImageView imageView = findViewById(R.id.article_image_view);

        if (imageUrl != null) {
            Picasso.get().load(imageUrl)
                    .error(R.drawable.baseline_image_not_supported_24)
                    .placeholder(R.drawable.baseline_image_not_supported_24)
                    .into(imageView);
        }


    }
}