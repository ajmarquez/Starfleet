package com.ninjarobot.abelardo.starshipfleet.Utilities;

/**
 * Created by ajmarquez on 16/08/16.
 */
public final class FleetData {
//
//    private static final String SQL_CREATE_ENTRY = "CREATE TABLE" + StarshipEntry.TABLE_NAME + " (" +
//            StarshipEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," + "," +
//            StarshipEntry.COLUMN_NAME_NAME + " TEXT" + "," +
//            StarshipEntry.COLUMN_NAME_MODEL + " TEXT" + "," +
//            StarshipEntry.COLUMN_NAME_MANUFACTURER + " TEXT" + "," +
//            StarshipEntry.COLUMN_NAME_CAPACITY + " TEXT" + " )";
//    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXITS " + StarshipEntry.TABLE_NAME;
//    public FleetData() {}
//
//    public static abstract class StarshipEntry implements BaseColumns {
//        public static final String TABLE_NAME = "starshipTable";
//        public static final String COLUMN_NAME_ID = "starshipId";
//        public static final String COLUMN_NAME_NAME = "name";
//        public static final String COLUMN_NAME_MODEL = "model";
//        public static final String COLUMN_NAME_MANUFACTURER = "manufacturer";
//        public static final String COLUMN_NAME_CAPACITY = "capacity";
//
//    }
//
//    public class FleetDataHelper extends SQLiteOpenHelper {
//
//        public static final int DATABASE_VERSION = 1;
//        public static final String DATABASE_NAME = "FleetData.db";
//
//        public FleetDataHelper(Context context) {
//            super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        }
//
//        @Override
//        public void onCreate(SQLiteDatabase db) {
//            db.execSQL(SQL_CREATE_ENTRY);
//            onCreate(db);
//        }
//
//        @Override
//        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
//            db.execSQL(SQL_DELETE_ENTRIES);
//            onCreate(db);
//        }
//
//        @Override
//        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//            onUpgrade(db, oldVersion, newVersion);
//        }
//
//    }
//
//    public void insertStarship (Context context, StarShip starShip) {
//
//        FleetDataHelper dbHelper = new FleetDataHelper(context);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(StarshipEntry.COLUMN_NAME_NAME, starShip.getName());
//        values.put(StarshipEntry.COLUMN_NAME_MODEL, starShip.getModel());
//        values.put(StarshipEntry.COLUMN_NAME_MANUFACTURER, starShip.getManufacturer());
//        values.put(StarshipEntry.COLUMN_NAME_CAPACITY, starShip.getCapacity());
//        db.insert(StarshipEntry.TABLE_NAME,
//                null,
//                values);
    }

//    public void queryStarship (Context context, )
//}
