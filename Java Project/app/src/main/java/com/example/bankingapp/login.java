package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login extends AppCompatActivity {

    private TextView here;
    private Button logInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        here = (TextView)findViewById(R.id.regHereTV);
        here.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent hereIntent = new Intent(login.this,register.class);
                startActivity(hereIntent);
            }
        });

        logInBtn = (Button)findViewById(R.id.loginBtn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logInIntent = new Intent(login.this,home.class);
                startActivity(logInIntent);
            }
        });
    }
}