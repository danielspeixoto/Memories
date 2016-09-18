package com.example.danielspeixoto.memories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private Button add;
    private ListView listMemories;
    private ArrayList<String> memories;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.input);
        add = (Button) findViewById(R.id.add);
        listMemories = (ListView) findViewById(R.id.listMemories);
        memories = new ArrayList<>();
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, memories);
        listMemories.setAdapter(adapter);
    }

    public void putOnList (View view) {
        String message = input.getText().toString();
        memories.add(message);
        adapter.notifyDataSetChanged();
        input.setText("");
    }
}
