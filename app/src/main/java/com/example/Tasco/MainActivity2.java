package com.example.Tasco;

import android.app.ActionBar;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Date;

//import com.example.timestamp.R;

//This class saves data from activity_main2.xml
public class MainActivity2 extends AppCompatActivity {
    EditText name, loc, desig, trip, jobN, fleetN, vehicleN;
    //String date;
    Button saveBtn;
    Intent intent;
    Calendar calander;
    SimpleDateFormat simpledateformat;
    String Date;
    TextView DisplayDateTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = (EditText) findViewById(R.id.txtName);
        loc = (EditText) findViewById(R.id.txtLocation);
        desig = (EditText) findViewById(R.id.txtDesignation);
        trip = (EditText) findViewById(R.id.txtTripNo);
        jobN = (EditText) findViewById(R.id.txtJobNo);
        fleetN = (EditText) findViewById(R.id.txtFleet);
        vehicleN = (EditText) findViewById(R.id.txtTruckNo);

        DisplayDateTime = (TextView)findViewById(R.id.date);

        //date = String.valueOf(new Date());



        //Get the text when click button
        saveBtn = (Button) findViewById(R.id.btnSave);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString() + "\n";
                String location = loc.getText().toString();
                String designation = desig.getText().toString();
                String tripNo = trip.getText().toString();
                String job = jobN.getText().toString();
                String fleet = fleetN.getText().toString();
                String vehicle = vehicleN.getText().toString();

                calander = Calendar.getInstance();
                simpledateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                Date = simpledateformat.format(calander.getTime());

                String datetime = Date;

                //String date = getDate().toString();
                //String textViewTime = String.valueOf(new Date());
                //String timestamp = desig.getText().toString();




                DbHandler dbHandler = new DbHandler(MainActivity2.this);
                dbHandler.insertUserDetails(username, location, designation, tripNo, job, fleet, vehicle, datetime);
                intent = new Intent(MainActivity2.this, DetailsActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),
                        "Details Inserted Successfully", Toast.LENGTH_SHORT).show();
            }


        });
    }


}



//25/2/2020
   /* public void deleteRow(View view){
        Button bt=(Button)view;
        SQLiteDatabase database=.getWritableDatabase();
        String del_id=bt.getTag().toString();
        //delete the row from the database
        database.delete(DBSchema.TABLE_NAME, DBSchema.COL_NAME_KEY+"=?", new String[]{del_id});
        //delete the row from the records ArrayList
        for(int i=0;i<records.size();i++){
            if(records.get(i).startsWith(del_id))
                records.remove(i);
        }
        //notify listview of dataset changed
        adapter.notifyDataSetChanged();

    }}*/