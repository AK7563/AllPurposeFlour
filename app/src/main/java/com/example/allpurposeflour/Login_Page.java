package com.example.allpurposeflour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.Arrays;

public class Login_Page extends AppCompatActivity {
    Button login_main_button;
    EditText login_main_email, login_main_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        login_main_button = findViewById(R.id.logIn_button);
        login_main_email = findViewById(R.id.logIn_email);
        login_main_password = findViewById(R.id.logIn_password);

        login_main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login_Page.this, MainActivity.class);
                startActivity(i);

                if (login_main_email.getText().toString().equals("ayy.kayy7563@gmail.com") &&
                        login_main_password.getText().toString().equals("240508")) {
                    i.putExtra("isLoggedIn", true);
                    startActivity(i);
                } else if (login_main_email.getText().toString().equals("admin@gmail.com") &&
                        login_main_password.getText().toString().equals("101010")) {
                    i.putExtra("isLoggedIn", true);
                    i.putExtra("index", 1);
                    startActivity(i);
                }
            }
        });
    }
}