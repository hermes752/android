package com.example.cursomovil.terremoto.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cursomovil.terremoto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Settings_fragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(getActivity());
        prefs.registerOnSharedPreferenceChangeListener(this);

        addPreferencesFromResource(R.xml.userpreferences);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        String PREF_AUTO_UPDATE=getString(R.string.PREF_AUTO_UPDATE);
        String MINIMO=getString(R.string.PREF_LIST);
        String TIME=getString(R.string.PREF_TIME);

        if(key.equals(PREF_AUTO_UPDATE)){

        }else if(key.equals(TIME)){

        }

    }
}
