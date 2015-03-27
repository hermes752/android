package com.example.cursomovil.terremoto.task;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.cursomovil.terremoto.R;
import com.example.cursomovil.terremoto.database.EarthQuakeDB;
import com.example.cursomovil.terremoto.model.EarthQuake;
import com.example.cursomovil.terremoto.model.coordenada;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by cursomovil on 25/03/15.
 */
public class DownloadEarthquakesTask extends AsyncTask<String, EarthQuake, Integer> {

    private EarthQuakeDB earthQuakeDB;
    public interface AddEarthQuackeInterface {

    }

    private String EARTHQUAKE = "EARTHQUAKE";

    private AddEarthQuackeInterface target;

    public DownloadEarthquakesTask(Context context,AddEarthQuackeInterface target) {
        this.target = target;
         earthQuakeDB=new EarthQuakeDB(context);

    }


    @Override
    protected Integer doInBackground(String... urls) {
        if (urls.length > 0) {
            updateEarthQuakes(urls[0]);
        }


        return null;
    }


    private void updateEarthQuakes(String earthquakesFeed) {

        JSONObject json;


        try {
            URL url = new URL(earthquakesFeed);

            URLConnection connection = url.openConnection();

            HttpURLConnection httpConnection = (HttpURLConnection) connection;

            int responseCode = httpConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {


                BufferedReader streamReader = new BufferedReader(
                        new InputStreamReader(
                                httpConnection.getInputStream(), "UTF-8"));
                StringBuilder responseStrBuilder = new StringBuilder();

                String inputStr;
                while ((inputStr = streamReader.readLine()) != null)
                    responseStrBuilder.append(inputStr);

                json = new JSONObject(responseStrBuilder.toString());
                JSONArray earthquakes = json.getJSONArray("features");

                for (int i = earthquakes.length() - 1; i >= 0; i--) {
                    processEarthQuakeTask(earthquakes.getJSONObject(i));
                }
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void processEarthQuakeTask(JSONObject jsonObject) {


        try {

            JSONArray Jsoncoords = jsonObject.getJSONObject("geometry").getJSONArray("coordinates");
            coordenada coords = new coordenada(Jsoncoords.getDouble(0), Jsoncoords.getDouble(1), Jsoncoords.getDouble(2));

            String id = jsonObject.getString("id");
            JSONObject propietis = jsonObject.getJSONObject("properties");
            EarthQuake earthQuake = new EarthQuake();
            earthQuake.set_id(jsonObject.getString("id"));
            earthQuake.setPlace(propietis.getString("place"));
            earthQuake.setMagnitud(propietis.getDouble("mag"));
            earthQuake.setTime(propietis.getLong("time"));
            earthQuake.setUrl(propietis.getString("url"));
            earthQuake.setCoords(coords);


            publishProgress(earthQuake);
            Log.d("TRAZA", earthQuake.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onProgressUpdate(EarthQuake... earthQuakes) {
        super.onProgressUpdate(earthQuakes);

    }
}
