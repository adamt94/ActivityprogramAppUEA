package framework;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;

/**
 * Created by adam on 07-Nov-15.
 * Allows a more flexible list-view
 */
public interface CustomAdapter {


    public int getCount();


    public Object getItem(int position);

    public long getItemId(int position);

    public View getView(int position, View convertView, ViewGroup parent);

    //used for filtering the listview
    public Filter getFilter();





}