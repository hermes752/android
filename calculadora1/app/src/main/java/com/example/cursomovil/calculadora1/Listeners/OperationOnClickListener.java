package com.example.cursomovil.calculadora1.Listeners;

import android.view.View;
import android.widget.Button;

/**
 * Created by cursomovil on 20/03/15.
 */
public class OperationOnClickListener implements View.OnClickListener {

    public interface OperationListenerInteface{
        public void setOperation(String number);

    }

    private OperationListenerInteface target;
    public OperationOnClickListener(OperationListenerInteface target){

        this.target=target;
    }

    @Override
    public void onClick(View v) {

        Button btn=(Button) v;
        target.setOperation(btn.getText().toString());
    }
}
