package com.example.cursomovil.terremoto;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.cursomovil.terremoto.R;
import com.example.cursomovil.terremoto.fragments.EarthQuakeFragment;
import com.example.cursomovil.terremoto.model.EarthQuake;
import com.example.cursomovil.terremoto.task.DownloadEarthquakesTask;

import org.w3c.dom.Text;

public class activity_detaille extends ActionBarActivity {

    private EarthQuake earthQuake;
    private TextView labeltask;
    private TextView labeldate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_detaille);

        labeltask=(TextView)findViewById(R.id.idtask);
        labeldate=(TextView)findViewById(R.id.idDate);
        Intent detailIntent=getIntent();

        double magn=detailIntent.getDoubleExtra(EarthQuakeFragment.MAG, 0.0);
        labeltask.setText(String.valueOf(magn));
        labeldate.setText(detailIntent.getStringExtra(EarthQuakeFragment.PLACE));


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_detaille, menu);
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
