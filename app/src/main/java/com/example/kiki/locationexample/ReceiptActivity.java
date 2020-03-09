package com.example.kiki.locationexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class ReceiptActivity extends AppCompatActivity {
    Button button;
    TextView paymentId , paymentMethod , paymentCharged , paymentMadeBy,numberPlateTextView;
    String  method,name,StartPoint,EndPoint,numberPlate;
    double charges;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        Intent i = getIntent();
       method =  i.getStringExtra("Payment Method");
       charges = i.getDoubleExtra("tripCharges",0d);
       name = i.getStringExtra("name");
       StartPoint = i.getStringExtra("start");
       numberPlate = i.getStringExtra("numberPlate");
       EndPoint = i.getStringExtra("end");
        paymentId = findViewById(R.id.activity_receipt_id_text_view);
        paymentMethod = findViewById(R.id.activity_receipt_payment_text_view);
        paymentCharged = findViewById(R.id.activity_receipt_charges_text_view);
        paymentMadeBy = findViewById(R.id.activity_receipt_name_text_view);
        numberPlateTextView = findViewById(R.id.activity_receipt_number_plate_text_view);
    button = findViewById(R.id.ShowRoute);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?saddr=%f,%f(%s)&daddr=%f,%f (%s)", 12.9675, 77.7141, StartPoint, 11.9675, 74.7141, EndPoint);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        }
    });
        String id = UUID.randomUUID().toString().substring(0,9);
        numberPlateTextView.setText(""+numberPlate);
        paymentId.setText(""+id);
        paymentMethod.setText(""+method);
        paymentCharged.setText(""+charges);
        paymentMadeBy.setText(""+name);


    }
}
