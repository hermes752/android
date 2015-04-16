package com.example.cursomovil.bote;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by cursomovil on 16/04/15.
 */
public class Dialogoa extends DialogFragment {

    private String irabazlea;


    public void setIrabazlea(String irabazlea) {
        this.irabazlea = irabazlea;
    }


    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Set the message to display.
        builder.setMessage("Gaurko irabazlea: "+irabazlea);

        // Set a listener to be invoked when the positive button of the dialog
        // is pressed.
        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
            }
        });



        // Create the AlertDialog object and return it
        return builder.create();
    }
}
