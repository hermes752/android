package com.example.cursomovil.terremoto2.Fragments;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cursomovil.terremoto2.Activities.SettingsActivity;
import com.example.cursomovil.terremoto2.MainActivity;
import com.example.cursomovil.terremoto2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends PreferenceFragment {






    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        

        //Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.userpreferences);

    }

}
