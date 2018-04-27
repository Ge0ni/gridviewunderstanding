package com.owono.android.gridviewunderstanding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    GridView myGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myGrid = (GridView) findViewById(R.id.grid_view);

        myGrid.setAdapter(new GridViewAdapter(this));
        myGrid.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, MyDialog.class);
        GridViewAdapter.ViewHolder holder = (GridViewAdapter.ViewHolder) view.getTag();
        Country temp = (Country) holder.myCountryImage.getTag();
        intent.putExtra("countryImage", temp.imageId);
        intent.putExtra("countryName", temp.countryName);
        startActivity(intent);
    }

}
