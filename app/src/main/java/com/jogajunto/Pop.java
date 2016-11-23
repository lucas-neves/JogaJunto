package com.jogajunto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by lucasn on 07/10/2016.
 */
public class Pop extends Activity {

    ImageView pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

        DisplayMetrics d = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(d);

        int width = d.widthPixels;
        int height = d.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        pop = (ImageView) findViewById(R.id.pop);

        Intent i = getIntent();
        String url = i.getStringExtra("URL");

        Picasso.with(this)
                .load(url)
                .into(pop);

    }
}
