package com.example.cursomovil.terremoto;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.cursomovil.terremoto.R;
import com.example.cursomovil.terremoto.database.EarthQuakeDB;
import com.example.cursomovil.terremoto.fragments.EarthQuakeFragment;
import com.example.cursomovil.terremoto.mapas.MapsFragmentActivity;
import com.example.cursomovil.terremoto.model.EarthQuake;
import com.example.cursomovil.terremoto.task.DownloadEarthquakesTask;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class activity_detaille extends ActionBarActivity {

    private EarthQuake earthQuake;
    private TextView labeltask;
    private TextView labeldate;

    TextView magnitud;
    TextView _id;
    TextView Fecha;
    TextView Place;
    TextView _url;
    MapsFragmentActivity maps;


    EarthQuake eq;

    private void SetViews(){
        magnitud = (TextView) findViewById(R.id.magni);
        _id = (TextView) findViewById(R.id.idtask);
        Fecha = (TextView) findViewById(R.id.idDate);


        maps = (MapsFragmentActivity) getFragmentManager().findFragmentById(R.id.map);
        //maps = (Fragment) findViewById(R.id.maps_frag);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_detaille);

        SetViews();

        Intent detailIntent = getIntent();

        //Si nos pasaran el id del terremoto, podríamos pedirselo a la BD
        EarthQuakeDB db = new EarthQuakeDB(this);
        eq = db.GetEarthQuake(detailIntent.getStringExtra(EarthQuakeFragment.ID));
        // eq = detailIntent.getParcelableExtra(EarthQuakeListFragment.EARTHQUAKE);
        List<EarthQuake> listadeearthquakes = new ArrayList<>();
        listadeearthquakes.add(0, eq);

        populateView();
        showMap(listadeearthquakes);


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
