package com.example.danielspeixoto.memories;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMemory extends AppCompatActivity {

    private EditText titleInput;
    private EditText descriptionInput;
    private Button saveMemory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_memory);
        titleInput = (EditText) findViewById(R.id.titleInput);
        descriptionInput = (EditText) findViewById(R.id.descriptionInput);
        saveMemory = (Button) findViewById(R.id.saveMemory);

        saveMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleInput.getText().toString();
                String description = descriptionInput.getText().toString();
                Memory memory = new Memory(title, description);
                MainActivity.memories.add(memory);
                titleInput.setText("");
                descriptionInput.setText("");
                Toast.makeText(AddMemory.this, "Salvo", Toast.LENGTH_SHORT);
            }
        });
    }
}
