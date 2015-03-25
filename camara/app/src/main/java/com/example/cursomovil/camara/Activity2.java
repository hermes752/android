package com.example.cursomovil.camara;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Activity2 extends ActionBarActivity {

    TextView ikus;
    TextView gorde;
    Button botoia;
    Intent intent,intent2;
    Button itxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        ikus=(TextView)findViewById(R.id.ikusi);
        gorde=(TextView)findViewById(R.id.gorde);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("bidali");
            ikus.setText(j);
        }


        botoia=(Button)findViewById(R.id.button1);
        itxi=(Button)findViewById(R.id.itxi);


        botoia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    gorde();

            }
        });

        itxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);

                finish();
            }
        });


    }


    public void gorde(){


        String message=gorde.getText().toString();
        if(message.length()>0) {
            intent2=getIntent();
            intent2.putExtra("gorde", gorde.getText().toString());

            setResult(RESULT_OK, intent2);
            finish();
        }else
        {
            Toast toast= Toast.makeText(Activity2.this,getResources().getString(R.string.no_text),Toast.LENGTH_SHORT);
            toast.show();
        }


    }


}
