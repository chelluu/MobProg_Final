package com.example.mobprog_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        Button loginButton = findViewById(R.id.LoginBtn);
        Button registerButton = findViewById(R.id.RegisterBtn);

        loginButton.setOnClickListener(view -> {
            Intent intent = new Intent(LandingPage.this, Login.class);
            startActivity(intent);
        });

        registerButton.setOnClickListener(view -> {
            Intent intent = new Intent(LandingPage.this, Register.class);
            startActivity(intent);
        });
    }
}
