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

public class RegisterUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        Resources res = getResources();

        Button button_sentForm = (Button) findViewById(R.id.button_sentForm);
        EditText editText_fName = (EditText) findViewById(R.id.editText_fName);
        EditText editText_lName = (EditText) findViewById(R.id.editText_lName);
        EditText editText_email = (EditText) findViewById(R.id.editText_email);
        EditText editText_City = (EditText) findViewById(R.id.editText_City);
        EditText editText_street = (EditText) findViewById(R.id.editText_street);
        EditText editText_postalCode = (EditText) findViewById(R.id.editText_postalCode);
        EditText editText_phoneNumber = (EditText) findViewById(R.id.editText_phoneNumber);

        String[] emailchecker;
        String[] phonechecker;
        emailchecker = res.getStringArray(R.array.emails);
        phonechecker = res.getStringArray(R.array.emails);



        button_sentForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                int j = 0;
                if (editText_fName.getText().toString().equals("")){
                    Toast.makeText(RegisterUser.this, "First name can not be empty.", Toast.LENGTH_SHORT).show();}
                else if (editText_lName.getText().toString().equals("")) {
                    Toast.makeText(RegisterUser.this, "Last name can not be empty.", Toast.LENGTH_SHORT).show(); }
                else if (editText_email.getText().toString().equals("")) {
                    Toast.makeText(RegisterUser.this, "Email name can not be empty.", Toast.LENGTH_SHORT).show();}

                else if (editText_City.getText().toString().equals("")) {
                    Toast.makeText(RegisterUser.this, "City name can not be empty.", Toast.LENGTH_SHORT).show(); }
                else if (editText_street.getText().toString().equals("")) {
                    Toast.makeText(RegisterUser.this, "Street name can not be empty.", Toast.LENGTH_SHORT).show(); }
                else if (editText_postalCode.getText().toString().equals("")) {
                    Toast.makeText(RegisterUser.this, "Postal code can not be empty.", Toast.LENGTH_SHORT).show(); }
                else if (editText_postalCode.getText().toString().length() != 5) {
                    Toast.makeText(RegisterUser.this, "Postal code MUST have 5 characters!.", Toast.LENGTH_SHORT).show(); }
                else if (editText_phoneNumber.getText().toString().equals("")) {
                    Toast.makeText(RegisterUser.this, "Phone number can not be empty.", Toast.LENGTH_SHORT).show(); }
                else if (editText_phoneNumber.getText().toString().length() != 9){
                    Toast.makeText(RegisterUser.this, "Phone number MUST have 9 characters.", Toast.LENGTH_SHORT).show(); }
                else {
                if (i > emailchecker.length /*|| j > phonechecker.length*/) {
                    i = 0;
                    j = 0;
                }
                while (i < emailchecker.length /*|| j < phonechecker.length*/) {
                    if (emailchecker[i].equals((editText_email.getText().toString()))) {
                        Toast.makeText(RegisterUser.this, "Email is already used, use different one or login with it!", Toast.LENGTH_SHORT).show();
                        Log.d("HODNOTA Icka", "I je :" + i);
                        i++;
                        break;
                    }
                    /*else if (phonechecker[j].equals((editText_phoneNumber.getText().toString()))) {
                        Toast.makeText(RegisterUser.this, "Phone Number is already used, use different one or login with it!", Toast.LENGTH_SHORT).show();
                        Log.d("HODNOTA Icka", "I je :" + i);
                        break;
                    }

                     */
                    else {
                        Intent startIntent = new Intent(getApplicationContext(), RegisterUser_Passwd.class);
                        //startIntent.putExtra("com.example.onlinebazar.AUKCE", true);
                        startActivityForResult(startIntent, 0);
                    }
                }
                }
            }
        });
    }
}
