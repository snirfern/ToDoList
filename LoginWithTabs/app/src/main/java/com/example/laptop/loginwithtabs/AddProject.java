package com.example.laptop.loginwithtabs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by LAPTOP on 15/01/2017.
 */

public class AddProject extends MainActivity
{

    //////////////////////////////////////////////////////////////////////////////////////////
    //              AddProject enables adding new projects,tasksk to database              //
    ////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    /////////////////Variables//////////////////////////
    ///////////////////////////////////////////////////


    /////////////////////////////////////////////
    //          Widgets definition            //
    ///////////////////////////////////////////

    Button Data;
    Button AddProjectt;
    Button AddTask;
    EditText TaskContentET;
    EditText TaskTitleET;
    Button Finish;
    EditText ProjectDesc;
    EditText ProjectTitle;
    Button AddProject;
    LinearLayout ll;
    LinearLayout ll1;
    EditText ProjectName;


    /////////////////////////////////////////////
    //          DataBase variables            //
    ///////////////////////////////////////////
    int TaskCounter =0;
    DataBase db;


    /////////////////////////////////////////////////////
    /////////////////Variables//////////////////////////
    ///////////////////////////////////////////////////


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addproject);


        db=MainActivity.database;



        AddProjectt = (Button) findViewById(R.id.AddProject);
        AddTask = (Button) findViewById(R.id.AddTask);
        ll = (LinearLayout) findViewById(R.id.Tasks);
        ll1 = (LinearLayout) findViewById(R.id.Projects);
        ProjectName = (EditText) findViewById(R.id.ProjectNameET);


        TaskContentET = (EditText) findViewById(R.id.TaskContentET);
        TaskTitleET = (EditText) findViewById(R.id.TaskTitleET);
        TaskContentET.setText("");
        TaskTitleET.setText("");

        ProjectTitle=(EditText) findViewById(R.id.ProjectNameET);
        ProjectDesc=(EditText) findViewById(R.id.ProjectDescET);

        TaskContentET.setText("");
        TaskTitleET.setText("");
        Finish=(Button)findViewById(R.id.Finish);



        /////////////////////////////////////////////
        //          Finish adding record          //
        ///////////////////////////////////////////

        Finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // int tasks=database.GetActiveTasksCount(1);
                Intent BackToMain = new Intent(AddProject.this, MainActivity.class);
                startActivity(BackToMain );

            }
        });
        NewProject();
        NewTask();






    }


    /////////////////////////////////////////////
    //          Create new project            //
    ///////////////////////////////////////////

public void NewProject()
{
    AddProjectt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TaskCounter=0;
            ProjectCounter=ProjectCounter+1;
            ll.setVisibility(View.VISIBLE);
            ll1.setVisibility(View.INVISIBLE);
           // db=new DataBase(getBaseContext());
            boolean check=db.InsertTable1Data(ProjectCounter, ProjectTitle.getText().toString());

            if (check=true)
                Toast.makeText(getBaseContext(),"Addprojectcounter:"+ProjectCounter,Toast.LENGTH_SHORT).show();











        }
    });
}


    /////////////////////////////////////////////
    //          Create new task               //
    ///////////////////////////////////////////

    public void NewTask()
    {
        AddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String a=TaskTitleET.getText().toString();
                if (!TaskTitleET.getText().toString().equals("") && !TaskContentET.getText().toString().equals("")) {
                    TaskCounter=TaskCounter+1;
                    Toast.makeText(getBaseContext(), "Task counter:"+TaskCounter, Toast.LENGTH_SHORT).show();

                    boolean check = db.InsertTable2Data(ProjectCounter, TaskCounter, TaskTitleET.getText().toString(), TaskContentET.getText().toString());
                    if (check = true) {
                        Toast.makeText(getBaseContext(), "Task Add succeddes!!!!!addtaskprojectcounter:" + ProjectCounter, Toast.LENGTH_SHORT).show();
                        Finish.setVisibility(View.VISIBLE);
                    }
                }
                else
                    Toast.makeText(getBaseContext(), "No task to recive....", Toast.LENGTH_SHORT).show();


                TaskContentET.setText("");
                TaskTitleET.setText("");



            }
        });


    }







}
