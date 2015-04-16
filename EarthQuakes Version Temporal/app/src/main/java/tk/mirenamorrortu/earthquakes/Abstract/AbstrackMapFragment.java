package tk.mirenamorrortu.earthquakes.Abstract;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;

import java.util.List;

import tk.mirenamorrortu.earthquakes.DataBase.EarthQuakesDB;
import tk.mirenamorrortu.earthquakes.Model.EarthQuake;
import tk.mirenamorrortu.earthquakes.mapas.MapsUnaiFragmet;

/**
 * Created by cursomovil on 13/04/15.
 */
public abstract class AbstrackMapFragment extends MapsUnaiFragmet implements GoogleMap.OnMapLoadedCallback{


    protected EarthQuakesDB earthQuakesDB;
    private EarthQuake earthQuake;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        earthQuakesDB=new EarthQuakesDB(getActivity());



    }

    abstract protected void getData();

    abstract protected void showData();
}
