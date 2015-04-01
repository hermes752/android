package com.example.cursomovil.terremoto.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;

import com.example.cursomovil.terremoto.model.EarthQuake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cursomovil on 27/03/15.
 */
public class EarthQuakeDB {

    private EarthQuakeOpenHelper helper;
    private SQLiteDatabase db;
    private String DATABASE_TABLE = "earthquakes.db";

    private EarthQuake earthQuake;
    private static final String _ID = "_id";
    private static final String MAGNITUDE = "magnitude";
    private static final String DATA = "time";
    private static final String PLACE = "pace";
    private static final String LAT = "lat";
    private static final String LONG = "long";
    private static final String DEPTH = "depth";
    private static final String URL = "url";

    private ArrayList<EarthQuake> query;



    public EarthQuakeDB(Context context) {
        this.helper = new EarthQuakeOpenHelper(context, EarthQuakeOpenHelper.DATABASE_NAME, null, EarthQuakeOpenHelper.DATABASE_VERSION);
        this.db = helper.getWritableDatabase();
    }


    private static final String[] ALL_COLUMNS = {

            _ID, PLACE, MAGNITUDE, LAT, LONG, DEPTH, URL, DATA,

    };


    public void datuak_sartu(EarthQuake earthQuake) {


        //	Create	a	new	row	of	values	to	insert.

        ContentValues newValues = new ContentValues();

        //	Assign	values	for	each	row.

        newValues.put("_id", earthQuake.get_id());

        newValues.put("pace", earthQuake.getPlace());

        newValues.put("magnitude", earthQuake.getMagnitud());
        newValues.put("lat", earthQuake.getCoords().getLatitud());
        newValues.put("long", earthQuake.getCoords().getLatitud());
        newValues.put("depth", earthQuake.getCoords().getDepth());
        newValues.put("url", earthQuake.getUrl()
        );
        newValues.put("time", earthQuake.getTime().getTime());

        //	[	...	Repeat	for	each	column	/	value	pair	...	]

        //	Insert	the	row	into	your	table


        try {
            db.insertOrThrow(EarthQuakeOpenHelper.DATABASE_TABLE, null, newValues);
        } catch (SQLiteException ex) {

        }


    }


    private static class EarthQuakeOpenHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "earthquakes.db";
        private static final String DATABASE_TABLE = "EARTHQUAKES";
        private static final int DATABASE_VERSION = 2;

        //	SQL	Statement	to	create	a	new	database.
        private static final String DATABASE_CREATE = "CREATE TABLE " + DATABASE_TABLE + "(_id TEXT PRIMARY KEY, pace TEXT, magnitude REAL, lat REAL, long REAL, depth TEXT, url TEXT, time TEXT)";


        public EarthQuakeOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }


    }

    public List<EarthQuake> getEarthQuakesByMagnitude(double magnitude) {


        String where = MAGNITUDE + ">=?";
        String[] whereArgs = {
                String.valueOf(magnitude)
        };
        return query(where, whereArgs);


    }

    public List<EarthQuake> getAll() {


        return query(null, null);

    }

    private List<EarthQuake> query(String where, String whereArgs[]) {
        List<EarthQuake> earthquake = new ArrayList<>();
        Cursor cursor = db.query(EarthQuakeOpenHelper.DATABASE_TABLE, ALL_COLUMNS, null, null, null, null, DATA + " DESC");

        HashMap<String, Integer> Indexex = new HashMap<>();
        for (int i = 0; i < ALL_COLUMNS.length; i++) {
            Indexex.put(ALL_COLUMNS[i], cursor.getColumnIndex(ALL_COLUMNS[i]));
        }

        while (cursor.moveToNext()) {

            EarthQuake earthQuake = new EarthQuake();
            earthQuake.set_id(cursor.getString((Indexex.get(_ID))));
            earthQuake.setPlace(cursor.getString((Indexex.get(PLACE))));
            earthQuake.setMagnitud(cursor.getDouble((Indexex.get(MAGNITUDE))));
            earthQuake.getCoords().setLatitud(cursor.getDouble(Indexex.get(LAT)));
            earthQuake.getCoords().setLongitud(cursor.getInt((Indexex.get(LONG))));
            //earthQuake.getCoords().setDepth(cursor.getDouble((Indexex.get(DEPTH))));
            earthQuake.setUrl(cursor.getString((Indexex.get(URL))));
            earthQuake.setTime(cursor.getLong((Indexex.get(DATA))));

            earthquake.add(earthQuake);


        }


        return earthquake;

    }
}



