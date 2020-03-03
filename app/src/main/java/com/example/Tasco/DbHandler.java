package com.example.Tasco;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

//We create a SQLite helper by extending the SQLiteOpenHelper class. This enables us to create
//and manage databases
public class DbHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1; //Version of Database

    //private static final String DB_NAME = "usersdb"; //Name of Database
    //private static final String TABLE_Users = "userdetails";
    /*private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_LOC = "location";
    private static final String KEY_DESG = "designation";*/

    private static final String DB_NAME = "tacsoDB"; //Name of Database
    private static final String TABLE_Driver = "driverDetails";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_LOC = "location";
    private static final String KEY_DESG = "designation";
    private static final String KEY_TRIP = "tripNo";
    private static final String KEY_JOB = "job";
    private static final String KEY_FLEET = "fleet";
    private static final String KEY_VEHICLE = "vehicle";
    //private static final String COLUMN_DATETIME = ;

    //private static final INT DATE = ;
   // public static final String CREATED_DATE = "date";
    //private static final String KEY_TIME = "";
    public static final String KEY_DATE = "Date";
    //private String timestamp;

    public DbHandler(Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

//The onCreate() method gets called when the database first gets created on the device. The method
//should include all the code needed to create the tables we need for our app
    /*@Override
    public void onCreate(SQLiteDatabase db){

        String CREATE_TABLE = "CREATE TABLE " + TABLE_Users + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " TEXT, "
                + KEY_LOC + " TEXT, "
                + KEY_DESG + " TEXT, " +
                CREATED_DATE + " INTEGER" + ")";*/
//+ "COLUMN_TIMESTAMP, time default current_time,"
        //db.delete(TABLE_Users,KEY_NAME, null);

        //25/2/2020
        /*db.execSQL("create table location (" +
                " timestamp integer, latitude real, longitude real, altitude real," +
                " provider varchar(100), run_id integer references run(_id))");*/

        @Override
        public void onCreate(SQLiteDatabase db){

            String CREATE_TABLE = "CREATE TABLE " + TABLE_Driver + "("
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + KEY_NAME + " TEXT, "
                    + KEY_LOC + " TEXT, "
                    + KEY_DESG + " TEXT, "
                    + KEY_TRIP + " TEXT, "
                    + KEY_JOB + " TEXT, "
                    + KEY_FLEET + " TEXT, "
                    + KEY_VEHICLE + " TEXT, "
                    + KEY_DATE + " TEXT "
                    + ")";
        db.execSQL(CREATE_TABLE);
    }
    //The onUpgrade() method gets called when the database needs to be upgraded. As an example, if we
    //need to make table changes to the database after it’s been released, this is the method to do it in
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Driver);
        // Create tables again
        onCreate(db);
    }
    // **** CRUD (Create, Read, Update, Delete) Operations ***** //

    // Adding new User Details
    void insertUserDetails(String name, String location, String designation, String tripNo, String job, String fleet, String vehicle, String Date){


        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_NAME, name);
        cValues.put(KEY_LOC, location);
        cValues.put(KEY_DESG, designation);

        cValues.put(KEY_TRIP, tripNo);
        cValues.put(KEY_JOB, job);
        cValues.put(KEY_FLEET, fleet);
        cValues.put(KEY_VEHICLE, Date);

        cValues.put(KEY_DATE, vehicle);

        //cvalues.put(COLUMN_DATETIME, System.currentTimeMillis());

        // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       // Date date = new Date();

       // cValues.put(dateFormat.format(date), CREATED_DATE);


        //cValues.put(KEY_DATE, getDateTime());
        //cValues.put(COLUMN_TIMESTAMP, timestamp);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_Driver,null, cValues);
        db.close();
    }

    //Read the data from the SQLite database using the query() method

    public ArrayList<HashMap<String, String>> GetUsers(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT name, location, designation, tripNo, job, fleet, vehicle, date FROM "+ TABLE_Driver;




        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("designation",cursor.getString(cursor.getColumnIndex(KEY_DESG)));
            user.put("location",cursor.getString(cursor.getColumnIndex(KEY_LOC)));

            user.put("tripNo",cursor.getString(cursor.getColumnIndex(KEY_TRIP)));
            user.put("job",cursor.getString(cursor.getColumnIndex(KEY_JOB)));
            user.put("fleet",cursor.getString(cursor.getColumnIndex(KEY_FLEET)));
            user.put("vehicle",cursor.getString(cursor.getColumnIndex(KEY_VEHICLE)));


            user.put("date",cursor.getString(cursor.getColumnIndex(KEY_DATE)));



            //user.put("textViewTime",cursor.getString(cursor.getColumnIndex(CREATED_DATE)));
            userList.add(user);
        }
        return  userList;
    }

    // Get User Details based on userid
    public ArrayList<HashMap<String, String>> GetUserByUserId(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT name, location, designation, tripNo, job, fleet, vehicle, date FROM "+ TABLE_Driver;
        Cursor cursor = db.query(TABLE_Driver, new String[]{KEY_NAME, KEY_LOC, KEY_DESG, KEY_TRIP, KEY_JOB, KEY_FLEET, KEY_VEHICLE},
                KEY_ID+ "=?",new String[]{String.valueOf(userid)},
                null, null, null, null);
        if (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("designation",cursor.getString(cursor.getColumnIndex(KEY_DESG)));
            user.put("location",cursor.getString(cursor.getColumnIndex(KEY_LOC)));

            user.put("tripNo",cursor.getString(cursor.getColumnIndex(KEY_TRIP)));
            user.put("job",cursor.getString(cursor.getColumnIndex(KEY_JOB)));
            user.put("fleet",cursor.getString(cursor.getColumnIndex(KEY_FLEET)));
            user.put("vehicle",cursor.getString(cursor.getColumnIndex(KEY_VEHICLE)));


            user.put("date",cursor.getString(cursor.getColumnIndex(KEY_DATE)));


            //user.put("textViewTime",cursor.getString(cursor.getColumnIndex(CREATED_DATE)));
            userList.add(user);
        }
        return  userList;
    }
    // Delete User Details

      //setOnClickListener(new View.OnClickListener() {
          //public void onClick (View v){
              /*public void DeleteUser ( int userid){
                  //Button bt = (Button) bt_delete;
                  SQLiteDatabase db = this.getWritableDatabase();
                  db.delete(TABLE_Driver, KEY_ID + " = ?",
                          new String[]{String.valueOf(userid)});
                  db.close();
              }
         // }
      //}

    // Update User Details
    public int UpdateUserDetails(String location, String designation, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVals = new ContentValues();
        cVals.put(KEY_LOC, location);
        cVals.put(KEY_DESG, designation);
        int count = db.update(TABLE_Driver, cVals, KEY_ID+" = ?",
                new String[]{String.valueOf(id)});
        return  count;
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }*/
}