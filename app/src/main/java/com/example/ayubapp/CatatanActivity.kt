package com.example.ayubapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ayubapp.data.Note
import com.example.ayubapp.databinding.ActivityCalculatorBinding
import com.example.ayubapp.databinding.ActivityCatatanBinding
import com.example.ayubapp.tools.AdapterNote
import com.example.ayubapp.viewmodel.NoteViewmodel

class CatatanActivity : AppCompatActivity() {

    private val noteViewModel: NoteViewmodel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var noteAdapter: AdapterNote

    private lateinit var binding: ActivityCatatanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCatatanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.rvCatatan
        noteAdapter = AdapterNote(emptyList()) { note ->
            noteViewModel.delete(note)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = noteAdapter

        noteViewModel.allNotes.observe(this) { notes ->
            // Update the adapter when data changes
            noteAdapter = AdapterNote(notes) { note ->
                // Handle delete note action
                noteViewModel.delete(note)
            }
            recyclerView.adapter = noteAdapter
        }

        addNote()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun addNote (){
        binding.btAdd.setOnClickListener {
            val newNote = Note(
                title = "New Note",
                content = "Content of the new note"
            )
            noteViewModel.insert(newNote)
        }
    }
}