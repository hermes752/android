package tk.mirenamorrortu.earthquakes.mapas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import tk.mirenamorrortu.earthquakes.Model.EarthQuake;

/**
 * Created by cursomovil on 9/04/15.
 */
public class MapsActivity extends MapFragment implements GoogleMap.OnMapLoadedCallback {

private List<EarthQuake> earthQuakes;
    GoogleMap map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout= super.onCreateView(inflater, container, savedInstanceState);

        map=getMap();

        map.setOnMapLoadedCallback(this);
        return layout;
    }


    @Override
    public void onMapLoaded() {
        GoogleMap map=getMap();
        LatLngBounds.Builder builder=new LatLngBounds.Builder();

        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        for(EarthQuake earthquake1:earthQuakes){
            LatLng point=new LatLng(earthquake1.getCoords().getLng(), earthquake1.getCoords().getLat());
            MarkerOptions marker=new MarkerOptions()
                    .position(point)
                    .snippet(earthquake1.getCoords().toString());
            map.addMarker(marker);
            builder.include(marker.getPosition());
        }

        LatLngBounds bounds=builder.build();
        CameraUpdate cu= CameraUpdateFactory.newLatLngBounds(bounds,0);
        map.moveCamera(cu);
    }
}
