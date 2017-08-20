package com.lg.logindemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lg.logindemo.dbhelp.SqliteDB;
import com.lg.logindemo.model.User;
import com.lg.logindemo.serviecs.UserService;

public class RegisterAcitvity extends AppCompatActivity {
    Context context;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_acitvity);
        setTitle("Register");
        button = (Button) findViewById(R.id.register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserService userServices = new UserService(context);
                User user = new User();
                user.setuName("Gospel");
                user.setuAge("30");
                user.setuPhone("15210769058");
                user.setuPwd("111111");
                user.setuSex("0");//0女1男
                user.setuAddress("北京市朝阳区金兴路一号院");
//                boolean isTure = userServices.register(user);
                int isTure = SqliteDB.getInstance(getApplicationContext()).saveUser(user);
                if (isTure == 1) {
                    Toast.makeText(RegisterAcitvity.this, "Register Successful", Toast.LENGTH_SHORT).show();
                } else if (isTure == -1) {
                    Toast.makeText(RegisterAcitvity.this, "this user is Registered", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterAcitvity.this, "Register Failed", Toast.LENGTH_SHORT).show();
                }
//                Toast.makeText(RegisterAcitvity.this, "Create Success ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
