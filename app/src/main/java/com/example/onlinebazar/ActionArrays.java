package com.example.onlinebazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ActionArrays extends AppCompatActivity {

    ListView myListView;
    String[] items;
    String[] desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_arrays);



        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.ListView_actions);
        items = res.getStringArray(R.array.AuctionName);
        desc = res.getStringArray(R.array.AuctionDesc);


        ItemAdapter itemAdapter = new ItemAdapter(this,items,desc);
        myListView.setAdapter(itemAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDetailActivity = new Intent(getApplicationContext(), AuctionDetails.class);
                showDetailActivity.putExtra("com.example.onlinebazar.ITEM_INDEX",position);
                startActivity(showDetailActivity);
                Log.d("KLIKL NA AUKCI","KLIKL JSI NA AUKCI S POSTION" + position);
            }
        });


    }
}
