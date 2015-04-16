package com.example.cursomovil.terremoto.mapas;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cursomovil.terremoto.model.EarthQuake;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsFragmentActivity extends MapFragment implements GoogleMap.OnMapLoadedCallback {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private List<EarthQuake> earthQuakes;

    public void setEarthQuakes(List<EarthQuake>earthQuakes){
        this.earthQuakes=earthQuakes;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout= super.onCreateView(inflater, container, savedInstanceState);

        mMap=getMap();
        getMap().setOnMapLoadedCallback(this);
        return layout;
    }




    @Override
    public void onMapLoaded() {
        GoogleMap map=getMap();
        LatLngBounds.Builder builder=new LatLngBounds.Builder();

        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        for(EarthQuake earthquake1:earthQuakes){
            LatLng point=new LatLng(earthquake1.getCoords().getLongitud(), earthquake1.getCoords().getLatitud());
            MarkerOptions marker=new MarkerOptions()
                    .position(point)
                    .title(earthquake1.getPlace() + ". Magnitude: " + earthquake1.getMagnitudeFormatted() )
                    .snippet(earthquake1.getCoords().toString());


            map.addMarker(marker);
            builder.include(marker.getPosition());
        }

        LatLngBounds bounds=builder.build();
        CameraUpdate cu= CameraUpdateFactory.newLatLngBounds(bounds, 0);
        map.moveCamera(cu);
    }

    }

