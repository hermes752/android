package com.example.cursomovil.camara;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity{

    private Button enviar;
    private EditText bidali;
    private EditText hartu;
    private ImageView irudi;
    private Button argazki;
    private Intent intent;
    private final int kode=1;
    static final int REQUEST_IMAGE_CAPTURE = 2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviar=(Button)findViewById(R.id.sendbutton);

        bidali=(EditText)findViewById(R.id.bidali);
        hartu=(EditText)findViewById(R.id.hartu);
        irudi=(ImageView)findViewById(R.id.irudia);
        argazki=(Button)findViewById(R.id.argazkia);


       enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarIntent();

            }
        });

        argazki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();

            }
        });


    }

    public void enviarIntent(){

intent=new Intent(this, Activity2.class);
        String message=bidali.getText().toString();
        if(message.length()>0) {
            intent.putExtra("bidali", bidali.getText().toString());
            startActivityForResult(intent, kode);
        }else
        {
            Toast toast= Toast.makeText(MainActivity.this,getResources().getString(R.string.no_text),Toast.LENGTH_SHORT);
            toast.show();
        }


    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode){

            case(kode):
                if(resultCode== Activity.RESULT_OK){

                    hartu.setText(data.getStringExtra("gorde"));
                }
                break;
            case(REQUEST_IMAGE_CAPTURE):
                if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    irudi.setImageBitmap(imageBitmap);
                }





        }



    }
}
