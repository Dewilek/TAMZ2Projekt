package com.example.onlinebazar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class UserAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] fName;
    String[] lName;
    String[] email;

    public UserAdapter(Context c, String[] fName, String[] lName,  String[] email){
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return fName.length;
    }

    @Override
    public Object getItem(int position) {
        return fName[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.users_list_details,null);
        TextView textView_auName = (TextView) v.findViewById(R.id.textView_auName);
        TextView textView_auDesc = (TextView) v.findViewById(R.id.textView_auDesc);
        TextView textView_auEmail = (TextView) v.findViewById(R.id.textView_auEmail);

        String name = fName[position];
        String desc1 = lName[position];
        String email1 = email[position];
        textView_auName.setText(name);
        textView_auDesc.setText(desc1);
        textView_auEmail.setText(email1);
        return v;
    }
}
