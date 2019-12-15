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

public class BidOnItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_on_item);

        Bundle b = getIntent().getExtras();
        String neededM = b.getString("com.example.onlinebazar.BID_AMOUNT");
        int position = b.getInt("com.example.onlinebazar.POSITION");

        Resources res = getResources();

        EditText editText_Amount = (EditText) findViewById(R.id.editText_Amount);
        Button btn1 = (Button) findViewById(R.id.btn1);




        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String tmp = editText_Amount.getText().toString();

            int convertedTmp = Integer.parseInt(tmp);
            int convertedNeededM = Integer.parseInt(neededM);

            if ( convertedNeededM > convertedTmp) {
                Toast.makeText(BidOnItem.this, "The actual top bid is greated then you added. Please increase the amount.", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(BidOnItem.this, "Succesfully commited.", Toast.LENGTH_SHORT).show();
                Intent showDetailActivity = new Intent(getApplicationContext(), AuctionDetails.class);
                showDetailActivity.putExtra("com.example.onlinebazar.ITEM_INDEX",position);
                startActivity(showDetailActivity);
                Log.d("KLIKL NA AUKCI","KLIKL JSI NA AUKCI S POSTION" + position);


                //TODO 1
                //HERE SHOULD BE CODE FOR UPDATING THE DB TO CHANGE THE MAX VALUE, BUT SINCE STRINGS.XML CANNOT BE CHANGES THIS IS NOT IMPLEMENTED!!!
            }
            }
        });
    }
}
