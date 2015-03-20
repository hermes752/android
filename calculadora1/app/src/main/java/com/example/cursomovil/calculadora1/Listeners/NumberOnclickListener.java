package com.example.cursomovil.calculadora1.Listeners;

import android.view.View;
import android.widget.Button;


/**
 * Created by cursomovil on 20/03/15.
 */
public class NumberOnclickListener implements View.OnClickListener {

    public interface NumberListenerInteface{
        public void setNumber(String number);

    }

    private NumberListenerInteface target;
    public NumberOnclickListener(NumberListenerInteface target){

        this.target=target;
    }


    @Override
    public void onClick(View v) {
        Button btn=(Button) v;
        target.setNumber(btn.getText().toString());
    }
}
