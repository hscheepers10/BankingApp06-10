package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class transfer extends AppCompatActivity {


    //declare widgets
    Button transfer;
    TextView current,savings;
    Spinner transferoption;
    EditText transferamount;
    dbHelper sqliteHelper;
    Double transfer_amount,currentbalance,savingsbalance,newcurrentbalance,newsavingsbalance;
    String newcurbal,newsavbal;
    int spinnerchoice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transfer);


    }
}