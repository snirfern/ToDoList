package com.example.laptop.loginwithtabs;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    //////////////////////////////////////////////////////////////////////////////////////////
    //              MainActivity recive username,navigating between activities             //
    ////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    /////////////////Variables//////////////////////////
    ///////////////////////////////////////////////////


    /////////////////////////////////////////////
    //          Widgets definition            //
    ///////////////////////////////////////////

    Button a;
    EditText aa;
    Spinner spin;
    TextView txt;
    TextView what;
    Button Choose;
    String item;
    Button AddProject;
    EditText ProjectName;
    EditText ProjectNumber;


    /////////////////////////////////////////////
    //          Database variables            //
    ///////////////////////////////////////////
    public static int ProjectCounter = 0;
    public static SQLiteDatabase db;
    public static DataBase database;


    /////////////////////////////////////////////
    //          MainActivity variables        //
    ///////////////////////////////////////////

    public String Password = "";
    public static boolean state = false;
    private GoogleApiClient client;


    /////////////////////////////////////////////////////
    /////////////////Variables//////////////////////////
    ///////////////////////////////////////////////////
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        database = new DataBase(this.getBaseContext());
        db = database.getWritableDatabase();
        ProjectCounter = database.GetProjectsNumber();


        a = (Button) findViewById(R.id.Login);
        aa = (EditText) findViewById(R.id.editText);
        spin = (Spinner) findViewById(R.id.spinner);
        txt = (TextView) findViewById(R.id.txt);
        what = (TextView) findViewById(R.id.what);
        Choose = (Button) findViewById(R.id.Choose);
        ProjectName = (EditText) findViewById(R.id.ProjectNameET);


        state = true;


        /////////////////////////////////////////////
        //      Spinner Choose option button      //
        ///////////////////////////////////////////


        Choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item == "Select Project") {

                    Intent Tabs2 = new Intent(MainActivity.this, Tabs.class);
                    startActivity(Tabs2);





                }
                if (item == "Add project") {
                    Intent launchActivity2 = new Intent(MainActivity.this, AddProject.class);
                    startActivity(launchActivity2);


                }
                if (item == "Watch all projects") {
                    if (ProjectCounter != 0) {
                        Intent la = new Intent(MainActivity.this, AllProjects.class);
                        startActivity(la);

                    } else
                        Toast.makeText(getBaseContext(), "No projects to show..", Toast.LENGTH_LONG).show();
                }
            }
        });


        /////////////////////////////////////////////
        //          Spinner OnItemSelected        //
        ///////////////////////////////////////////

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /// Toast.makeText(this,iCurrentSelection,Toast.LENGTH_LONG).show();
                item = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        /////////////////////////////////////////////
        //          Spinner build                 //
        ///////////////////////////////////////////

        List<String> categories = new ArrayList<String>();
        categories.add("None");
        categories.add("Select Project");
        categories.add("Add project");
        categories.add("Watch all projects");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.spinneritem, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(R.layout.spinneritem);
        //simple_spinner_dropdown_item
        // attaching data adapter to spinner+
        spin.setAdapter(dataAdapter);


        /////////////////////////////////////////////
        //              Password                  //
        ///////////////////////////////////////////

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                {
                    if (Password == "") {
                        if (aa.getText().toString().equals("a")) {
                            spin.setVisibility(View.VISIBLE);
                            aa.setVisibility(View.GONE);
                            a.setVisibility(View.GONE);
                            txt.setVisibility(View.GONE);
                            what.setVisibility(View.VISIBLE);
                            Choose.setVisibility(View.VISIBLE);

                            Password = aa.getText().toString();
                        } else
                            Toast.makeText(getBaseContext(), "Wrong password...", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        aa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a.setVisibility(View.VISIBLE);
                aa.setText("");
            }
        });


        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /////////////////////////////////////////////
    // MainActivity necessary base functions  //
    ///////////////////////////////////////////


    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


}
