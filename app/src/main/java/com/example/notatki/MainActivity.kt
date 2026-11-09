package com.example.notatki

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val noteEditText = findViewById<EditText>(R.id.noteEditText)
        val addButton = findViewById<Button>(R.id.addButton)
        val notesListView = findViewById<ListView>(R.id.notesListView)

        val notesList = mutableListOf(
            "Zakupy: chleb, masło, ser",
            "Do zrobienia: obiad, umyć podłogi",
            "weekend: kino, spacer z psem"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            notesList
        )
        notesListView.adapter = adapter

        addButton.setOnClickListener {
            val newNoteText = noteEditText.text.toString()

            if (newNoteText.isNotEmpty()) {
                notesList.add(newNoteText)

                adapter.notifyDataSetChanged()

                noteEditText.text.clear()
            }
        }
    }
}