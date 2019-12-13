package com.example.onlinebazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegisterUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);


        Button button_sentForm = (Button) findViewById(R.id.button_sentForm);

        button_sentForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (false){
                    Toast.makeText(RegisterUser.this, "Error, something went wrong", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent startIntent = new Intent(getApplicationContext(),RegisterUser_Passwd.class);
                    //startIntent.putExtra("com.example.onlinebazar.AUKCE", true);
                    startActivityForResult(startIntent,0);
                }
            }
        });
    }
}
