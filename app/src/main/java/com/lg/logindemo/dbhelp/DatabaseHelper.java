package com.lg.logindemo.dbhelp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sunyi on 2017/8/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    static String name="user.db";
    static int dbVersion=1;
    public DatabaseHelper(Context context) {
        super(context, name, null, dbVersion);
    }
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                      int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table user(id integer primary key autoincrement,username varchar(20),password varchar(20),age integer,sex varchar(2),phone varchar(20),address varchar(200))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
