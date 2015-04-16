package tk.mirenamorrortu.earthquakes;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import tk.mirenamorrortu.earthquakes.Abstract.AbstrackMapFragment;
import tk.mirenamorrortu.earthquakes.Activities.SettingsActivity;
import tk.mirenamorrortu.earthquakes.DataBase.EarthQuakesDB;
import tk.mirenamorrortu.earthquakes.Fragments.EarthQuakeListFragment;
import tk.mirenamorrortu.earthquakes.Managers.EarthQuakeAlarmManager;
import tk.mirenamorrortu.earthquakes.Services.DownloadEarthquakeService;
import tk.mirenamorrortu.earthquakes.Tabs.TabMenusListener;
import tk.mirenamorrortu.earthquakes.mapas.MapsUnaiFragmet;
import tk.mirenamorrortu.earthquakes.task.DownloadEarQuakesTask;


public class MainActivity extends Activity implements DownloadEarQuakesTask.AddEarthQuakeInterface{
    public static final int PREFS_ACTIVITY = 0;
    private String EARTHQUAKE_PREFS = "PREFERENCES";

    private TabMenusListener t;
    ActionBar actionBar;
    public interface ActualizarListaInterface{
        public void ActualizarLista();
    }

    private ActualizarListaInterface target;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        target = (ActualizarListaInterface) this.getFragmentManager().findFragmentById(R.id.fragmentLayout);
        //downloadEarthQuakes();
        checkToSettedAlarm();
        //Comprobamos si hay que lanzar la alarma:
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean autorefresh = Boolean.parseBoolean(prefs.getString(this.getString(R.string.autorefresh), "false"));
        if (autorefresh){
            long freq = Long.parseLong(prefs.getString(this.getString(R.string.frequency), "1"));
            freq = freq * 60000;
            EarthQuakeAlarmManager.setAlarm(this, freq);
        }


       CreateTabs();

    }

    private void checkToSettedAlarm() {
        String KEY = "LAUNCHED_BEFORE";
        SharedPreferences pref = getSharedPreferences(EARTHQUAKE_PREFS, Activity.MODE_PRIVATE);
        if(!pref.getBoolean(KEY, false)){
            long interval = getResources().getInteger(R.integer.default_interval) * 60 * 1000;
            EarthQuakeAlarmManager.setAlarm(this, interval);
            pref.edit().putBoolean(KEY, true).apply();
        }

    }

    private void downloadEarthQuakes() {
        /*Con AsynTask
        DownloadEarQuakesTask task = new DownloadEarQuakesTask(this.getBaseContext(), this);
        task.execute(getString(R.string.eartquakes_url));*/

        Intent Download = new Intent (this, DownloadEarthquakeService.class);
        startService(Download);
    }


    private void CreateTabs(){


        final ActionBar bar = getActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);

        bar.addTab(bar.newTab()
                .setText("Lista")
                .setTabListener(new TabMenusListener<EarthQuakeListFragment>(
                        this, R.id.fragmentLayout, EarthQuakeListFragment.class)));

        bar.addTab(bar.newTab()
                .setText("Mapa")
                .setTabListener(new TabMenusListener<MapsUnaiFragmet>(
                        this, R.id.fragmentLayout, MapsUnaiFragmet.class)));




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
        if (id == R.id.action_refresh) {
            Intent preferences = new Intent(this, SettingsActivity.class);

            startActivityForResult(preferences, PREFS_ACTIVITY);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void notifyTotal(int total) {
        String msg = getString(R.string.num_earthquakes, total);
        Toast t = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        t.show();
        target.ActualizarLista();
    }


}
