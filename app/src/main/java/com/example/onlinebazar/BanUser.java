package com.example.onlinebazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BanUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban_user);

        Bundle b = getIntent().getExtras();
        int position = b.getInt("com.example.onlinebazar.USER_INDEX");

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 6
                // IN HERE SHOULD BE IMPLEMENTATION OF IFS OF BAN
                    Toast.makeText(BanUser.this, "You sucesfully ban the user!", Toast.LENGTH_SHORT).show();
                    Intent startIntent = new Intent(getApplicationContext(),UserArrays.class);
                    startActivityForResult(startIntent, 0);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BanUser.this, "Canceled!", Toast.LENGTH_SHORT).show();
                Intent showDetailActivity = new Intent(getApplicationContext(), UserDetails.class);
                showDetailActivity.putExtra("com.example.onlinebazar.ITEM_INDEX",position);
                startActivity(showDetailActivity);
                Log.d("KLIKL NA AUKCI","Vratil si se na aukci s id: " + position);
            }
        });




    }
}
