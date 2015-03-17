package com.example.cursomovil.configchange;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class ActivityA extends ActionBarActivity {

    private final String DATA="data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d(" change", "ActivityA onCreate()");

        if(savedInstanceState !=null){
            String data=savedInstanceState.getString(DATA);
            Log.d("CHANGE", "ActivityA openB");
        }

        Button btnOpenB=(Button)findViewById(R.id.openB);
        Button close=(Button)findViewById(R.id.btnClose);

        btnOpenB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CHANGE"," ActivityA onClick()");
                Intent openB=new Intent(ActivityA.this,ActivityB.class); //ActivityA.this devuelve la instancia del activity
                startActivity(openB);
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CHANGE", " ActivityA onClick()");
                finish();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(" change", "ActivityA onStop()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(DATA,"DATA");
        super.onSaveInstanceState(outState);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String data=savedInstanceState.getString(DATA);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(" change","ActivityA onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(" change","ActivityA onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(" change","ActivityA onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(" change","ActivityA onStart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(" change","ActivityA onDestroy()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
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
