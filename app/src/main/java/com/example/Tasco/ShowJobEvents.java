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

    public class ShowJobEvents extends AppCompatActivity {
        Intent intent;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //The ListView AT DETAILS ACTIVITY
            setContentView(R.layout.activity_show_job_events);

            //CHANGE
            DbHandler db = new DbHandler (this);
            ArrayList<HashMap<String, String>> eventList = db.GetEvents();

            //USER_LIST ListView AT DETAILS ACTIVITY
            ListView lv = (ListView) findViewById(R.id.event_list);
            ListAdapter adapter = new SimpleAdapter(ShowJobEvents.this, eventList,

                    ///ONE LIST ROW
                    R.layout.list_row_job_events,new String[]{"date","job","jobSeq","description", "site"},
                    new int[]{R.id.date, R.id.job, R.id.jobSeq, R.id.description, R.id.site });

            //The BACK Button
            lv.setAdapter(adapter);
            Button back = (Button)findViewById(R.id.btnBack);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent = new Intent(ShowJobEvents.this,EnterJobEvents.class);
                    startActivity(intent);
                }
            });
        }



    }