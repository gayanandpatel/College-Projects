package com.example.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnjson;
    TextView txtdisplayresults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnjson = findViewById(R.id.btn_parsejson);
        txtdisplayresults = findViewById(R.id.txt_resultdisplay);
        btnjson.setOnClickListener(this);
    }
            @Override
            public void onClick(View v) {
                try{
                    InputStream is = getAssets().open("samplecity.json");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    String json = new String(buffer, "UTF-8");
                    JSONArray jsonArray = new JSONArray(json);
                    txtdisplayresults.setText(" ");
                    for(int i = 0;i<jsonArray.length();i++)
                    {
                        JSONObject obj =jsonArray.getJSONObject(i);
                        txtdisplayresults.setText(txtdisplayresults.getText() + "\n Name: " + obj.getString("name")+ "\n");
                        txtdisplayresults.setText(txtdisplayresults.getText() + " Latitude: " + obj.getString("lat")+ "\n");
                        txtdisplayresults.setText(txtdisplayresults.getText() + " Longitude: " + obj.getString("long")+ "\n");
                        txtdisplayresults.setText(txtdisplayresults.getText() + " Temperature: " + obj.getString("temperature")+ "\n");
                        txtdisplayresults.setText(txtdisplayresults.getText() + " Humidity: " + obj.getString("humidity")+ "\n");
                        txtdisplayresults.setText(txtdisplayresults.getText() + "---------------------------- ");
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }