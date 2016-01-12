package com.activity.adam.activityprogram;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import framework.implementation.ActivityData;
import framework.implementation.Database;

public class MainActivity extends AppCompatActivity {

    Database db;
    ArrayList<ActivityData> ad;
    ArrayList<String> schools = new ArrayList<>();
    ArrayList<Integer> dates = new ArrayList<>();

    Spinner s1, s2;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new Database(getAssets(), "activityprogramlist.tsv", "activity");
        ad = db.getActivityData();
        for (int i = 0; i < ad.size(); i++) {
            schools.add(ad.get(i).getSchool().toUpperCase());
        }

        ArrayList<String> newList = new ArrayList<String>(new HashSet<String>(schools));
        s1 = (Spinner) findViewById(R.id.schoolSpinner);
        s2 = (Spinner) findViewById(R.id.dateSpinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(context,
                R.layout.spinner, newList);
        spinnerAdapter.setDropDownViewResource(R.layout.spinner);
        s1.setAdapter(spinnerAdapter);
        s2.setEnabled(false);



        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {

                String str = s1.getSelectedItem().toString();
                for (int i = 0; i < schools.size(); i++) {
                    if (str == ad.get(i).getSchool()) {
                        dates.add(ad.get(i).getDay());
                    }
                }
                ArrayList<Integer> newList = new ArrayList<Integer>(new HashSet<Integer>(dates));
                ArrayAdapter<Integer> spinnerAdapter = new ArrayAdapter<Integer>(context,
                        R.layout.spinner, newList);
                spinnerAdapter.setDropDownViewResource(R.layout.spinner);
                s2.setAdapter(spinnerAdapter);
                s2.setEnabled(true);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });}

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
