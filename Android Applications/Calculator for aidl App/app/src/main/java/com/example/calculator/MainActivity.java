package com.example.calculator;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText txtfirst, txtsecond;
    Button btnadd,btnsub,btnmul;
    TextView txtresult;
    calculator cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtfirst=(EditText)findViewById(R.id.txt_first);
        txtsecond=(EditText)findViewById(R.id.txt_second);
        txtresult=(TextView)findViewById(R.id.txt_result);
        btnadd=(Button)findViewById(R.id.btn_add);
        btnadd.setOnClickListener(this);
        btnsub=(Button)findViewById(R.id.btn_sub);
        btnsub.setOnClickListener(this);
        btnmul=(Button)findViewById(R.id.btn_mul);
        btnmul.setOnClickListener(this);


        Intent intent = new Intent();
        intent.setAction("com.example.mathservice.IMathService");
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);


    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        String s1=txtfirst.getText().toString();
        String s2=txtsecond.getText().toString();

        int a=Integer.parseInt(s1);
        int b=Integer.parseInt(s2);


        if(v.equals(btnadd))
        {
            try {
                int result=cal.add(a,b);
                txtresult.setText(""+result);
            } catch (RemoteException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        else if(v.equals(btnsub))
        {
            try {
                int result=cal.sub(a,b);
                txtresult.setText(""+result);
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        else if(v.equals(btnmul))
        {
            try {
                int result=cal.mul(a,b);
                txtresult.setText(""+result);
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    private calculator mService;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = calculator.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };
}