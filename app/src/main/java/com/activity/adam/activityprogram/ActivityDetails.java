package com.activity.adam.activityprogram;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import framework.implementation.AndroidApp;

import java.util.Calendar;
import java.util.Random;

public class ActivityDetails extends AppCompatActivity {

    TextView descriptionnn, descriptionn, locationn, roomm, hourr;
    FloatingActionButton calendar,notification,appActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent in = getIntent();

        final String school = in.getStringExtra("school");
        final int date = in.getIntExtra("date", 0);
        final int day = in.getIntExtra("day", 0);
        final int month = in.getIntExtra("month", 0);
        final int year = in.getIntExtra("year", 0);
        final int hour = in.getIntExtra("hour", 0);
        final String description = in.getStringExtra("description");
        final String location = in.getStringExtra("location");
        final String room = in.getStringExtra("room");

        descriptionn = (TextView) findViewById(R.id.descriptionn);
        descriptionn.setText(description);
        descriptionnn = (TextView) findViewById(R.id.descriptionnn);
        descriptionnn.setText(description);
        roomm = (TextView) findViewById(R.id.roomm);
        roomm.setText(room);
        locationn = (TextView) findViewById(R.id.locationn);
        locationn.setText(location);
        hourr = (TextView) findViewById(R.id.hourr);
        hourr.setText(hour + ":00");

        calendar = (FloatingActionButton) findViewById(R.id.calendar);
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(year, month, day, hour, 0);
                Calendar endTime = Calendar.getInstance();
                endTime.set(year, month, day, hour + 1, 0);
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                        .putExtra(CalendarContract.Events.TITLE, description)
                        .putExtra(CalendarContract.Events.DESCRIPTION, description)
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, location + room)
                        .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);
                startActivity(intent);
            }
        });
        appActivity = (FloatingActionButton) findViewById(R.id.map);
        appActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                int position = 13;
                for (int i = 0; i < MainActivity.md.size(); i++) {
                    if (MainActivity.md.get(i).getAbbr().equals(school)) {
                        System.out.println("POSITION MATCHES  "+ i);
                        position = i;
                    }
                }
                intent.setComponent(new ComponentName("com.activity.adam.locationfinder", "com.activity.adam.locationfinder.BuildingDetails"));


            //pass position to next class to get the right MapData
            intent.putExtra("position", position);
            try
            {
                    startActivity(intent);

            }catch(Exception e)
            {
                finish();
            }
            }
        });

        notification = (FloatingActionButton) findViewById(R.id.notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(year, month, day, hour, 0);
                MainActivity.app.getNotification().remind((int) (beginTime.getTimeInMillis() - Calendar.getInstance().getTimeInMillis()), description, location + room);
                Toast.makeText(ActivityDetails.this, "Notification Set", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
