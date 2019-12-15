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

public class CreateAuction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_auction);

        Bundle b = getIntent().getExtras();
        int position = b.getInt("com.example.onlinebazar.USER_INDEX");

        Resources res = getResources();
        String[] aNames = res.getStringArray(R.array.AuctionName);

        Button btn1 = (Button) findViewById(R.id.btn1);
        EditText editText_aName = (EditText) findViewById(R.id.editText_aName);
        EditText editText_abPrice = (EditText) findViewById(R.id.editText_abPrice);
        EditText editText_BidPrice = (EditText) findViewById(R.id.editText_BidPrice);
        EditText editText_desc = (EditText) findViewById(R.id.editText_desc);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 3
                // THIS NEEDS TO BE CHANGED IN ORDER IN THE FUTURE BECAUSE NOW IT IS NOT WORKING BCS OF STRINGS.XML
                int i = 0;
                if (editText_abPrice.getText().toString().equals("")) {
                    Toast.makeText(CreateAuction.this, "Auction Buyout price can not be empty.", Toast.LENGTH_SHORT).show();
                } else if (editText_BidPrice.getText().toString().equals("")) {
                    //TODO 4
                    // FOR FUTURE USE THIS SHOULD BE SET TO NULL SINCE YOU CAN HAVE ACTIONS CREATED WITHOUT BID = NOTBIDABLE AUCTIONS!
                    editText_BidPrice.setText("NULL");
                } else if (editText_desc.getText().toString().equals("")) {
                    Toast.makeText(CreateAuction.this, "Description can not be empty.", Toast.LENGTH_SHORT).show();}
                else if (editText_aName.getText().toString().equals("")) {
                    Toast.makeText(CreateAuction.this, "Auction name can not be empty.", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (i > aNames.length) {
                        i = 0;
                    }
                    while (i < aNames.length) {
                        if (!(aNames[i].equals(editText_aName.getText().toString()))) {
                            Intent intent = new Intent(getApplicationContext(), UserMainActivity.class);
                            intent.putExtra("com.example.onlinebazar.USER_INDEX", position);
                            startActivityForResult(intent, 0);
                            break;
                        }
                        else {
                            Toast.makeText(CreateAuction.this, "Name of this auction is already taken.", Toast.LENGTH_SHORT).show();
                            Log.d("HODNOTA Icka", "I je :" + i);
                            i++;
                        }
                    }

                }
            }
        });
    }
}
