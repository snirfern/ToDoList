package com.example.laptop.loginwithtabs.designsupporttabs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {






public static HashMap<String, List<String>> getData()
{
HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();






/*
    Cursor res= db2.GetProjectTasks();
    StringBuffer Buffer=new StringBuffer();

    while (res.moveToNext())
    {

        String Desc;
        //Task Title
        Desc=res.getString(1);

        //Tasks content
        List<String>  Task1= new ArrayList<String>();
        Task1.add(res.getString(2));


        expandableListDetail.put(Desc,Task1);

        Desc="";
        Task1.clear();



    }
*/

List<String>  Task1= new ArrayList<String>();
Task1.add("Hang notes");


List<String> Task2 = new ArrayList<String>();
Task2.add("Stage electricity");


List<String> Task3 = new ArrayList<String>();
Task3.add("TAU CC");


expandableListDetail.put("Task1", Task1);
expandableListDetail.put("Task2", Task2);
expandableListDetail.put("Task3", Task3);

return expandableListDetail;
}



}