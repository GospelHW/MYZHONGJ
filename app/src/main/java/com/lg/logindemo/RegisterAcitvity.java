package com.lg.logindemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
                boolean isTure = userServices.login(username.getText().toString(), lgpwd.getText().toString());

                if (isTure) {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(RegisterAcitvity.this, "Create Success ", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
