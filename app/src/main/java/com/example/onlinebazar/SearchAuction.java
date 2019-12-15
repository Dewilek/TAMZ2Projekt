package com.example.onlinebazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SearchAuction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_auction);

        Bundle b = getIntent().getExtras();
        int position = b.getInt("com.example.onlinebazar.USER_INDEX");

        Resources res = getResources();

        EditText editText_aName = (EditText) findViewById(R.id.editText_aName);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);

        String[] aNames = res.getStringArray(R.array.AuctionName);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                if (editText_aName.getText().toString().equals("")) {
                    Toast.makeText(SearchAuction.this, "Search Name can not be empty.", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (i > aNames.length) {i = 0;}
                    while (i < aNames.length)
                    {
                        if (aNames[i].equals(editText_aName.getText().toString()))
                        {
                            Intent showDetailActivity = new Intent(getApplicationContext(), AuctionDetails.class);
                            showDetailActivity.putExtra("com.example.onlinebazar.ITEM_INDEX", i);
                            startActivity(showDetailActivity);
                            Log.d("UKAZ MI CO SEARCH DELA","DELAM TOHLE id :" + i);
                            break;
                        }
                        else
                        {
                            Toast.makeText(SearchAuction.this, "Auction with such name dont exists!", Toast.LENGTH_SHORT).show();
                            i++;
                            Log.d("HODNOTA Icka", "I je :" + i);
                        }
                    }

                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserMainActivity.class);
                intent.putExtra("com.example.onlinebazar.USER_INDEX",position);
                startActivityForResult(intent, 0);
            }
        });
    }
}
