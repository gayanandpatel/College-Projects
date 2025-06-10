package com.example.counter;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable{
    int i=0;
    TextView lblcounter;
    Button btnstart,btnstop;
    Thread thread;
    boolean running=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstart=(Button)findViewById(R.id.btn_start);
        btnstop=(Button)findViewById(R.id.btn_stop);
        btnstart.setOnClickListener(this);
        btnstop.setOnClickListener(this);
        lblcounter=(TextView)findViewById(R.id.lbl_counter);
    }
    @Override
    public void onClick(View v) {
        if(v.equals(btnstart))
        {
            running=true;
            thread=new Thread(this);
            thread.start();
        }
        else if(v.equals(btnstop))
        {
            running=false;
        }
    }

    @Override
    public void run() {

        while(i<100 && running)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hand.sendEmptyMessage(i);
            i++;
        }

    }
    Handler hand=new Handler()
    {
        public void handleMessage(Message m)
        {
            lblcounter.setText(""+m.what);
        }
    };
}
