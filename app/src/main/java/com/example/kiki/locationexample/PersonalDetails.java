package com.example.kiki.locationexample;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class PersonalDetails extends AppCompatActivity {
    Button selectBoothButton,submitDetailsButton;
    EditText ed1,ed2,ed3,ed4,ed5;
    Spinner vehicleTypeSpinner;
    String startPoint,endPoint,numberPlate;
    CheckBox roundTripCheckbox;
    Double tripCharges=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_vehicle);
        selectBoothButton = findViewById(R.id.showBoothsButton);
        submitDetailsButton=findViewById(R.id.submit_details);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
        ed5 = findViewById(R.id.ed5);
        roundTripCheckbox = findViewById(R.id.roundTripCheckbox);
        vehicleTypeSpinner = findViewById(R.id.vehicleTypeSpinner);
        selectBoothButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PersonalDetails.this, "Showing Booths", Toast.LENGTH_SHORT).show();

                Intent  intent = new Intent(PersonalDetails.this, MapsActivity.class);
                intent.putExtra("start",startPoint);
                intent.putExtra("end",endPoint);
                CalculateCharges();
                intent.putExtra("numberPlate",numberPlate);
                intent.putExtra("Trip Charges",tripCharges);
                startActivity(intent);

            }
        });
        submitDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText("");
                ed2.setText("");
                numberPlate=ed3.getText().toString();
                ed3.setText("");
                startPoint = ed4.getText().toString();
                endPoint=ed5.getText().toString();

                ed4.setText("");
                ed5.setText("");

                Toast.makeText(PersonalDetails.this, "Details Successfully Submitted.\nProceed to booths", Toast.LENGTH_LONG).show();

            }
        });
        if(roundTripCheckbox.isChecked()==true){
            roundTripCheckbox.setBackgroundColor(Color.parseColor("#ffffff"));
        }


    }
    void CalculateCharges(){

        int position = vehicleTypeSpinner.getSelectedItemPosition();
        if (position == 1){
            tripCharges = 57.10;
        }
        else if (position ==2){
            tripCharges = 69.70;
        }
        else if (position == 3){
            tripCharges = 124.39;
        }
        else if (position==4){
            tripCharges = 57.10;
        }
        else{
            tripCharges = 200.0;
        }

        if(roundTripCheckbox.isChecked()==true){
            tripCharges = tripCharges*2;
        }
    }

}
