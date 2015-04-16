package tk.mirenamorrortu.earthquakes.proveders;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import java.net.URI;

public class EarthQuakeProvider extends ContentProvider {
    private static final int ALRROWS = 1;
    private static final int SINGLE_ROW = 2;
    private static final UriMatcher uriMatcher;
    public static Uri CONTENT_URI = Uri.parse("content://com.example.provider.Earthquake/earthquakes");
    public static final String ID_COLUMN_NAME = "_id";
    public static final String PLACE_COLUMN_NAME = "place";
    public static final String MAG_COLUMN_NAME = "magnitude";
    public static final String LAT_COLUMN_NAME = "lat";
    public static final String LONG_COLUMN_NAME = "long";
    public static final String DEPTH_COLUMN_NAME = "depth";
    public static final String URL_COLUMN_NAME = "url";
    public static final String TIME_COLUMN_NAME = "time";
    public EarthQuakeOpenHelper earthQuakeOpenHelper;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.provider.Earthquake", "earthquakes", ALRROWS);
        uriMatcher.addURI("com.example.provider.Earthquake", "earthquakes/#", SINGLE_ROW);
    }

    public EarthQuakeProvider() {

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        switch
                (uriMatcher.match(uri))
        {
            case
                    ALRROWS:return
                    "vnd.android.cursor.dir/vnd.paad.provider.elemental";
            case
                    SINGLE_ROW: return
                    "vnd.android.cursor.item/vnd.paad.provider.elemental";
            default:throw new IllegalArgumentException("Unsupported uri: "+uri);
        }
    }



    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        SQLiteDatabase db = earthQuakeOpenHelper.getWritableDatabase();

        long id = db.insert(EarthQuakeOpenHelper.DATABASE_TABLE, null, values);

        if
                (id
                > 1) {


            Uri
                    insertedId
                    =
                    ContentUris.withAppendedId(CONTENT_URI,
                            id);
            getContext().getContentResolver().notifyChange(insertedId,
                    null);
            return
                    insertedId;

        } else


            return
                    null;


    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.

        earthQuakeOpenHelper = new EarthQuakeOpenHelper(getContext(), EarthQuakeOpenHelper.DATABASE_NAME, null, EarthQuakeOpenHelper.DATABASE_VERSION);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.

        SQLiteDatabase
                db;

        try {

            db
                    =
                    earthQuakeOpenHelper.getWritableDatabase();

        } catch
                (SQLiteException
                        ex) {


            db
                    =
                    earthQuakeOpenHelper.getReadableDatabase();

        }

        SQLiteQueryBuilder
                queryBuilder
                =
                new
                        SQLiteQueryBuilder();

        switch
                (uriMatcher.match(uri)) {


            case SINGLE_ROW
                    :


                String
                        rowID
                        =
                        uri.getPathSegments().get(1);


                queryBuilder.appendWhere(earthQuakeOpenHelper.ID_COLUMN_NAME
                                +
                                "=?"
                );


            default:
                break;


        }

        queryBuilder.setTables(earthQuakeOpenHelper.DATABASE_TABLE);
        Cursor
                cursor
                =
                queryBuilder.query(db, projection, selection, selectionArgs, null, null, sortOrder);
        return cursor;


    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
   public static String[] result_columns = new String[] {
            EarthQuakeOpenHelper.ID_COLUMN_NAME, EarthQuakeOpenHelper.MAG_COLUMN_NAME,
            EarthQuakeOpenHelper.PLACE_COLUMN_NAME, EarthQuakeOpenHelper.TIME_COLUMN_NAME,
            EarthQuakeOpenHelper.URL_COLUMN_NAME, EarthQuakeOpenHelper.LAT_COLUMN_NAME,
            EarthQuakeOpenHelper.LONG_COLUMN_NAME, EarthQuakeOpenHelper.DEPTH_COLUMN_NAME};

    private static class EarthQuakeOpenHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "earthquakes.db";
        private static final String DATABASE_TABLE = "EARTHQUAKES";
        private static final Integer DATABASE_VERSION = 1;
        private static final String DATABASE_CREATE = "CREATE TABLE " + DATABASE_TABLE +
                "(_id TEXT PRIMARY KEY, place TEXT, magnitude REAL, lat REAL, long REAL, depth REAL, url TEXT, time INTEGER)";
        private static final String ID_COLUMN_NAME = "_id";
        private static final String PLACE_COLUMN_NAME = "place";
        private static final String MAG_COLUMN_NAME = "magnitude";
        private static final String LAT_COLUMN_NAME = "lat";
        private static final String LONG_COLUMN_NAME = "long";
        private static final String DEPTH_COLUMN_NAME = "depth";
        private static final String URL_COLUMN_NAME = "url";
        private static final String TIME_COLUMN_NAME = "time";

        private static final int ORDER_BY_MAG = 0;
        private static final int ORDER_BY_LONG = 1;
        private static final int ORDER_BY_LAT = 2;
        private static final int ORDER_BY_DEPTH = 3;
        private static final int ORDER_BY_TIME = 4;

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
}
