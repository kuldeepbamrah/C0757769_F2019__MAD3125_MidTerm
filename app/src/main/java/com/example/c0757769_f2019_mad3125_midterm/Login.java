package com.example.c0757769_f2019_mad3125_midterm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener
{
    ActionBar actionBar;
    EditText email,password;
    TextView login_btn;
    String uName,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        actionBar = getSupportActionBar();
        //actionBar.hide();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        login_btn = findViewById(R.id.login_btn);

        login_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.login_btn:
                uName = email.getText().toString();
                pass = password.getText().toString();

                if(uName.equalsIgnoreCase("Kuldeep") && pass.equalsIgnoreCase("1234"))
                {
                    Intent intent = new Intent(this,MainActivity.class);
                    startActivity(intent);
                }else
                Toast.makeText(Login.this,"Login", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
