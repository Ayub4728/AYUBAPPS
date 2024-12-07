package com.example.ayubapp.tools

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ayubapp.data.Note
import com.example.ayubapp.databinding.ListCatatanBinding

class AdapterNote(private val notes: List<Note>, private val onDeleteClick: (Note) -> Unit) :
    RecyclerView.Adapter<AdapterNote.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ListCatatanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
    }

    override fun getItemCount(): Int = notes.size

    inner class NoteViewHolder(private val binding: ListCatatanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.tvJudul.text = note.title
            binding.tvDetail.text = note.content
            binding.ivDelete.setOnClickListener {
                onDeleteClick(note)
            }
        }
    }
}