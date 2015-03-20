package com.example.cursomovil.todolistfragment;


import android.app.Activity;
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

        public interface TODOItemListener{
            public void addTodo(String todo)


        }

        private Button btnAdd;
        private EditText todoText;
        private Activity target;

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            try{

            }

            this.target=activity;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View layout=inflater.inflate(R.layout.fragment_input, container, false);

            btnAdd=(Button)layout.findViewById(R.id.buttonAdd);
            todoText=(EditText)layout.findViewById(R.id.inputText);

            addEventListener();

            return layout;
        }

        private void addEventListener(){

            btnAdd.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    String todo=todoText.getText().toString();


                }
            });


        }

}
