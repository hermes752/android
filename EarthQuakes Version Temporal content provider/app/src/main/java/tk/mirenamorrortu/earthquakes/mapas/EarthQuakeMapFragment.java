package tk.mirenamorrortu.earthquakes.mapas;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import tk.mirenamorrortu.earthquakes.Abstract.AbstrackMapFragment;
import tk.mirenamorrortu.earthquakes.Fragments.EarthQuakeListFragment;
import tk.mirenamorrortu.earthquakes.Model.EarthQuake;

/**
 * Created by cursomovil on 13/04/15.
 */
public class EarthQuakeMapFragment extends AbstrackMapFragment {
    private SharedPreferences pref;
    private List<EarthQuake> earthQuakes;
    private EarthQuake earthquake;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref= PreferenceManager.getDefaultSharedPreferences(getActivity());
        setHasOptionsMenu(true);
    }

    @Override
    public void onResume() {
        super.onResume();




    }

    @Override



    protected void getData() {


        String id=getActivity().getIntent().getStringExtra(EarthQuakeListFragment.ID_EARTHQUAKE);
        earthquake=earthQuakesDB.GetEarthQuake(id);



    }

    @Override
    protected void showData() {



    }

    public void createMarker(EarthQuake earthquake){

    }




}

