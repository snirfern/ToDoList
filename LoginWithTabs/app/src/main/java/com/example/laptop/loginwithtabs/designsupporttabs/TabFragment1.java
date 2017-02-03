package com.example.laptop.loginwithtabs.designsupporttabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.laptop.loginwithtabs.R;
import com.example.laptop.loginwithtabs.Tabs;


public class TabFragment1 extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View layout = inflater.inflate(R.layout.activity_main_grid, container, false);



        GridView gridview = (GridView)layout.findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this.getContext()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


SupportClass.Positions=ImageAdapter.Position.get(position);
           //    Toast.makeText(getContext(), "Suportclass:position:"+SupportClass.Positions ,
                 //       Toast.LENGTH_SHORT).show();


                android.support.v4.view.PagerAdapter adapter = new PagerAdapter
                        (Tabs.fm, Tabs.t.getTabCount());
                Tabs.viewPager.setAdapter(adapter);

        Tabs.viewPager.setCurrentItem(1);





            }
        });


    return layout;
}


}