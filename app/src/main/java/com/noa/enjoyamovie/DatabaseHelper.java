package com.noa.enjoyamovie;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table orders(username varchar(20),id varchar(20),password varchar(20),wayOfPayment varchar(20))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table if exists orders");
        onCreate(db);
    }

    public long saveNewData(String username, String id, String password, String wayOfPayment,String movieDate, String movieTime,String sumMoney)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("username",username);
        cv.put("id",id);
        cv.put("password",password);
        cv.put("wayOfPayment",wayOfPayment);
        cv.put("date",movieDate);
        cv.put("time",movieTime);
        cv.put("sum",sumMoney);
        long recordId=db.insert("orders",null,cv);
        return recordId;
    }
}
