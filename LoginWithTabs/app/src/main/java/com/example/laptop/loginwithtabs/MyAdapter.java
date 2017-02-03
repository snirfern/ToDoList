package com.example.laptop.loginwithtabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by LAPTOP on 24/01/2017.
 */

public class MyAdapter extends ArrayAdapter {


    //////////////////////////////////////////////////////////////////////////////////////////
    //              MyAdapter for getAllPprojects list                                     //
    ////////////////////////////////////////////////////////////////////////////////////////

    ArrayList<ArrayList<String>> MainAL;

    public MyAdapter(Context context, int deletelistitem, ArrayList<ArrayList<String>> MainAL1) {
        super(context, deletelistitem, MainAL1);
        MainAL=MainAL1;

    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.deletelistitem, null,false);


        TextView textView1 = (TextView) v.findViewById(R.id.ProjectnameTextView);
        TextView textView2 = (TextView) v.findViewById(R.id.TaskNameTextView);
        TextView textView3 = (TextView) v.findViewById(R.id.TaskContentTextView);
        TextView textView4 = (TextView) v.findViewById(R.id.IsDoneTxtView);

int pos= position;
        textView1.setText(MainAL.get(position).get(3));
        textView2.setText(MainAL.get(position).get(2));
        textView3.setText(MainAL.get(position).get(1));
        textView4.setText(MainAL.get(position).get(0));//projectname

        return v;

    }

}

