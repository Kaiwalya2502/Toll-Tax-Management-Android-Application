package com.example.kiki.locationexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class PaymentGateway extends AppCompatActivity {
    Button button ;
    double tripCharges;
    TextView tripChargesTextView;
    Spinner PaymentModeSpinner;
    String numberPlate;
    EditText paymentMadeBy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_gateway);
        Intent i  = getIntent();
        final String StartPoint = i.getStringExtra("start");
         final String EndPoint  = i.getStringExtra("end");
       tripCharges  = i.getDoubleExtra("tripCharges",0d);
        button = findViewById(R.id.button);
        tripChargesTextView=findViewById(R.id.tripChargesInPaymentGateway);
        tripChargesTextView.append(""+tripCharges);
        numberPlate=i.getStringExtra("numberPlate");
        paymentMadeBy=findViewById(R.id.paymentMadeBy);
        PaymentModeSpinner=findViewById(R.id.PaymentMethodSpinner);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentGateway.this,ReceiptActivity.class);
                intent.putExtra("tripCharges",tripCharges);
                intent.putExtra("name",paymentMadeBy.getText().toString());
                intent.putExtra("Payment Method",PaymentModeSpinner.getSelectedItem().toString());
                intent.putExtra("start",StartPoint);
                intent.putExtra("end",EndPoint);
                intent.putExtra("numberPlate",numberPlate);
                startActivity(intent);
            }
        });

    }
}
