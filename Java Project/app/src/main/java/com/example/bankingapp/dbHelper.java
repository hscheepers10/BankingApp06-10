package com.example.bankingapp;
//Thanx to ProgrammingKnowledge video source : https://www.youtube.com/watch?v=p8TaTgr4uKM

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    //VARIABLES.
    public static final String DATABASE_NAME ="bankUsrDB";
    public static final String TABLE_NAME ="usrDb";
    public static final String COL_1 ="email";
    public static final String COL_2 ="name";
    public static final String COL_3 ="surname";
    public static final String COL_4 ="mobile";
    public static final String COL_5 ="password";

    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null,1);
        SQLiteDatabase sqlDb = this.getWritableDatabase();
    }

    //Oncreate method.
    @Override
    public void onCreate(SQLiteDatabase sqlDb) {
        sqlDb.execSQL("create table "
                + TABLE_NAME + "(email STRING PRIMARY KEY, name TEXT, surname TEXT, mobile INTEGER, password STRING)");
    }

    //Onupgrade Method.
    @Override
    public void onUpgrade(SQLiteDatabase sqlDb, int i, int i1) {
        sqlDb.execSQL("DROP table if exists "+TABLE_NAME);
        onCreate(sqlDb);
    }

    //Inserting data.
    public void addData(String email,String name,String surname, String mobile, String password){
        SQLiteDatabase sqlDb = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1,email);
        cv.put(COL_2,name);
        cv.put(COL_3,surname);
        cv.put(COL_4,mobile);
        cv.put(COL_5,password);
        long rs = sqlDb.insert(TABLE_NAME,null,cv);
    }
}
