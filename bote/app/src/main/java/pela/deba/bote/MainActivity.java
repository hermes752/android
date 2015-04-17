package pela.deba.bote;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private EditText izenak;
    private ListView zeintzuk;
    private Button gorde;
    private Button borratu;
    private Button eraman;
    private TextView irabazlea;


    ArrayList<String> nombres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        izenak=(EditText)findViewById(R.id.izenak);
        zeintzuk=(ListView)findViewById(R.id.zeintzuk);
        irabazlea=(TextView)findViewById(R.id.irabazlea);
        listeners();


    }

    public void listeners(){

        nombres=new ArrayList<>();
        gorde=(Button)findViewById(R.id.guardar);
        eraman=(Button)findViewById(R.id.llevar);
        borratu=(Button)findViewById(R.id.borratu);
        borratu.setEnabled(false);


        eraman.setEnabled(false);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                nombres );
        gorde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombres.add(izenak.getText().toString());
                arrayAdapter.notifyDataSetChanged();
                izenak.setText("");
                irabazlea.setText("Irabazlea:");
                zeintzuk.setAdapter(arrayAdapter);
                eraman.setEnabled(true);
                borratu.setEnabled(true);


            }
        });
        borratu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               nombres.clear();
                arrayAdapter.clear();
                zeintzuk.setAdapter(arrayAdapter);
                eraman.setEnabled(false);
                borratu.setEnabled(false);
                if(gorde.isEnabled()==false){
                    gorde.setEnabled(true);
                }


            }
        });

       /* ikusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zeintzuk.setAdapter(arrayAdapter);
                eraman.setEnabled(true);

            }
        });*/
        eraman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rn = new Random();
                int answer = rn.nextInt(nombres.size());

                irabazlea.setText("Irabazlea: "+nombres.get(answer));










            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is preansent.
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
