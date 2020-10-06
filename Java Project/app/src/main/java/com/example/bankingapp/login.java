package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {

    private TextView here;
    private Button logInBtn;
    private EditText emailET,passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //On click listener for registration activity.
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

//    public boolean validate() {
//        boolean valid = true;
//
//        String email = emailET.getText().toString();
//        String password = passwordET.getText().toString();
//
//        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            emailET.setError("enter a valid email address");
//            valid = false;
//        } else {
//            emailET.setError(null);
//        }
//
//        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
//            passwordET.setError("between 4 and 10 alphanumeric characters");
//            valid = false;
//        } else {
//            passwordET.setError(null);
//        }
//
//        return valid;
//    }
}