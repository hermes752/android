package com.example.cursomovil.todolist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private ArrayList<String> todos;
    private Button btnadd;
    private TextView input;
    private ListView list;
    private ArrayAdapter<String> aa;
    private final String TODOS_KEY="TODOS_ARRAY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todos=new ArrayList<String>();
        aa=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, todos);


       btnadd=(Button)findViewById(R.id.addbutton);
       input=(TextView)findViewById(R.id.todotext);
       list=(ListView)findViewById(R.id.todolistview);

        list.setAdapter(aa);
        this.addEventListeners();

    }


private void addEventListeners(){

    btnadd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String todo=input.getText().toString();
            todos.add(0, todo);
            aa.notifyDataSetChanged();
        }
    });
}

    @Override
    protected void onResume() {
        super.onResume();
        aa.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList(TODOS_KEY,todos);
        super.onSaveInstanceState(outState);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        todos.addAll(savedInstanceState.getStringArrayList(TODOS_KEY));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
