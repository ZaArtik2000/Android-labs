package com.example.android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ThirdActivity extends AppCompatActivity {

    @Override
//    private ArrayList<String> notesList;
//    private ArrayAdapter<String> notesListAdapter;
//    private EditText txtInput;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ListView notesListView = (ListView) findViewById(R.id.notesList);

        ArrayList<String> notesList = new ArrayList<String>();
        notesList.add("Not bad men");
        notesList.add("Good");

        ArrayAdapter<String> notesListAdapter = new ArrayAdapter<String>(this, R.layout.note_list_item, R.id.noteListItem, notesList);
        notesListView.setAdapter(notesListAdapter);
        EditText noteInput = (EditText) findViewById(R.id.noteInput);
        Button addNoteBtn = (Button) findViewById(R.id.addNoteBtn);

        addNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = noteInput.getText().toString();
                notesList.add(newItem);
                notesListAdapter.notifyDataSetChanged();
            }
        });
    }
}