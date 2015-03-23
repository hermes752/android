package com.example.cursomovil.todolistfragment;

import android.app.Fragment;
import android.app.ListFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.cursomovil.todolistfragment.model.ToDo;


public class MainActivity extends ActionBarActivity implements InputFragment.TODOItemListener {

    private final String TODO="TODO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    @Override
    public void addTodo(ToDo todo) {


        InputFragment.TODOItemListener listFragment;
        try{
            listFragment=(InputFragment.TODOItemListener)getFragmentManager().findFragmentById(R.id.listfragment);
        }catch(ClassCastException ex){
            throw new ClassCastException(this.toString()+"error");
        }

        listFragment.addTodo(todo);


    }
}
