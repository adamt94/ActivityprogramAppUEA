package com.activity.adam.activityprogram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashSet;

import framework.implementation.ActivityData;
import framework.implementation.Database;

public class MainActivity extends AppCompatActivity {

    static Database db;
    ArrayList<ActivityData> ad;
    ArrayList<String> schools = new ArrayList<>();
    ArrayList<String> dates = new ArrayList<>();

    Spinner s1, s2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new Database(getAssets(), "uea-map-data.tsv", "activityprogramlist.tsv");
        ad = db.getActivityData();

        for (int i = 0; i < ad.size(); i++) {
            Integer day = (ad.get(i).getDay());
            Integer month = (ad.get(i).getMonth());
            Integer year = (ad.get(i).getYear());
            String date = ("" + day.toString() + "/" + month.toString() + "/" + year.toString());
            dates.add(date);
            schools.add(ad.get(i).getSchool().toUpperCase());
        }
        ArrayList<String> schoolList = new ArrayList<String>(new HashSet<String>(schools));
        ArrayList<String> dateList = new ArrayList<String>(new HashSet<String>(dates));

        s1 = (Spinner) findViewById(R.id.schoolSpinner);
        s2 = (Spinner) findViewById(R.id.dateSpinner);

        ArrayAdapter<String> schoolSpinAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner, schoolList);
        schoolSpinAdapter.setDropDownViewResource(R.layout.spinner);
        s1.setAdapter(schoolSpinAdapter);

        ArrayAdapter<String> dateSpinAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner, dateList);
        dateSpinAdapter.setDropDownViewResource(R.layout.spinner);
        s2.setAdapter(dateSpinAdapter);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityList.class);


                String school = s1.getSelectedItem().toString();
                String date = s2.getSelectedItem().toString();

                intent.putExtra("school", school);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
