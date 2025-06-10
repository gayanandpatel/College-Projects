package com.example.smsnotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView lblnumber,lblmessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblnumber=(TextView)findViewById(R.id.lbl_number);
        lblmessage=(TextView)findViewById(R.id.lbl_message);
        Bundle b= getIntent().getBundleExtra("data");

        if(b!=null)
        {
            String number=b.getString("number");
            String content=b.getString("content");

            lblnumber.setText(number);
            lblmessage.setText(content);
        }
    }
}