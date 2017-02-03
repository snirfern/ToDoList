
        package com.example.laptop.loginwithtabs.designsupporttabs;

        import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.laptop.loginwithtabs.MainActivity;
import com.example.laptop.loginwithtabs.R;
import com.example.laptop.loginwithtabs.Tabs;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

        public class TabFragment3 extends Fragment {
            MapView mMapView;
            private GoogleMap googleMap;
            Marker marker;
            ArrayList<MarkerOptions> MarkerArray = new ArrayList<>();
            LinearLayout androidDropDownMenuIconItem;
            Tabs a;
            LatLng ld;
            ArrayList<LatLng> MarkersList = new ArrayList<LatLng>();
            private OnItemSelectedListener listener;

            ArrayList<Integer> PicturesArray ;
                        // Define the events that the fragment will use to communicate
            public interface OnItemSelectedListener {
                // This can be any number of events to be sent to the activity
                public void onRssItemSelected(String link);
            }



            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                View v = inflater.inflate(R.layout.tab_fragment_3, container,
                        false);
              HorizontalScrollView hsv=(HorizontalScrollView)v.findViewById(R.id.scrollview);
                androidDropDownMenuIconItem = (LinearLayout) v.findViewById(R.id.LL);
                ImageView iv1=(ImageView)v.findViewById(R.id.iv1);

                ImageView iv2=(ImageView)v.findViewById(R.id.iv2);
                ImageView iv3=(ImageView)v.findViewById(R.id.iv3);
                ImageView iv4=(ImageView)v.findViewById(R.id.iv4);

                ImageView iv5=(ImageView)v.findViewById(R.id.iv5);

                ImageView iv6=(ImageView)v.findViewById(R.id.iv6);

                ImageView iv7=(ImageView)v.findViewById(R.id.iv7);

                ImageView iv8=(ImageView)v.findViewById(R.id.iv8);




               // a = (Tabs)getActivity();



               androidDropDownMenuIconItem.setVisibility(View.INVISIBLE);

                mMapView = (MapView) v.findViewById(R.id.mapView);

                mMapView.onCreate(savedInstanceState);

                mMapView.onResume();// needed to get the map to display immediately

                try {
                    MapsInitializer.initialize(getActivity().getApplicationContext());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                googleMap = mMapView.getMap();
                // latitude and longitude
                double latitude = 32.111767;
                double longitude = 34.801361;
                // create marker
                ////////////////////////////

                //////////////////////////
                MarkerOptions marker = new MarkerOptions().position(
                        new LatLng(latitude, longitude)).title("Hello Maps");

                // Changing marker icon
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

                // adding marker
                googleMap.addMarker(marker);
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(new LatLng(32.111767, 34.801361)).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));


                if ( SupportClass.ChosenTask!= 0 )
                {
                    Markers();
                }


                ////////////////////////////////
                ///////////////////////////////
                ////////////////////////////////
