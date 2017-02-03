package com.example.laptop.loginwithtabs.designsupporttabs;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.laptop.loginwithtabs.DataBase;
import com.example.laptop.loginwithtabs.MainActivity;
import com.example.laptop.loginwithtabs.R;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by LAPTOP on 27/12/2016.
 */



public class ImageAdapter extends BaseAdapter {



    //////////////////////////////////////////////////////////////////////////////////////////
    //              Image Adaper for projects pictures,name displaying                     //
    ////////////////////////////////////////////////////////////////////////////////////////


    private Context mContext;
    private DataBase db2;//TODO: change to databse from mainactivity
    private ArrayList<String> AL=new ArrayList<String>();
    private static String[] TextArray;
    public static ArrayList<Integer> Position=new ArrayList<>();





    public ImageAdapter(Context c) {
        mContext = c;
        db2= MainActivity.database;
        dat();





    }

    public int getCount() {
        return TextArray.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        View grid;

        LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);




        if (convertView==null )
        {

            grid=new View(mContext);
            grid=inflater.inflate(R.layout.single_grid,null);

            TextView txt=(TextView)grid.findViewById(R.id.Text);
            ImageView imgview = (ImageView)grid.findViewById(R.id.Image);

            txt.setText(TextArray[position].trim());
            imgview.setImageResource(mThumbIds[Randme()]);




        }


        else
        {
            grid=(View)convertView;
        }

        return grid;
    }









    private Integer[] mThumbIds = {
            R.drawable.sample_1, R.drawable.sample_2,
            R.drawable.sample_3, R.drawable.sample_4

    };


    //////////////////////////////////////////////////////////////////////////////////////////
    //          dat function takes care no empty projects introduced                       //
    ////////////////////////////////////////////////////////////////////////////////////////



    public void dat()
    {

AL.clear();
        Cursor res=db2.GetProjectDetails();
        StringBuffer buf=new StringBuffer();
        Position.clear();
        while (res.moveToNext())
        {
            if ( MainActivity.database.GetActiveTasksCount(res.getInt(0)) !=0) {

                AL.add(res.getString(1));
                Position.add(res.getInt(0));
                //buf.append("Projectnunber hereee:   " + res.getString(0));
            }
        }




         TextArray = new String[AL.size()];
        TextArray = AL.toArray(TextArray);
        AL.toArray(TextArray);

    }


    /////////////////////////////////////////////
    //          Randomize images              //
    ///////////////////////////////////////////
    public int Randme()
    {
        Random rand = new Random();
        int random=rand.nextInt(4);
        return random;
    }

}