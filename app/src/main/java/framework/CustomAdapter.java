package se2.saaf.framework;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import se2.saaf.framework.implementation.MapData;

/**
 * Created by adam on 07-Nov-15.
 */
public interface CustomAdapter {


    public int getCount();


    public Object getItem(int position);

    public long getItemId(int position);

    public View getView(int position, View convertView, ViewGroup parent);

    //used for filtering the listview
    public Filter getFilter();





}