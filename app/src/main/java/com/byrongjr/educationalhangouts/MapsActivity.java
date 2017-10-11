package com.byrongjr.educationalhangouts;

import android.content.Intent;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.identity.intents.Address;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    EditText editText;
    Button  go, type, zoomin, zoomout, chat;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        editText  = (EditText) findViewById(R.id.search);
        go = (Button) findViewById(R.id.go);
        type = (Button) findViewById(R.id.type);
        zoomin = (Button) findViewById(R.id.zoomin);
        zoomout = (Button) findViewById(R.id.zoomout);
        chat = (Button) findViewById(R.id.chat_btn);


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString();
                List<android.location.Address> list = null;

                if(!data.equals("") || data != null){
                    Geocoder geocoder = new Geocoder(MapsActivity.this);
                    try {
                        list = geocoder.getFromLocationName(data, 1);
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    android.location.Address address = list.get(0);
                    LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(latLng).title("Marker in Your Place"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12f));
                }

            }
        });

        type.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                if(mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL){
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                }else {
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }

            }
        });

        zoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.animateCamera(CameraUpdateFactory.zoomIn());
            }
        });

        zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.animateCamera(CameraUpdateFactory.zoomOut());
            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chatIntent = new Intent(MapsActivity.this, ChatActivity.class);
                MapsActivity.this.startActivity(chatIntent);
            }
        });

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng tempe = new LatLng(33.429517, -111.940006);
        mMap.addMarker(new MarkerOptions().position(tempe).title("Marker in Tempe"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tempe));
    }
}
