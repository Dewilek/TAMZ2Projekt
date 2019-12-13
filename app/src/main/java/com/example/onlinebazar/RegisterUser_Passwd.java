package com.example.onlinebazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterUser_Passwd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user__passwd);

        Button btn1 = (Button) findViewById(R.id.btn1);
        final EditText editText_password = (EditText) findViewById(R.id.editText_password);
        final EditText editText_passwordAgain = (EditText) findViewById(R.id.editText_passwordAgain);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String psswd1;
                String psswdA;
                psswd1 = editText_password.getText().toString();
                psswdA = editText_passwordAgain.getText().toString();
                if (psswd1.equals("") || psswdA.equals("") || psswd1.equals(psswdA) == false) {
                    Toast.makeText(RegisterUser_Passwd.this, "This is not correct password. Please try again.", Toast.LENGTH_SHORT).show();
                }/*
                if (){
                    Toast.makeText(RegisterUser_Passwd.this, "Password are not same. Please try again.", Toast.LENGTH_SHORT).show();

                }
                */
                else {
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivityForResult(intent,0);
                }
            }
        });

    }
}
