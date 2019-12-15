package com.example.onlinebazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        Bundle b = getIntent().getExtras();
        int position = b.getInt("com.example.onlinebazar.ITEM_INDEX");

        Resources res = getResources();

        String[] fName = res.getStringArray(R.array.fName);
        String[] lName = res.getStringArray(R.array.lName);
        String[] email = res.getStringArray(R.array.emails);
        String[] city = res.getStringArray(R.array.City);
        String[] street = res.getStringArray(R.array.Street);
        String[] postal = res.getStringArray(R.array.Postal);
        String[] phones = res.getStringArray(R.array.phones);

        TextView editText_fName = (TextView) findViewById(R.id.textView_fNameGrey);
        TextView editText_lName = (TextView) findViewById(R.id.textView_lNameGrey);
        TextView editText_email = (TextView) findViewById(R.id.textView_emailGrey);
        TextView editText_City = (TextView) findViewById(R.id.textView_cityGrey);
        TextView editText_street = (TextView) findViewById(R.id.textView_streetGrey);
        TextView editText_postalCode = (TextView) findViewById(R.id.textView_postalCodeGrey);
        TextView editText_phoneNumber = (TextView) findViewById(R.id.textView_phoneGrey);
        Button btn1 = (Button) findViewById(R.id.btn1);

        editText_fName.setText(fName[position]);
        editText_lName.setText(lName[position]);
        editText_email.setText(email[position]);
        editText_City.setText(city[position]);
        editText_street.setText(street[position]);
        editText_postalCode.setText(postal[position]);
        editText_phoneNumber.setText(phones[position]);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 5
                // AFTER DB IMPLEMENTATION IS WORKING, THIS NEEDS TO BE CHANGED, TO CHECK ACUTIONS/BIDS AND THEN BAN/DISABLE ACCOUNT
                Intent intent = new Intent(getApplicationContext(), BanUser.class);
                intent.putExtra("com.example.onlinebazar.USER_INDEX",position);
                startActivityForResult(intent, 0);
            }
        });

    }
}
