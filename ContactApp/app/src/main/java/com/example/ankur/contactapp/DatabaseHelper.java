package com.example.ankur.contactapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by ankur on 10/2/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper mInstance = null;

    public DatabaseHelper(Context context) {
        //super(context, databaseName, cursorFactory, dbVersion);
        super(context, "ContactAppdb.sqlite", null, 1);

    }

    public static DatabaseHelper getInstance(Context ctx) {

        if (mInstance == null) {
            mInstance = new DatabaseHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "create table sms(name text, date text, otp text, contact_id integer primary key);"; //auto_increment
        db.execSQL(query);
        Log.e("Database", "DB created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public ArrayList<Sms> getSms(){
        ArrayList<Sms> smsArrayList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from sms", null);
        while (cursor.moveToNext() == true){
            String name = cursor.getString(0);
            String date = cursor.getString(1);
            String otp = cursor.getString(2);
            int id = cursor.getInt(3);
            smsArrayList.add(new Sms(name, date, otp, id));
        }
        cursor.close();
        db.close();
        // fetch data from members table
        // open database and fetch
        return smsArrayList;
    }

    public boolean saveSms(Sms sms){
        // store column name and corresponding values
        ContentValues cv = new ContentValues();
        cv.put("name", sms.getName());
        cv.put("date", sms.getDate());
        cv.put("otp", sms.getOtp());
        // execute insert query with values from CV
        SQLiteDatabase db = getWritableDatabase();
        long r = db.insert("sms", null, cv);
        db.close();
        if(r != -1)
            return true;
        else return false;

    }
}
