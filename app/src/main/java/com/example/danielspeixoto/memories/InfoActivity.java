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
        // Nessa Activity vamos estar mostrando as informações de cada memória
        // Para isso, recebemos a informação de qual memória se trata, através dos Extras
        // passados pelas Intent, no caso, a que veio de MainActivity.
        // Recebemos a Intent
        Intent r = getIntent();
        // Recebemos cada dado através do nome da sua tag
        String title = r.getStringExtra("title");
        String description = r.getStringExtra("description");
        // Setamos as views com as informações recebidas
        titleText.setText(title);
        descriptionText.setText(description);
    }
}
