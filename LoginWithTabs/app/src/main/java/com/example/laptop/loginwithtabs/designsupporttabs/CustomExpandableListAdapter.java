package com.example.laptop.loginwithtabs.designsupporttabs;


import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.laptop.loginwithtabs.DataBase;
import com.example.laptop.loginwithtabs.MainActivity;
import com.example.laptop.loginwithtabs.R;
import com.example.laptop.loginwithtabs.Tabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.laptop.loginwithtabs.Tabs.t;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {

    String c;
//ViewPager vp;
    private Context context;
    private List<String> expandableListTitle;
    private HashMap<String, List<String>> expandableListDetail;



   // private DataBase db2=new DataBase(context);
    private ArrayList<String> AL=new ArrayList<String>();
    private String[] TextArray;
    DataBase db2= MainActivity.database;


    public CustomExpandableListAdapter(Context context)

    //////////////////////////////////////////////////////////////////////////////////////////
    //                          ExpendableList adapter                                     //
    ////////////////////////////////////////////////////////////////////////////////////////


    {

        this.context = context;

        this.expandableListTitle=Titles();
        this.expandableListDetail =Desc();










    }



    @Override
    public Object getChild(int listPosition, int expandedListPosition)
    {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition)).get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition)
    {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {
        final String expandedListText = (String) getChild(listPosition, expandedListPosition);
        if (convertView == null)
        {

            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        TextView expandedListTextView = (TextView) convertView.findViewById(R.id.expandedListItem);
        expandedListTextView.setText(expandedListText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition)
    {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition)).size();
    }

    @Override
    public Object getGroup(int listPosition)
    {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount()
    {
        return this.expandableListTitle.size();

    }

    @Override
    public long getGroupId(int listPosition)
    {
        return listPosition;
    }

    @Override
    public View getGroupView(final int listPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {
        final String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);

        }

        Button MapButton=(Button)convertView.findViewById(R.id.MapButton);
        Button Vi=(Button)convertView.findViewById((R.id.DoneButton));
       // int Position=listPosition+1;

        Vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //   final Dialog dialog= new Dialog(context);
                db2.Remove(expandableListTitle.get(listPosition).trim());
               android.support.v4.view.PagerAdapter adapter = new PagerAdapter
                      (Tabs.fm,t.getTabCount());
                Tabs.viewPager.setAdapter(adapter);
               Tabs.viewPager.setCurrentItem(1);
                adapter.notifyDataSetChanged();

               /* dialog.setContentView(R.layout.dialogbox);
                dialog.show();

                Button sure=(Button)dialog.findViewById(R.id.Sure);
                sure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       dialog.cancel();




                    }
                });*/
            }
        });



        //////////////////////////////////////////////////////////////////////////////////////////
        //                  connector between tab2 to tab3 map functions                       //
        ////////////////////////////////////////////////////////////////////////////////////////
        MapButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

               SupportClass.ChosenTask=listPosition+1;

                android.support.v4.view.PagerAdapter adapter = new PagerAdapter
                        (Tabs.fm, t.getTabCount());
                Tabs.viewPager.setAdapter(adapter);



                Tabs.viewPager.setCurrentItem(2);

            }
        });


        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return convertView;
    }

    @Override
    public boolean hasStableIds()
    {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition)
    {
        return true;
    }




    /////////////////////////////////////////////
    //          returns tasks list            //
    ///////////////////////////////////////////

public List<String> Titles()
{

    List<String> titles=new ArrayList<String>();
titles.clear();
        Cursor res=db2.GetProjectTasks();

    StringBuffer buffer= new StringBuffer();


    while ( res.moveToNext())
    {

        titles.add(res.getString(2));
    }


    return titles;




}
    /////////////////////////////////////////////
    //     Returns project tasks content      //
    ///////////////////////////////////////////

    public HashMap<String, List<String>> Desc()
    {

        Cursor res=db2.GetProjectTasks();


        HashMap<String, List<String>> HM =new HashMap<String, List<String>>();


        while ( res.moveToNext())
        {
            List<String> list=new ArrayList<String>();
            list.clear();

            list.add(res.getString(3));

            HM.put(res.getString(2),list);


        }






        return HM;
    }


    //////////////////////////////////////////////////////////////////////////////////////////
    //                  Optional dialog on finish task(not used)                           //
    ////////////////////////////////////////////////////////////////////////////////////////
    public void Dialog()
    {



        AlertDialog.Builder builder= new AlertDialog.Builder(context);
        builder.setTitle("Task finish");
        builder.setMessage("Are you sure you want to finish task?");


        AlertDialog dialog = builder.create();


    }



}