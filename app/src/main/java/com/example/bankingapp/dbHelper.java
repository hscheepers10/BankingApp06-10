package com.example.bankingapp;
//Thanx to ProgrammingKnowledge video source : https://www.youtube.com/watch?v=p8TaTgr4uKM

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    //VARIABLES.
    public static final String DATABASE_NAME ="bankUsrDB";
    public static final String TABLE_NAME ="usrDb";
    public static final String KEY_ID ="id";
    public static final String COL_NAM ="name";
    public static final String COL_SUR ="surname";
    public static final String COL_EMA ="email";
    public static final String COL_PAS ="password";
    public static final String COL_MOB ="mobile";
    public static final String COL_GEN = "gender";
    public static final String COL_CUR ="curBal";
    public static final String COL_SAV ="savBal";

    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null,1);
        SQLiteDatabase sqlDb = this.getWritableDatabase();
    }

    //Oncreate method.
    @Override
    public void onCreate(SQLiteDatabase sqlDb) {
        sqlDb.execSQL("create table "
                + TABLE_NAME + "(KEY_ID STRING PRIMARY KEY, name TEXT, surname TEXT,email STRING, password STRING," +
                " mobile INTEGER, gender TEXT, curBal INTEGER, savBal INTEGER)");

    }

    //Onupgrade Method.
    @Override
    public void onUpgrade(SQLiteDatabase sqlDb, int i, int i1) {
        sqlDb.execSQL("DROP table if exists "+TABLE_NAME);
        onCreate(sqlDb);
    }

    //Inserting data.
    public void addData(userDetails user){
        SQLiteDatabase sqlDb = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_ID,user.id);
        cv.put(COL_NAM,user.name);
        cv.put(COL_SUR,user.surname);
        cv.put(COL_EMA,user.email);
        cv.put(COL_PAS,user.password);
        cv.put(COL_MOB,user.mobile);
        cv.put(COL_GEN,user.gender);
        cv.put(COL_CUR,user.curBal);
        cv.put(COL_SAV,user.savBal);
        long rs = sqlDb.insert(TABLE_NAME,null,cv);
    }

    //using this method we can update the balance of the current or savings account
    public void updateBalance (userDetails user){
        //get writable database
        SQLiteDatabase sqlDb = this.getWritableDatabase();
        //create content values to insert
        ContentValues cv = new ContentValues();
        cv.put(COL_CUR,user.curBal);
        //Put savings in @values
        cv.put(COL_SAV, user.savBal);
        String whereClause = COL_EMA + "=?";
        String whereArgs[] = {user.email};
        // update row long
        long rs = sqlDb.update(TABLE_NAME, cv, whereClause,whereArgs);
    }

    //Authenticating user account.
    public userDetails Authenticate(userDetails user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                // Selecting Table
                new String[]{KEY_ID, COL_NAM, COL_SUR, COL_EMA, COL_PAS, COL_MOB, COL_GEN, COL_CUR, COL_SAV},
                // Selecting columns want to query
                COL_EMA + "=?", new String[]{user.email},
                // Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {

            //if cursor has value then in user database there is user associated with this given email
            userDetails user1 = new userDetails(cursor.getString(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                    cursor.getString(7), cursor.getString(8));

            // Match both passwords check they are same or not
            if (user.password.equalsIgnoreCase(user1.password)) {
                return user1;
            }
                //return
                cursor.getString(9);
        }
        //if user password does not matches or there is no record with that email then return @false
        return null;
    }

    //Fetching user data.
    public userDetails getData(userDetails user){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                // Selecting Table
                new String[]{KEY_ID, COL_NAM, COL_SUR, COL_EMA, COL_PAS, COL_MOB, COL_GEN, COL_CUR, COL_SAV},
                // Selecting columns want to query
                COL_EMA + "=?", new String[]{user.email},
                // Where clause
                null, null, null);
        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0){
            userDetails user1 = new userDetails(cursor.getString(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                    cursor.getString(7), cursor.getString(8));
            return user1;
        }
        return null;
    }

    //User not found.
    public boolean emailExists(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                // Selecting Table
                new String[]{KEY_ID, COL_NAM, COL_SUR, COL_EMA, COL_PAS, COL_MOB, COL_GEN, COL_CUR, COL_SAV},
                // Selecting columns want to query
                COL_EMA + "=?", new String[]{email},
                // Where clause
                null, null, null);

        if(cursor!= null && cursor.moveToFirst() && cursor.getCount() >0){
            return true;
        }
        return false;
    }

//    //Retrieving data.
//    public Cursor getData(SQLiteDatabase sqlDb){
//        String[] values = {KEY_ID,COL_NAM,COL_SUR,COL_EMA,COL_PAS,COL_MOB,COL_GEN,COL_CUR,COL_SAV};
//        Cursor cr = sqlDb.query(dbHelper.TABLE_NAME,values,null,null,null,null,null);
//        return cr;
//    }
}
