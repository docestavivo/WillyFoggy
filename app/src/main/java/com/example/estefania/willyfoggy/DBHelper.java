package com.example.estefania.willyfoggy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper  extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("BBDD","Ha entrado en la bbdd");
        db.execSQL("create table usuarios(codigo integer primary key,usuario text,contrasena text)");
        db.execSQL("insert into usuarios values(01,'admin','admin')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("BBDD","Ha actualizado la bbdd");
        db.execSQL("create table usuarios(codigo integer primary key,usuario text,contrasena text)");
        db.execSQL("insert into usuarios values(01,'admin','admin')");
    }
}
