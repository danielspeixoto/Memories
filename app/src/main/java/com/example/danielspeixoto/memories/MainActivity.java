package com.example.danielspeixoto.memories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Memory> memories;
    private EditText input;
    private Button add;
    private ListView listMemories;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.add);
        listMemories = (ListView) findViewById(R.id.listMemories);
        memories = new ArrayList<>();
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, memories);
        listMemories.setAdapter(adapter);

        listMemories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                Memory memory = memories.get(position);
                i.putExtra("title", memory.getTitle());
                i.putExtra("description", memory.getDescription());
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    public void putOnList (View view) {
        Intent i = new Intent(MainActivity.this, AddMemory.class);
        startActivity(i);
    }
}
