package com.activity.adam.activityprogram;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import framework.implementation.ActivityData;

/**
 * Created by adam on 07-Nov-15.
 */
class CustomAdapter extends BaseAdapter implements framework.CustomAdapter{

    private ArrayList<ActivityData> _data;
    Context _c;




    private static List<ActivityData> filteredData;


    private Filter filter;


    CustomAdapter (ArrayList<ActivityData> data, Context c, String s, String d){
        _data = data;
        _c = c;
        filteredData = new ArrayList();

        for (int i=0; i< data.size(); i++)
        {
            if (data.get(i).getSchool().toUpperCase().equals(s))
            {
                if (data.get(i).getDate().equals(d)){
                    filteredData.add(data.get(i));
                }
            }
        }

    }
    public static List<ActivityData> getFilteredData() {
        return filteredData;
    }
    public int getCount() {
        // TODO Auto-generated method stub
        return filteredData.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return filteredData.get(position);
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View v = convertView;
        if (v == null)
        {
            LayoutInflater vi = (LayoutInflater)_c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.listviewdetails, null);
        }



        ImageView image = (ImageView) v.findViewById(R.id.icon);

        TextView subView = (TextView)v.findViewById(R.id.subject);
        TextView descView = (TextView)v.findViewById(R.id.description);
        TextView timeView = (TextView)v.findViewById(R.id.time);

        ActivityData msg = filteredData.get(position);
        image.setImageResource(R.drawable.arrow);

        subView.setText(msg.getDescription());
        timeView.setText("Time: " + msg.getHour() + ":00 - " + (msg.getHour()+1) + ":00");
        descView.setText(msg.getLocation() + " (" + msg.getRoom() + ")");

        return v;
    }

    @Override
    public Filter getFilter() {

        if (filter == null)
            filter = new FilteredData();
        return filter;
    }

    private class FilteredData extends Filter {



        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            // We implement here the filter logic
            if (constraint == null || constraint.length() == 0) {
                // No filter implemented we return all the list
                results.values = _data;
                results.count = _data.size();
            }
            else {
                // We perform filtering operation
                List<ActivityData> list = new ArrayList<ActivityData>();

                for (ActivityData p : filteredData) {
                    if (p.getSchool().toUpperCase() == "CMP")
                        list.add(p);
                }

                results.values =  list;
                results.count =  list.size();

            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {

            // Now we have to inform the adapter about the new list filtered
            if (results.count == 0)
                notifyDataSetInvalidated();
            else {
                filteredData = (List<ActivityData>) results.values;
                notifyDataSetChanged();
            }

        }

    }

}
