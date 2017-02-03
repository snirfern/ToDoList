package com.example.laptop.loginwithtabs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.laptop.loginwithtabs.designsupporttabs.SupportClass;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by LAPTOP on 15/01/2017.
 */

public   class DataBase extends SQLiteOpenHelper {



    //////////////////////////////////////////////////////////////////////////////////////////
    //                                     Database                                        //
    ////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////////
    //          DataBase basic variavles      //
    ///////////////////////////////////////////
    public static final String DataBaseName = "Asset.db";


    public static final String Table1Name = "Projects";
    public static final String COL1 = "ProjectNumber";
    public static final String COL2 = "ProjectName";

    public static final String Table2Name = "Tasks";
    public static final String SCOL1 = "ProjectNumber";
    public static final String SCOL2 = "TaskNumber";
    public static final String SCOL3 = "TaskTitle";
    public static final String SCOL4 = "TaskDescription";
    public static final String SCOL5 = "Coordinates";
    public static final String SCOL6 = "IsDone";


    public static final String Table3Name = "Locations";
    public static final String SCOL7 = "Latitude";
    public static final String SCOL8 = "Longtitude";
    public static final String SCOL9 = "Picture";



    public Context c;


    public DataBase(Context context) {


        super(context, DataBaseName, null, 1);
        this.c = context;
        SQLiteDatabase db = this.getWritableDatabase();

        /////////////////////////////////////////////
        //    Reseting tables for self testing    //
        ///////////////////////////////////////////


        if (MainActivity.state == false) {
            db.delete(Table2Name, null, null);
            db.delete(Table1Name, null, null);
            try {
                db.delete(Table3Name, null, null);
            } catch (Exception e) {
            }
            ;
            db.execSQL("DROP TABLE IF EXISTS " + Table1Name);
            db.execSQL("DROP TABLE IF EXISTS " + Table2Name);

        }
            onCreate(db);

        }




    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL("create table " + Table1Name + "(ProjectNumber INTEGER,ProjectName TEXT)");
            db.execSQL("create table " + Table2Name + "(ProjectNumber INTEGER,TaskNumber TEXT,TaskTitle TEXT,TaskDescription TEXT,Coordinates BLOB,IsDone TEXT)");
            db.execSQL("create table "+ Table3Name + "(ProjectNumber INTEGER,TaskNumber TEXT,Latitude REAL,Longtitude REAL,Picture INTEGER)");
        } catch (Exception ex) {
        }
        ;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        /////////////////////////////////////////////
        //    Reseting tables for self testing    //
        ///////////////////////////////////////////


        //db.execSQL("DROP TABLE IF EXISTS " + Table1Name);
       // db.execSQL("DROP TABLE IF EXISTS " + Table2Name);
       // db.execSQL("DROP TABLE IF EXISTS " + Table3Name);
       // onCreate(db);


    }


    /////////////////////////////////////////////
    //              Add projects              //
    ///////////////////////////////////////////

    public boolean InsertTable1Data(int projectnum, String projectname) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1, projectnum);
        cv.put(COL2, projectname);

        Toast.makeText(this.c, "prject num:" + projectnum, Toast.LENGTH_LONG).show();
        long result = db.insert(Table1Name, null, cv);

        if (result == -1)
            return false;


        return true;


    }

    /////////////////////////////////////////////
    //              Add tasks                 //
    ///////////////////////////////////////////


    public boolean InsertTable2Data(int projectnum, int TaaskNumber, String TaskDesc, String TaskContent) {
        // db.delete(Table2Name, null, null);

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SCOL1, projectnum);
        cv.put(SCOL2, TaaskNumber);
        cv.put(SCOL3, TaskDesc);
        cv.put(SCOL4, TaskContent);
        cv.put(SCOL5, 123.33333);
        cv.put(SCOL6, "no");



        long result = db.insert(Table2Name, null, cv);

        if (result == -1)
            return false;


        return true;
    }


    /////////////////////////////////////////////
    //           Insert locations             //
    ///////////////////////////////////////////

    public boolean InsertTable3Data(LatLng Coordinates)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(SCOL1,SupportClass.Positions);
        cv.put(SCOL2,SupportClass.ChosenTask);
        cv.put(SCOL7, Coordinates.latitude);
        cv.put(SCOL8,Coordinates.longitude);
        cv.put(SCOL9,1);




       long result = db.insert(Table3Name, null, cv);
        if (result == -1)
            return false;


        return true;


    }

    public Cursor GetProjectDetails() {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from '" + Table1Name + "'", null);


        return res;
    }


    public Cursor GetProjectTasks() {
        // db.delete(Table2Name, null, null);

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from " + Table2Name + " where " + SCOL1 + "='" + SupportClass.Positions + "' and " + SCOL6 + "='no'", null);
        //Cursor res=db.rawQuery("select * from '"+ Table2Name,null);
       // Cursor res = db.rawQuery("select * from " + Table2Name + " where " + SCOL1 + "='" + SupportClass.Positions + "' and " + SCOL6 + "='no'", null);



        Toast.makeText(this.c, "This is the position clicked: "+ SupportClass.Positions ,
               Toast.LENGTH_SHORT).show();

        return res;
    }


    public Cursor GetLocations()
    {

        SQLiteDatabase db = this.getWritableDatabase();


        Cursor res = db.rawQuery("select * from " + Table3Name +" where ProjectNumber='"+SupportClass.Positions+"' and TaskNumber='"+SupportClass.ChosenTask+"'",null);



        return res;
    }


    /////////////////////////////////////////////
    //      Finished tasks function           //
    ///////////////////////////////////////////


    public void Remove(String listPosition) {
        //Position
        //NowProjectNumber
        //Table2
        SQLiteDatabase db = this.getWritableDatabase();




        //  db.update(Table2Name, cv, SCOL1+"='"+SupportClass.Positions+"' and "+SCOL2+"='"+listPosition+1+"'", null);

        db.execSQL("UPDATE " + Table2Name + " SET " + SCOL6 + "='yes' WHERE ProjectNumber='" + SupportClass.Positions + "' and " + SCOL3 + "='" + listPosition.trim() + "'");
        Toast.makeText(this.c, "dsdssdsdsds", Toast.LENGTH_SHORT).show();

    }


    /////////////////////////////////////////////
    //    connecting picture to pin point     //
    ///////////////////////////////////////////

    public void InsertMarkerPicture(LatLng place,int Picture)

    {

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("UPDATE "+Table3Name +" SET "  +SCOL9 +"= '"+Picture+  "' WHERE ProjectNumber='"+SupportClass.Positions+"' AND TaskNumber = '"+SupportClass.ChosenTask+"' and Latitude = '"+place.latitude+"' and Longtitude='"+place.longitude+"'");



    }


    public Cursor GetAllProjectTasks() {


        // db.delete(Table2Name, null, null);

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from " + Table2Name, null);
        //Cursor res=db.rawQuery("select * from '"+ Table2Name,null);



        return res;
    }


    /////////////////////////////////////////////
    //       Get all tasks to count them      //
    ///////////////////////////////////////////

    public Cursor  GetAll()
{
    SQLiteDatabase db = this.getWritableDatabase();

    Cursor res = db.rawQuery("select * from " + Table2Name, null);


    return res;


}


    /////////////////////////////////////////////
    //          get undone tasks              //
    ///////////////////////////////////////////

    public int GetActiveTasksCount(int Projectnumber)
{

    SQLiteDatabase db = this.getReadableDatabase();
    String countQuery = "SELECT  * FROM " + Table2Name +" WHERE ProjectNumber='"+Projectnumber+"' and IsDone=='no' and TaskTitle IS NOT NULL and TaskDescription IS NOT NULL";

    Cursor cursor = db.rawQuery(countQuery, null);
    int cnt = cursor.getCount();
    cursor.close();
    return cnt;
}


    public int GetProjectsNumber()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT  * FROM Projects";

        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        return cnt;
    }


}


