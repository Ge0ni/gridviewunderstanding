package com.owono.android.gridviewunderstanding;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by owono on 26.04.2018.
 * This Data includes 2 classes. One of them is the GridViewAdapter that converts the data to be displayed in a GridView element
 * The other one is the Country class that stores the data to be displayed in one data array, so that we have only one array instead
 * of one array for the images and one array for the countries name
 */

/**
 * This class stores the data to be displayed in one data array, so that we have only one array instead
 * of one array for the images and one array for the countries name
 */
class Country {
    int imageId;
    String countryName;
    Country(int imageId, String countryName) {
        this.imageId=imageId;
        this.countryName=countryName;
    }
}

/**
 * This class converts the data to be displayed in a GridView element
 */
class GridViewAdapter extends BaseAdapter {

    ArrayList<Country> list;
    Context context;
    GridViewAdapter(Context context){
        this.context = context;
        list = new ArrayList<Country>();
        Resources res = context.getResources();
        String[] tempCountryNames = res.getStringArray(R.array.country_names);
        int[] countryImages = {R.drawable.austria, R.drawable.france, R.drawable.germany,
                R.drawable.italy, R.drawable.portugal, R.drawable.spain, R.drawable.uk};
        for(int i = 0; i<7; i++)
        {
            Country tempCountry = new Country(countryImages[i], tempCountryNames[i]);
            list.add(tempCountry);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ViewHolder {
        ImageView myCountryImage;
        ViewHolder(View v)
        {
            myCountryImage = (ImageView) v.findViewById(R.id.image_view);
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        ViewHolder holder = null;
        View row = view;

        if (row == null) //if we are creating a view for the first time
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_item, parent, false); //this method will take the given xml-file
                //and give back a new java object (creating a new grid element)
            holder = new ViewHolder(row);
            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }
        Country temp = list.get(i);
        holder.myCountryImage.setImageResource(temp.imageId);
        holder.myCountryImage.setTag(temp);

        return row;
    }
}
