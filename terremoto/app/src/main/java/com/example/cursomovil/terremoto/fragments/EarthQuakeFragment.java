package com.example.cursomovil.terremoto.fragments;

import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.cursomovil.terremoto.R;

import com.example.cursomovil.terremoto.adapters.EarthquakeAdapterra;
import com.example.cursomovil.terremoto.model.EarthQuake;
import com.example.cursomovil.terremoto.task.DownloadEarthquakesTask;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * <p/>
 * <p/>
 * interface.
 */
public class EarthQuakeFragment extends ListFragment implements DownloadEarthquakesTask.AddEarthQuackeInterface{


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */

    private String EARTHQUAKE = "EARTHQUAKE";

    private ArrayList<EarthQuake> quakeArray;
    private ArrayAdapter<EarthQuake> aa;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        quakeArray = new ArrayList<>();
        DownloadEarthquakesTask task=new DownloadEarthquakesTask(this);
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
    public void addEarthQuake(EarthQuake earthquake) {
        quakeArray.add(0,earthquake);
        aa.notifyDataSetChanged();
    }
}
