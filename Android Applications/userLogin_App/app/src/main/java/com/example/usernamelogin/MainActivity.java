package com.example.usernamelogin;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText txtuser,txtpwd;
    Button txtlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtuser=(EditText)findViewById(R.id.txt_user);
        txtpwd=(EditText)findViewById(R.id.txt_pwd);
        txtlogin=(Button)findViewById(R.id.txt_login);
        txtlogin.setOnClickListener(this);
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
    @Override
    public void onClick(View arg0) {
// TODO Auto-generated method stub
        if(arg0.equals(txtlogin))
        {
            String username=txtuser.getText().toString();
            String password=txtpwd.getText().toString();
            if(username.equals(password))
            {
                Intent it=new Intent(this, MyNextActivity.class);
                startActivity(it);
            }
            else
            {
                Toast.makeText(getBaseContext(), "LOGIN FAILED",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}
