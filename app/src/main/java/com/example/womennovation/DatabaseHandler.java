package com.example.womennovation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String DATABASE = "myList.db";
    public static final String TABLE = "myList_data";
    public static final String col1 = "username";
    public static final String col2 = "password";
    public static final String col3 = "age";
    public static final String col4 = "city";
    public static final String col5 = "state";
    public static final String col6 = "contact1";
    public static final String col7 = "contact2";
    public static final String col8 = "contact3";
    public static final String col9 = "pin";

    public DatabaseHandler(Context context){
        super(context,DATABASE,null,1);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String createTable = "CREATE TABLE "+TABLE+"(username TEXT PRIMARY KEY,password TEXT ,age INTEGER , city TEXT,state TEXT , contact1 BIGINT ,contact2 BIGINT ,contact3 BIGINT ,pin INTEGER )";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //onupgrade
    public boolean addData(String name,String password,int age,String city,String state,long ph1,long ph2,long ph3,int pin){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col1,name);
        cv.put(col2,password);
        cv.put(col3,age);
        cv.put(col4,city);
        cv.put(col5,state);
        cv.put(col6,ph1);
        cv.put(col7,ph2);
        cv.put(col8,ph3);
        cv.put(col9,pin);
        long result = db.insert(TABLE,null,cv);
        if (result== -1){
            return false;
        }
        else{
            return true;
        }
    }
    public Cursor getListContents(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM  "+TABLE,null);
        return data;
    }



}
