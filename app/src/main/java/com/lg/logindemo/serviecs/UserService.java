package com.lg.logindemo.serviecs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lg.logindemo.dbhelp.DatabaseHelper;
import com.lg.logindemo.model.User;

/**
 * Created by sunyi on 2017/8/18.
 */

public class UserService {
    private DatabaseHelper dbHelper;

    public UserService(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    //登录用
    public boolean login(String username, String password) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "select * from user where username=? and password=?";
        Cursor cursor = sdb.rawQuery(sql, new String[]{username, password});
        if (cursor.moveToFirst() == true) {
            cursor.close();
            return true;
        }
        return false;
    }

    //注册用
    public boolean register(User user) {
        SQLiteDatabase sdb= dbHelper.getWritableDatabase();
//        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "insert into user(username,password,age,sex,phone,address) values(?,?,?,?,?,?)";
        Object obj[] = {user.getuName(), user.getuPwd(), user.getuAge(), user.getuSex()};
        sdb.execSQL(sql, obj);
        return true;
    }
}
