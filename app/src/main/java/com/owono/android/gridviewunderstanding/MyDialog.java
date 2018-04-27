package com.owono.android.gridviewunderstanding;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyDialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydialog);
        Intent intent = getIntent();
        if (intent != null)
        {
            int imageId = intent.getIntExtra("countryImage", R.drawable.germany);
            String countryName = intent.getStringExtra("countryName");
            ImageView myImage = (ImageView) findViewById(R.id.mydialog_image);
            myImage.setImageResource(imageId);
            TextView myText = (TextView) findViewById(R.id.mydialog_text);
            myText.setText(countryName);
        }
    }

    public void closeDialog(View v) {

        finish();
    }

}
