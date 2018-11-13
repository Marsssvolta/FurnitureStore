package com.marsssvolta.furniturestore;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);

        int position = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Resources resources = getResources();

        String[] names = resources.getStringArray(R.array.names);
        collapsingToolbar.setTitle(names[position % names.length]);

        String[] details = resources.getStringArray(R.array.details);
        TextView detail = findViewById(R.id.detail);
        detail.setText(details[position % details.length]);

        TypedArray pictures = resources.obtainTypedArray(R.array.catalog_pictures);
        ImageView picture = findViewById(R.id.image);
        picture.setImageDrawable(pictures.getDrawable(position % pictures.length()));

        pictures.recycle();
    }
}
