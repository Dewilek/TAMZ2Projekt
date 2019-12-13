package com.example.onlinebazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btn1 = (Button) findViewById(R.id.btn3);
        Button btn2 = (Button) findViewById(R.id.btn2);

       btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),UserLogin.class);
                //startIntent.putExtra("com.example.onlinebazar.AUKCE", true);
                startActivityForResult(startIntent,0);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent2 = new Intent(v.getContext(), RegisterUser.class);
                //startIntent2.putExtra("com.example.onlinebazar.AUKCE",true);
                startActivityForResult(startIntent2,0);

            }
        });


    }
}
