package com.example.onlinebazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BuyoutOnItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyout_on_item);

        Bundle b = getIntent().getExtras();
        String neededM = b.getString("com.example.onlinebazar.BID_AMOUNT");
        int position = b.getInt("com.example.onlinebazar.POSITION");

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tmp = "1000000000";

                int convertedTmp = Integer.parseInt(tmp);
                int convertedNeededM = Integer.parseInt(neededM);

                if (convertedNeededM < convertedTmp){
                    //TODO 2
                    //IMPLEMENTATION OF BUYOUT THE AUCTION, DELETING THE AUCTION FROM DB ETC. IS NOT IMPLEMENTED BCS OF STRINGS.XML
                Toast.makeText(BuyoutOnItem.this, "You sucesfully bouyout the auction!", Toast.LENGTH_SHORT).show();
                Intent startIntent = new Intent(getApplicationContext(), ActionArrays.class);
                startActivityForResult(startIntent, 0);
                }
                else {
                    Toast.makeText(BuyoutOnItem.this, "You dont have enough money!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BuyoutOnItem.this, "Canceled!", Toast.LENGTH_SHORT).show();
                Intent showDetailActivity = new Intent(getApplicationContext(), AuctionDetails.class);
                showDetailActivity.putExtra("com.example.onlinebazar.ITEM_INDEX",position);
                startActivity(showDetailActivity);
                Log.d("KLIKL NA AUKCI","Vratil si se na aukci s id: " + position);
            }
        });
    }
}
