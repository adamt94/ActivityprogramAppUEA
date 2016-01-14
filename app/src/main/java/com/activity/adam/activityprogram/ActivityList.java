package com.activity.adam.activityprogram;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import framework.implementation.ActivityData;

public class ActivityList extends AppCompatActivity {

    ListView activityList;
    TextView title;
    String school;
    String date;
    CustomAdapter adapter;
    ArrayList<ActivityData> ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ad = MainActivity.app.getDatabase().getActivityData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent in = getIntent();

        school = in.getStringExtra("school");
        date = in.getStringExtra("date");
        System.out.println(school + date);

        activityList = (ListView) findViewById(R.id.activities);
        adapter = new CustomAdapter(ad, this, school, date);
        activityList.setAdapter(adapter);

        title = (TextView) findViewById(R.id.txtSchoolDate);
        title.setText(school + " - " + date);

        activityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(ActivityList.this, ActivityDetails.class);
                String description = "", location = "", room = "";
                int day = 0, month = 0, year = 0, hour = 0;
                for (int i = 0; i < ad.size(); i++) {
                    if ((ad.get(i).getSchool().toUpperCase().equals(school)) && ad.get(i).getDate().equals(date)){
                        day = ad.get(i).getDay();
                        month = ad.get(i).getMonth();
                        year = ad.get(i).getYear();
                        hour = ad.get(i).getHour();
                        description = ad.get(i).getDescription();
                        location = ad.get(i).getLocation();
                        room = ad.get(i).getRoom();
                    }
                }
                intent.putExtra("school", school);
                intent.putExtra("date", date);
                intent.putExtra("day", day);
                intent.putExtra("month", month);
                intent.putExtra("year", year);
                intent.putExtra("hour", hour);
                intent.putExtra("description", description);
                intent.putExtra("location", location);
                intent.putExtra("room", room);

                startActivity(intent);


            }
        });
    }

}
