package com.example.danielspeixoto.memories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView titleText;
    private TextView descriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        titleText = (TextView) findViewById(R.id.title);
        descriptionText = (TextView) findViewById(R.id.description);

        Intent r = getIntent();
        String title = r.getStringExtra("title");
        String description = r.getStringExtra("description");

        titleText.setText(title);
        descriptionText.setText(description);
    }
}
