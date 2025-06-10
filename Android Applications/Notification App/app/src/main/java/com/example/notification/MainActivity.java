package com.example.notification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnstart,btnstop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnstart=(Button)findViewById(R.id.btn_start);
        btnstart.setOnClickListener(this);
        btnstop=(Button)findViewById(R.id.btn_stop);
        btnstop.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
// TODO Auto-generated method stub
        if(v.equals(btnstart))
        {
            Intent it=new Intent(this,ServiceClass.class);
            Bundle b=new Bundle();
            b.putBoolean("stop", true);
            it.putExtra("data", b);
            startService(it);
        }
        else
        {
            Intent it=new Intent(this,ServiceClass.class);
            stopService(it);
        }
    }
}