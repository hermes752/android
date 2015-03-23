package com.example.cursomovil.todolistfragment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cursomovil.todolistfragment.R;
import com.example.cursomovil.todolistfragment.model.ToDo;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by cursomovil on 23/03/15.
 */
public class TodoAdapter extends ArrayAdapter<ToDo>{

       private int resource;

    public TodoAdapter(Context context, int resource, List<ToDo> objects) {
        super(context, resource, objects);
        this.resource=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout layout;

        if(convertView==null){
            layout=new LinearLayout(getContext());
            LayoutInflater li;
            String inflater= Context.LAYOUT_INFLATER_SERVICE;

            li=(LayoutInflater)getContext().getSystemService(inflater);
            li.inflate(resource,layout,true);

        }else{
            layout =(LinearLayout)convertView;
        }

        ToDo item=getItem(position);


        TextView task=(TextView)layout.findViewById(R.id.labeltask);
        TextView date=(TextView)layout.findViewById(R.id.datetask);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");

        task.setText(item.getTask());
        date.setText(sdf.format(item.getCreated()));


        return layout;
    }
}
