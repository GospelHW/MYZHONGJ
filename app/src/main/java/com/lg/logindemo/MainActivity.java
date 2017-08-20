package com.lg.logindemo;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lg.logindemo.dbhelp.SqliteDB;
import com.lg.logindemo.serviecs.UserService;

public class MainActivity extends AppCompatActivity {
    private Button button;//登录按钮
    private EditText username;
    private EditText lgpwd;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login");
        button = (Button) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.username);
        lgpwd = (EditText) findViewById(R.id.lgpwd);
        context = this;
        /**
         * 登录按钮的点击事件
         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username != null && username.length() > 0) {
                    if (lgpwd != null && lgpwd.length() >= 6 && lgpwd.length() <= 20) {
                        UserService userServices = new UserService(context);
//                        boolean isTure = userServices.login(username.getText().toString(), lgpwd.getText().toString());
                        int isTure = SqliteDB.getInstance(getApplicationContext()).Quer(lgpwd.getText().toString(), username.getText().toString());
                        if (isTure == 1) {
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(context, PersonAcitvity.class));
                        } else if (isTure == 0) {
                            Toast.makeText(MainActivity.this, "This User is no Register!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "username is not null", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    /*注册*/
    public void register(View view) {
        startActivity(new Intent(this, RegisterAcitvity.class));
    }
}
