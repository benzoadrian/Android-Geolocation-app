package com.example.currentplacedetailsonmap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userinterests.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table userDetails(goal TEXT primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists userdetails");
    }



    public boolean insertuserdata(String goal) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("goal", goal);

        long result = DB.insert("Userdetails",null, contentValues );
        if(result==-1) {
            return false;

        }
        else return true;


    }
    // aici caut cat sa selectez din tabel! "Select goal from Userdetails ORDER BY RANDOM() LIMIT 1"
    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;





    }

    public Cursor getdatarandom() {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor2 = DB.rawQuery("Select goal from Userdetails ORDER BY RANDOM() LIMIT 1", null);
        return cursor2;





    }



}
