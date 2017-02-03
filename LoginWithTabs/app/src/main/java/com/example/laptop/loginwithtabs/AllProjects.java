package com.example.laptop.loginwithtabs;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by LAPTOP on 24/01/2017.
 */

public class AllProjects extends MainActivity {

    //////////////////////////////////////////////////////////////////////////////////////////
    //              AllProjects brings back content written in database                    //
    ////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    /////////////////Variables//////////////////////////
    ///////////////////////////////////////////////////

    String ProjectName;


    ArrayList<ArrayList<String>> MainAL=new  ArrayList<ArrayList<String>>();



    /////////////////////////////////////////////////////
    /////////////////Variables//////////////////////////
    ///////////////////////////////////////////////////


     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doneprojects);

        GetContents();

        ArrayAdapter adapter = new MyAdapter(this,R.layout.deletelistitem,MainAL);

        ListView listView = (ListView) findViewById(R.id.TableListView);
        listView.setAdapter(adapter);
    }

    /////////////////////////////////////////////
    //          Get all database content      //
    ///////////////////////////////////////////


    public void GetContents()
    {
        Cursor res= MainActivity.database.GetProjectDetails();




while ( res.moveToNext() || res.isBeforeFirst()) {
    ProjectName = res.getString(1);
    Cursor res2= MainActivity.database.GetAllProjectTasks();
    while (res2.moveToNext() || res2.isFirst() )
    {
if ( res.getInt(0)== res2.getInt(0)) {
    ArrayList<String> AL = new ArrayList<>();

    AL.add(ProjectName);
    AL.add(res2.getString(2));
    AL.add(res2.getString(3));

    AL.add(res2.getString(5));

    MainAL.add(AL);
}
    }



}








    }


}

