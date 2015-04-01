package com.example.cursomovil.Geolocation;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.cursomovil.Geolocation.listeners.gps;


public class MainActivity extends ActionBarActivity implements  gps.ADDLocationInterface {

    private TextView alti;
    private TextView lati;
    private TextView altu;
    private TextView velo;
    private String provider;
    LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alti=(TextView)findViewById(R.id.latitud);
        lati=(TextView)findViewById(R.id.longitud);
        altu=(TextView)findViewById(R.id.altura);
        velo=(TextView)findViewById(R.id.velocidad);

        getLocationProvider();
        listenerLocationChanged();

    }

    private void getLocationProvider(){

        locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria=new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setSpeedRequired(true);
        criteria.setAltitudeRequired(true);
        provider=locationManager.getBestProvider(criteria,true);
        Log.d("GEO", provider);

    }

    private void listenerLocationChanged(){

        int t=500;
        int distance=5;

        gps gps=new gps();

        locationManager.requestLocationUpdates(provider,t,distance,gps);
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

    @Override
    public void addLocation(Location location) {
        lati.setText(String.valueOf(location.getLatitude()));
    }
}
