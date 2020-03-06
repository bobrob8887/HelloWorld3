package com.example.Tasco;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//This class saves data from activity_main2.xml
public class EnterJobEvents extends AppCompatActivity {
    EditText type, seq, des, sie;

    Button saveBtn;
    Intent intent;
    Calendar calender;
    SimpleDateFormat simpledateformat;
    String date;
    TextView DisplayDateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_job_events);
        type = (EditText) findViewById(R.id.txtJobType);
        seq = (EditText) findViewById(R.id.txtJobSeq);
        des = (EditText) findViewById(R.id.txtEventDes);
        sie = (EditText) findViewById(R.id.txtSite);

        DisplayDateTime = (TextView)findViewById(R.id.date);

        //Get the text when click button
        saveBtn = (Button) findViewById(R.id.btnSave);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calender = Calendar.getInstance();
                simpledateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                date = simpledateformat.format(calender.getTime());
                String datetime = date;

                String job = type.getText().toString() + "\n";
                String jobSeq = seq.getText().toString();
                String description = des.getText().toString();
                String site = sie.getText().toString();

                DbHandler DbHandler = new DbHandler(EnterJobEvents.this);
                DbHandler.insertEvents(datetime, job, jobSeq, description, site);
                intent = new Intent(EnterJobEvents.this, ShowJobEvents.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),
                        "Details Inserted Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}



