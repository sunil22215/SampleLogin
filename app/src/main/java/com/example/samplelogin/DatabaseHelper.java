package com.example.samplelogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
public static  final String DATABASE_NAME = "Employee.db";
public static final String TABLE_NAME = "employee_table";
public static  final String COL_1 = "ID";
public static  final String COL_2 = "NAME";
public static  final String COL_3 = "MOBILE_NUMBER";
public static  final String COL_4 = "EMAIL";
public static  final String COL_5 = "PASSWORD";

    public DatabaseHelper(@Nullable Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE_NUMBER INTEGER,EMAIL TEXT,PASSWORD TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String name,String mobile_number,String email,String password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2,name);
        values.put(COL_3,mobile_number);
        values.put(COL_4,email);
        values.put(COL_5,password);
        long result=db.insert(TABLE_NAME,null,values);

        if (result==-1)
        return false;
        else
            return true;
    }

    public boolean checkuser(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from TABLE_NAME where name = ?", new String[]{email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean checkuserpass(String name, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from employee_table where NAME = '"+name+"' and PASSWORD = '"+password+"'";
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }


}
