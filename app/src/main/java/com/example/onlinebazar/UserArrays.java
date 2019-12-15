package com.example.onlinebazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class UserArrays extends AppCompatActivity {

    ListView myListView;
    String[] fName;
    String[] lName;
    String[] email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_arrays);


        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.ListView_uactions);
        fName = res.getStringArray(R.array.fName);
        lName = res.getStringArray(R.array.lName);
        email = res.getStringArray(R.array.emails);


        UserAdapter userAdapter = new UserAdapter(this,fName,lName,email);
        myListView.setAdapter(userAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDetailActivity = new Intent(getApplicationContext(), UserDetails.class);
                showDetailActivity.putExtra("com.example.onlinebazar.ITEM_INDEX",position);
                startActivity(showDetailActivity);
                Log.d("KLIKL NA AUKCI","KLIKL JSI NA AUKCI S POSTION" + position);
            }
        });
    }
}
