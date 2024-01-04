package com.example.mobprog_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class NotifActivity extends AppCompatActivity {

    RecyclerView notif_recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Notifications");
        actionBar.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_ios_24);

        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        NotifModel[] notif_data = new NotifModel[]{
                new NotifModel("New article from NNC Indonesia", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.user),
                new NotifModel("Popular article from #Finance", "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", R.drawable.hashtag)
        };

        notif_recycler_view = findViewById(R.id.recycler_view_notif);

        NotifAdapter notifAdapter = new NotifAdapter(notif_data);

        notif_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        notif_recycler_view.setAdapter(notifAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}