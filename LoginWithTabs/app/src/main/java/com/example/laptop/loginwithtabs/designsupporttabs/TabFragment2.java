package com.example.laptop.loginwithtabs.designsupporttabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.laptop.loginwithtabs.R;

import java.util.HashMap;
import java.util.List;

public class TabFragment2 extends Fragment {

    ViewPager viewPager;
//taBase db=new DataBase(this.getContext());
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.tab_fragment_2, container, false);
//no use
        expandableListView = (ExpandableListView)v.findViewById(R.id.expandableListView);
        expandableListAdapter = new CustomExpandableListAdapter(this.getContext());
        expandableListView.setAdapter(expandableListAdapter);
expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {


            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                return false;
            }
        });




       // Toast.makeText(getContext(), "Tab2-----------position"+SupportClass.Positions ,
          //      Toast.LENGTH_SHORT).show();
        return v; }



}