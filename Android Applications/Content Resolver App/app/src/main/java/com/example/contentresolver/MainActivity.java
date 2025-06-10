package com.example.contentresolver;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtSearch;
    Button btnSearch;
    TextView lblMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSearch=(EditText)findViewById(R.id.txt_search);
        lblMessage=(TextView)findViewById(R.id.lbl_message);

        btnSearch=(Button)findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
// TODO Auto-generated method stub
        if(v.equals(btnSearch))
        {
            String searchDate=txtSearch.getText().toString();
            String where="note_date=?";
            Cursor cursor=getContentResolver().query(Uri.parse("content://com.example.notesprovider/notes")
                    ,new String[]{"note_date","content"},where, new String[]{searchDate},null);
            if(cursor!=null&&cursor.moveToNext())
            {

                String ndate=cursor.getString(0);
                String content=cursor.getString(1);

                lblMessage.setText(ndate+" "+content+"\n");
            }
            else
            {
                Toast.makeText(getBaseContext(),"No Data Available",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

}