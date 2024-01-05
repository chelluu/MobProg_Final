package com.example.mobprog_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        Button LoginButton = findViewById(R.id.LoginBtn2);
        EditText usernameTxt = findViewById(R.id.Username);
        TextView lblError = findViewById(R.id.lblError);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usernameTxt.getText().toString().isEmpty()){
                    lblError.setText("Enter your username!");
                    return;
                }
                else if (usernameTxt.getText().toString().length() < 5){
                    lblError.setText("Username must be greater than 5");
                    return;
                }
                else {
                    SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", usernameTxt.getText().toString()); // Replace enteredUsername with the actual username entered during login
                    editor.apply();
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                }
            }
        });
    }
}