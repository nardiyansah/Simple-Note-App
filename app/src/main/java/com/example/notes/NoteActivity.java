package com.example.notes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {
    private EditText editText;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        editText = findViewById(R.id.note_edit_text);
        String contents = getIntent().getStringExtra("contents");
        id = getIntent().getIntExtra("id", 0);
        editText.setText(contents);
    }

    @Override
    protected void onPause() {
        super.onPause();

        MainActivity.database.noteDao().save(editText.getText().toString(), id);
    }
}