package com.example.onlinebazar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] items;
    String[] desc;

    public ItemAdapter(Context c, String[] items, String[] i){
        this.items = items;
        desc = i;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.auctions_list_details,null);
        TextView textView_adName = (TextView) v.findViewById(R.id.textView_adName);
        TextView textView_adDesc = (TextView) v.findViewById(R.id.textView_adDesc);

        String name = items[position];
        String desc1 = desc[position];
        textView_adName.setText(name);
        textView_adDesc.setText(desc1);
        return v;
    }
}
