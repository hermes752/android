package com.example.cursomovil.terremoto.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.ListFragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cursomovil.terremoto.R;

import com.example.cursomovil.terremoto.SettingsActivity;
import com.example.cursomovil.terremoto.adapters.EarthquakeAdapterra;
import com.example.cursomovil.terremoto.database.EarthQuakeDB;
import com.example.cursomovil.terremoto.model.EarthQuake;
import com.example.cursomovil.terremoto.activity_detaille;
import com.example.cursomovil.terremoto.task.DownloadEarthquakesTask;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * <p/>
 * <p/>
 * interface.
 */
public class EarthQuakeFragment extends ListFragment implements DownloadEarthquakesTask.AddEarthQuackeInterface {


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */

    private String EARTHQUAKE = "EARTHQUAKE";
    public static final String MAG = "MAGNITUDE";
    public static final String PLACE = "PLACE";
    public static final String LAT = "lat";
    public static final String ID = "_id";

    private ArrayList<EarthQuake> quakeArray;
    private ArrayAdapter<EarthQuake> aa;
    private SharedPreferences prefs;
    EarthQuakeDB earthQuakeDB;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        quakeArray = new ArrayList<>();
        earthQuakeDB = new EarthQuakeDB(getActivity());


        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());


        DownloadEarthquakesTask task = new DownloadEarthquakesTask(getActivity(), this);
        task.execute(getString(R.string.earthquake_url));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = super.onCreateView(inflater, container, savedInstanceState);
        aa = new EarthquakeAdapterra(getActivity(), R.layout.earthquick_item, quakeArray);


        setListAdapter(aa);
        return layout;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        EarthQuake earth = quakeArray.get(position);
        Intent intent = new Intent(getActivity(), activity_detaille.class);
        intent.putExtra(ID,earth.get_id());
        intent.putExtra(MAG, earth.getMagnitud());
        intent.putExtra(PLACE, earth.getPlace());
        intent.putExtra(LAT, earth.getCoords().getLatitud());

        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();

        int minMag = Integer.parseInt(prefs.getString(MAG, "0"));

        quakeArray.clear();
        quakeArray.addAll(earthQuakeDB.getEarthQuakesByMagnitude(minMag));

        aa.notifyDataSetChanged();
    }


}
