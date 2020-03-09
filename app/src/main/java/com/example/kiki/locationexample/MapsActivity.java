package com.example.kiki.locationexample;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    Button payemnt;
    private GoogleMap mMap;
    TextView tripChargesTextView;
    String Start, End,numberPlate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        payemnt = findViewById(R.id.paymentButton);
        tripChargesTextView = findViewById(R.id.displayChargesOnMapActivity);
        Intent i  = getIntent();
        Start= i.getStringExtra("start");
        End = i.getStringExtra("end");
        numberPlate=i.getStringExtra("numberPlate");
       final double tripCharges = i.getDoubleExtra("Trip Charges", 0d);
        tripChargesTextView.append(""+tripCharges);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        payemnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MapsActivity.this,PaymentGateway.class);
                intent.putExtra("start",Start);
                intent.putExtra("end",End);
                intent.putExtra("tripCharges",tripCharges);
                intent.putExtra("numberPlate",numberPlate);
                startActivity(intent);
            }
        });
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {                           // We commit fraud so that the government doesn't.
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(13.9675, 77.7141);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Toll Booth"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng booth1 = new LatLng(13.9675, 74.7141);
        mMap.addMarker(new MarkerOptions().position(booth1).title("Toll Booth"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(booth1));
        LatLng booth2 = new LatLng(13.9675, 79.7141);
        mMap.addMarker(new MarkerOptions().position(booth2).title("Toll Booth"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(booth2));

        LatLng booth3 = new LatLng(17.3850, 78.4867);
        mMap.addMarker(new MarkerOptions().position(booth3).title("Toll Booth"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(booth3));
    }



}
