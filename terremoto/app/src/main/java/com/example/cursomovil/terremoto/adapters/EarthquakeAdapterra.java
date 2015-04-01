package com.example.cursomovil.terremoto.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cursomovil.terremoto.R;
import com.example.cursomovil.terremoto.model.EarthQuake;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by cursomovil on 25/03/15.
 */
public class EarthquakeAdapterra extends ArrayAdapter<EarthQuake> {

    private int resource;


    public EarthquakeAdapterra(Context context, int resource, List<EarthQuake> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout layout;

        if(convertView==null){
            layout =new RelativeLayout(getContext());
            LayoutInflater li;
            String inflater= Context.LAYOUT_INFLATER_SERVICE;

            li=(LayoutInflater)getContext().getSystemService(inflater);
            li.inflate(resource,layout,true);

        }else{
            layout =(RelativeLayout)convertView;
        }


        EarthQuake item=getItem(position);


        TextView task=(TextView)layout.findViewById(R.id.magni);
        TextView date=(TextView)layout.findViewById(R.id.datuak);
        TextView eguna=(TextView)layout.findViewById(R.id.eguna);

        task.setText(String.valueOf(item.getMagnitud()));
        date.setText(item.getPlace());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        eguna.setText(sdf.format(item.getTime()));

        return layout;
    }
}
