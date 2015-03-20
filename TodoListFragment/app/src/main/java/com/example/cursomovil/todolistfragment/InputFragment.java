package com.example.cursomovil.todolistfragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {


    private Button btnAdd;
    private EditText todoText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout=inflater.inflate(R.layout.fragment_input, container, false);

        btnAdd=(Button)layout.findViewById(R.id.buttonAdd);
        todoText=(EditText)layout.findViewById(R.id.inputText);



        return layout;
    }


}
