package com.example.cursomovil.todolistfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.cursomovil.todolistfragment.adapters.TodoAdapter;
import com.example.cursomovil.todolistfragment.dummy.DummyContent;
import com.example.cursomovil.todolistfragment.model.ToDo;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A fragment representing a list of Items.

 */
public class todoFragment extends ListFragment implements InputFragment.TODOItemListener {

    private ArrayList<ToDo> todos;
    private ArrayAdapter<ToDo> aa;
    private final String TODOS="final";
    public static final String Todo_key="key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout= super.onCreateView(inflater, container, savedInstanceState);

        todos=new ArrayList<>();
        aa=new TodoAdapter(getActivity(),R.layout.todo_list_items,todos);

        if(savedInstanceState !=null){

            ArrayList<ToDo> tmp=savedInstanceState.getParcelableArrayList(TODOS);
            todos.addAll(tmp);
        }

        setListAdapter(aa);

        return layout;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        ToDo todo=todos.get(position);
        Intent intent=new Intent(getActivity(),acitivity_detaille.class);
        intent.putExtra("TODO_ITEM",Todo_key);

        startActivity(intent);



    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putParcelableArrayList(TODOS, todos);

        super.onSaveInstanceState(outState);
    }


    @Override
    public void addTodo(ToDo todo) {
        todos.add(0,todo);
        aa.notifyDataSetChanged();
    }
}