/*
                MarkerOptions marker1 = new MarkerOptions().position(
                        new LatLng(latitude, longitude)).title("Hello Maps");

                // Changing marker icon
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

                // adding marker
                googleMap.addMarker(marker);
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(new LatLng(32.111767, 34.801361)).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
1*/


                //////////////////////////////////
                ////////////////////////////////
                /////////////////////////////////
                iv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PinMarker(R.drawable.sample_1a);
                       // PicturesArray.add(R.drawable.sample_1a);
                        MainActivity.database.InsertMarkerPicture(ld,R.drawable.sample_1a);
                        androidDropDownMenuIconItem.setVisibility(View.GONE);

                    }
                });
                iv2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PinMarker(R.drawable.sample_1a);
                        MainActivity.database.InsertMarkerPicture(ld,R.drawable.sample_1a);
                        androidDropDownMenuIconItem.setVisibility(View.GONE);
                       // PicturesArray.add(R.drawable.sample_1a);

                    }
                });
                iv3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PinMarker(R.drawable.sample_1a);
                        MainActivity.database.InsertMarkerPicture(ld,R.drawable.sample_1a);
                       // PicturesArray.add(R.drawable.sample_1a);
                        androidDropDownMenuIconItem.setVisibility(View.GONE);

                    }
                });
                iv4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PinMarker(R.drawable.sample_4a);
                        MainActivity.database.InsertMarkerPicture(ld,R.drawable.sample_4a);
                       // PicturesArray.add(R.drawable.sample_4a);
                        androidDropDownMenuIconItem.setVisibility(View.GONE);

                    }
                });

                iv5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PinMarker(R.drawable.sample_3a);
                        MainActivity.database.InsertMarkerPicture(ld,R.drawable.sample_3a);
                       // PicturesArray.add(R.drawable.sample_3a);
                        androidDropDownMenuIconItem.setVisibility(View.GONE);

                    }
                });

                iv6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PinMarker(R.drawable.sample_2a);
                      //  PicturesArray.add(R.drawable.sample_2a);
                        MainActivity.database.InsertMarkerPicture(ld,R.drawable.sample_2a);
                        androidDropDownMenuIconItem.setVisibility(View.GONE);

                    }
                });

                iv7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PinMarker(R.drawable.sample_1a);
                        MainActivity.database.InsertMarkerPicture(ld,R.drawable.sample_1a);
                        //PicturesArray.add(R.drawable.sample_1a);
                        androidDropDownMenuIconItem.setVisibility(View.GONE);

                    }
                });

                iv8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PinMarker(R.drawable.sample_2a);
                        MainActivity.database.InsertMarkerPicture(ld,R.drawable.sample_2a);
                        //PicturesArray.add(R.drawable.sample_2a);
                        androidDropDownMenuIconItem.setVisibility(View.GONE);


                    }
                });


                googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {


                    public void onMapLongClick(LatLng latLng) {

                        androidDropDownMenuIconItem.setVisibility(View.VISIBLE);


ld=latLng;

                       MainActivity.database.InsertTable3Data(ld);



                      //  Toast.makeText(getContext(),MarkersList.toString(),Toast.LENGTH_LONG).show();


                    }


                });
                // Perform any camera updates here


                return v;
            }

            private void Markers() {

                Cursor res=MainActivity.database.GetLocations();
                StringBuffer buffer=new StringBuffer();
                Double Latitude;
                Double Longtitude;
              //  int ArrayPicturesCounter=0;
               // int s= PicturesArray.get(0).intValue();
                while ( res.moveToNext())
                {
                    if ( (res.getDouble(2)!=0) &&( res.getDouble(3)!=0) && (res.getInt(4)!= 1)) {
                        Latitude = res.getDouble(2);
                        Longtitude = res.getDouble(3);
                        int Picture=res.getInt(4);

                        PinMarker(Latitude, Longtitude,Picture);
                        ///Lokk here!!!


                    }
                  //  ArrayPicturesCounter++;
                }
            }



            public void PinMarker(Double l1,Double l2,int Picture)
            {

               // boolean check= MainActivity.database.InsertTable3Data(ld);

            //    googleMap = mMapView.getMap();
                MarkerOptions marker1 = new MarkerOptions().position(
                        new LatLng(l1, l2)).title("New Marker");


               // marker1.icon(BitmapDescriptorFactory.fromResource(Picture));
               marker1.icon(BitmapDescriptorFactory.fromResource(Picture));



                googleMap.addMarker(marker1);
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(new LatLng(l1, l2)).zoom(12).build();


                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));

            }

            public void PinMarker(int s)
            {

               boolean check= MainActivity.database.InsertTable3Data(ld);


                MarkerOptions marker1 = new MarkerOptions().position(
                        new LatLng(ld.latitude, ld.longitude)).title("New Marker");


                marker1.icon(BitmapDescriptorFactory.fromResource(s));



                googleMap.addMarker(marker1);
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(new LatLng(ld.latitude, ld.longitude)).zoom(12).build();


                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));

            }

            @Override
            public void onResume() {
                super.onResume();
                mMapView.onResume();
            }


            @Override
            public void onPause() {
                super.onPause();
                mMapView.onPause();
            }

            @Override
            public void onDestroy() {
                super.onDestroy();
                mMapView.onDestroy();
            }

            @Override
            public void onLowMemory() {
                super.onLowMemory();
                mMapView.onLowMemory();

            }





        }