package com.example.texttospeech;

import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        TextToSpeech.OnInitListener {
    Button btnspeak;
    EditText txtspeak;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtspeak = (EditText)findViewById(R.id.edttxttype);
        btnspeak = (Button)findViewById(R.id.btnspeech);
        btnspeak.setOnClickListener(this);
        textToSpeech = new TextToSpeech(getBaseContext(),this);
        textToSpeech.setLanguage(Locale.UK);
    }
    @Override
    public void onClick(View v)
    {
        String text = txtspeak.getText().toString();
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
    @Override
    public void onInit(int status)
    {
        if(status != TextToSpeech.ERROR)
        {
            Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_LONG).show();
        }
    }
}
