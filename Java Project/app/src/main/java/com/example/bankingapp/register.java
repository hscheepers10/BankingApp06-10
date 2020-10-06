package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {

    private TextView here;
    private Button createAcc;
    private RadioGroup radGroup1;
    private RadioButton radioButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //Onclick listener returns to Login Page.
        here = (TextView) findViewById(R.id.logHereTV);
        here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //////////////REGISTER ACTIVITY ////////////
        createAcc = (Button) findViewById(R.id.createAccBtn);
        radGroup1 = (RadioGroup)findViewById(R.id.radGroup);
        createAcc.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                EditText fNameEt = findViewById(R.id.fNameET);
                EditText lNameEt = findViewById(R.id.lNameET4);
                EditText emailEt = findViewById(R.id.eMailRegET);
                EditText passwordEt = findViewById(R.id.passwordRegET);
                EditText mobileEt = findViewById(R.id.mobileET);

                String fName = fNameEt.getText().toString().trim();
                String lName = lNameEt.getText().toString().trim();
                String emailReg = emailEt.getText().toString().trim();
                String passwordReg = passwordEt.getText().toString().trim();
                String mobile = mobileEt.getText().toString().trim();


                int radGrpId = radGroup1.getCheckedRadioButtonId();
                radioButton1 = (RadioButton)findViewById(radGrpId);


                if (passwordReg.isEmpty() || emailReg.isEmpty() || fName.isEmpty() || lName.isEmpty() || mobile.isEmpty()){
                    Toast emptyToast = Toast.makeText(getApplicationContext(),"Empty fields",Toast.LENGTH_SHORT);
                    emptyToast.show();
                }

                else if (passwordReg.length()<5 || !Patterns.EMAIL_ADDRESS.matcher(emailReg).matches()){
                    Toast incorrectToast = Toast.makeText(getApplicationContext(),"incorrect fields",Toast.LENGTH_SHORT);
                    incorrectToast.show();
                }

                else{
                    Toast loggedInToast = Toast.makeText(getApplicationContext(),"all good and radioButton is:",Toast.LENGTH_SHORT);
                    loggedInToast.show();

                    //Intent.

                }
            }
        });

    }
}