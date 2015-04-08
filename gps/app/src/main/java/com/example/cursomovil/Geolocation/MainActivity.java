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

import com.example.cursomovil.Geolocation.listeners.Gps;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends ActionBarActivity implements  Gps.ADDLocationInterface, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private TextView altu;
    private TextView longi;
    private TextView lati;
    private TextView velo;
    private String provider;
    private GoogleApiClient mGoogleApiClient;
    LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lati=(TextView)findViewById(R.id.latitud);
        longi=(TextView)findViewById(R.id.longitud);
        altu=(TextView)findViewById(R.id.altura);
        velo=(TextView)findViewById(R.id.velocidad);

        getLocationProvider();
        listenerLocationChanged();

    }

    private void getLocationProvider(){

        locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria=new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setSpeedRequired(true);
        criteria.setAltitudeRequired(true);
        provider=locationManager.getBestProvider(criteria,true);
        Log.d("GEO", provider);

    }

    private void listenerLocationChanged(){

        int t=500;
        int distance=5;

        Gps gps =new Gps(this);

        locationManager.requestLocationUpdates(provider,t,distance, gps);
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
        longi.setText(String.valueOf(location.getLongitude()));
        lati.setText(String.valueOf(location.getLatitude()));




    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
