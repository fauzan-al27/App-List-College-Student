package com.example.uas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btn_login = (Button) findViewById(R.id.btn_login);
        
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String userameKey = username.getText().toString();
                    String passwordKey = password.getText().toString();

                    if (userameKey.equals("admin") && passwordKey.equals("admin")) {
                        Toast.makeText(getApplicationContext(), "Login Succes", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this,Home.class);
                        Login.this.startActivity(intent);
                        finish();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                        builder.setMessage("Username or Password is wrong!").setNegativeButton("Retry",null
                        ).create().show();
                    }
            }
        });

        // get no action-bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}