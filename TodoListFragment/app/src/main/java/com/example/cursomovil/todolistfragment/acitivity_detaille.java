package com.example.cursomovil.todolistfragment;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.cursomovil.todolistfragment.model.ToDo;

import java.util.Date;


public class acitivity_detaille extends ActionBarActivity {



private ToDo todo;
private TextView labeltask;
private TextView labeldate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitivity_detaille);

        labeltask=(TextView)findViewById(R.id.idtask);
        labeldate=(TextView)findViewById(R.id.idDate);


        Intent detailIntent=getIntent();
        todo=detailIntent.getParcelableExtra(todoFragment.Todo_key);

        populateView();
    }

    private void populateView(){

        labeltask.setText(todo.getTask());
        labeldate.setText(todo.getCreated().toString());
    }

}
