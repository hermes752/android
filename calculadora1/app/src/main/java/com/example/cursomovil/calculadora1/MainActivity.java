package com.example.cursomovil.calculadora1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.cursomovil.calculadora1.Listeners.*;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements  NumberOnclickListener.NumberListenerInteface, OperationOnClickListener.OperationListenerInteface{
    TextView zenbaki=(TextView)findViewById(R.id.textView);

    /*
    Button uno=(Button)findViewById(R.id.button1);
    Button dos=(Button)findViewById(R.id.button2);
    Button tres=(Button)findViewById(R.id.button3);
    Button cuatro=(Button)findViewById(R.id.button4);
    Button cinco=(Button)findViewById(R.id.button5);
    Button seis=(Button)findViewById(R.id.button6);
    Button siete=(Button)findViewById(R.id.button);
    Button ocho=(Button)findViewById(R.id.button7);
    Button nueve=(Button)findViewById(R.id.button8);
    Button cero=(Button)findViewById(R.id.button9);
    Button multi=(Button)findViewById(R.id.button10);
    Button divi=(Button)findViewById(R.id.button11);
    Button rest=(Button)findViewById(R.id.button12);
    Button punto=(Button)findViewById(R.id.button13);
    Button berdin=(Button)findViewById(R.id.button14);
    */
    private ArrayList<Button> numberButton;
    private ArrayList<Button> operationButton;
    private final String CALC="CALC";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       getButtonsFromLayout();
    }

    public void getButtonsFromLayout(){

        String[] numbers={"button1","button2","button3","button4","button5","button6","button7","button8","button8","button9","button10","button11","button12","button13","button14"};

        for(int i=0;i<numbers.length;i++){
            String id;
            Button btn;
                id="btn".concat(numbers[i]);
                btn=(Button)findViewById(getResources().getIdentifier(id,"id",getPackageName()));
            numberButton.add(btn);


        }
        String[] operation={"add","sub","multiply","divide"};

        for(int i=0;i<numbers.length;i++){
            String id;
            Button btn;
            id="btn".concat(numbers[i]);
            btn=(Button)findViewById(getResources().getIdentifier(id,"id",getPackageName()));
            operationButton.add(btn);


        }
    }

    public void addEventListeners(){
        View.OnClickListener numberOnclickListener= new NumberOnclickListener(this);
        View.OnClickListener operationOnclickListener= new OperationOnClickListener(this);
        for(int i=0;i<numberButton.size();i++){

            numberButton.get(i).setOnClickListener(numberOnclickListener);
        }

        for(int i=0;i<numberButton.size();i++){

            operationButton.get(i).setOnClickListener(operationOnclickListener);
        }

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

    public void setNumber(String number){

    }

    public void setOperation(String operation){

    }


}
