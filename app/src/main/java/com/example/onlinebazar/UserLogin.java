package com.example.onlinebazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        Button btn1 = (Button) findViewById(R.id.btn1);
        final EditText editText_login = (EditText) findViewById(R.id.editText_login);
        final EditText editText_password = (EditText) findViewById(R.id.editText_password);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login;
                String passwd;
                login = editText_login.getText().toString();
                passwd = editText_password.getText().toString();
                if (login.equals("") || passwd.equals("")) {
                    Toast.makeText(UserLogin.this, "This is not correct combination of password and login. Please try again.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), ActionArrays.class);
                    startActivityForResult(intent, 0);
                }
            }
        });
    }
}
