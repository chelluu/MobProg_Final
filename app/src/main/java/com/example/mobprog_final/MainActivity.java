package com.example.mobprog_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.mobprog_final.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Start the LandingPage activity when needed
        Intent intentLanding = new Intent(MainActivity.this, LandingPage.class);
        startActivity(intentLanding);
    }


}
