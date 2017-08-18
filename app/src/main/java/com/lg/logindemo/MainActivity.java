package com.lg.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;//登录按钮
    private  EditText username;
    private EditText lgpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login");
        button=(Button)findViewById(R.id.login);
        username = (EditText)findViewById(R.id.username);
        lgpwd= (EditText) findViewById(R.id.lgpwd);

        /**
         * 登录按钮的点击事件
         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //用户名非空验证
//                if(username==null || username.length()<=0){
//                    Toast.makeText(MainActivity.this,"username is not null",Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                //密码非空验证
//                if else(lgpwd!=null && lgpwd.length()>=6 && lgpwd.length()<=20){
//                    Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
//                    return;
//                } else{
//
//                    Toast.makeText(MainActivity.this,"密码错误！",Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    //登录成功，跳转到主页
//                    Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
//                }
                if (username!=null && username.length()>0) {
                    if (lgpwd!=null && lgpwd.length()>=6 && lgpwd.length()<=20) {
                        Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this,"密码错误，请重新输入",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this,"username is not null",Toast.LENGTH_SHORT).show();
                 return;
                }
            }
        });
    }

    /*注册*/
    public void register(View view){
        startActivity(new Intent(this,RegisterAcitvity.class));
    }
}
