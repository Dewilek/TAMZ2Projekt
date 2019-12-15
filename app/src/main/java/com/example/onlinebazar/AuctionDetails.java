package com.example.onlinebazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AuctionDetails extends AppCompatActivity {

    private int IDs;
    private ConnectURL url = new ConnectURL();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auction_details);

        Bundle b = getIntent().getExtras();
        int position = b.getInt("com.example.onlinebazar.ITEM_INDEX");

        Resources res = getResources();

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);

        TextView textView_aName = (TextView) findViewById(R.id.textView_aName);
        TextView textView_abPrice = (TextView) findViewById(R.id.textView_abPrice);
        TextView textView_abPriceBlue = (TextView) findViewById(R.id.textView_abPriceBlue);
        TextView textView_abPriceGrey = (TextView) findViewById(R.id.textView_abPriceGrey);
        TextView textView_desc = (TextView) findViewById(R.id.textView_desc);

        String[] aNameDB = res.getStringArray(R.array.AuctionName);
        String[] abPriceDB = res.getStringArray(R.array.abPrices);
        String[] abPriceGDB = res.getStringArray(R.array.abPricesG);

        textView_aName.setText(aNameDB[position]);
        textView_abPrice.setText(abPriceDB[position]);
        textView_abPriceBlue.setText("Biggest bid: ");
        if (abPriceGDB[position].equals("NULL")) {
            textView_abPriceGrey.setText("CANNOT BID!");
        }
        else {
            textView_abPriceGrey.setText(abPriceGDB[position]);
        }



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+880217769));//change the number
                startActivity(callIntent);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //url.TryConenction();
        //textView_aName.setText(url.aName[1]);

    }
}
