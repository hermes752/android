package com.example.cursomovil.calculadora1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    TextView zenbaki=(TextView)findViewById(R.id.textView);

    Button uno=(Button)findViewById(R.id.button1);
    Button dos=(Button)findViewById(R.id.button2);
    Button tres=(Button)findViewById(R.id.button3);
    Button cuatro=(Button)findViewById(R.id.button4);
    Button cinco=(Button)findViewById(R.id.button5);
    Button seis=(Button)findViewById(R.id.button6);
    Button siete=(Button)findViewById(R.id.button);
    Button ocho=(Button)findViewById(R.id.button7);
    Button nueve=(Button)findViewById(R.id.button8);
    Button cero=(Button)findViewById(R.id.button9);
    Button multi=(Button)findViewById(R.id.button10);
    Button divi=(Button)findViewById(R.id.button11);
    Button rest=(Button)findViewById(R.id.button12);
    Button punto=(Button)findViewById(R.id.button13);
    Button berdin=(Button)findViewById(R.id.button14);
    private int numero;
    calculadora a=new calculadora();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOnListener();
        numero=Integer.parseInt(a.getTotalString());
        zenbaki.setText(numero);
    }

    public void setOnListener(){

        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        siete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        nueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        divi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        berdin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
