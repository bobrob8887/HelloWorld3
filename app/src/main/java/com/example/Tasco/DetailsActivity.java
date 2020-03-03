package com.example.Tasco;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;

//This Class to show details at details.xml from the SQLite database

public class DetailsActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

                                //The ListView AT DETAILS ACTIVITY
        setContentView(R.layout.details);

        DbHandler db = new DbHandler(this);
        ArrayList<HashMap<String, String>> userList = db.GetUsers();

                                                   //USER_LIST ListView AT DETAILS ACTIVITY
        ListView lv = (ListView) findViewById(R.id.user_list);
        ListAdapter adapter = new SimpleAdapter(DetailsActivity.this, userList,

                ///ONE LIST ROW
                R.layout.list_row,new String[]{"name","location","designation","tripNo", "job", "fleet", "vehicle", "date"},
                new int[]{R.id.name, R.id.location, R.id.designation, R.id.tripNo, R.id.job, R.id.fleet, R.id.vehicle, R.id.date });

        //The BACK Button
        lv.setAdapter(adapter);
        Button back = (Button)findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(DetailsActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }



}