package com.example.bankingapp;
//Thanx to ProgrammingKnowledge video source : https://www.youtube.com/watch?v=p8TaTgr4uKM

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    //VARIABLES.
    public static final String DATABASE_NAME ="bankUsrDB";
    public static final String TABLE_NAME ="usr";
    public static final String COL_3 ="email";
    public static final String COL_1 ="name";
    public static final String COL_2 ="surname";
    public static final String COL_4 ="mobile";
    public static final String COL_5 ="password";
    public static final String COL_6 ="gender";
    public static final String COL_7 ="curBal";
    public static final String COL_8 ="savBal";


    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null,1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "
                + TABLE_NAME + "(email STRING PRIMARY KEY, name TEXT, surname TEXT, mobile INTEGER, password STRING, gender CHAR, curBal INTEGER, savBal INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
