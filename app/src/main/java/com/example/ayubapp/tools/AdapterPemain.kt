package com.example.ayubapp.tools

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ayubapp.R
import com.example.ayubapp.data.Pemain

class AdapterPemain(private val pemainList: List<Pemain>) : RecyclerView.Adapter<AdapterPemain.PemainViewHolder>() {

    class PemainViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.nama_pemain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PemainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_pemain, parent, false)
        return PemainViewHolder(view)
    }

    override fun onBindViewHolder(holder: PemainViewHolder, position: Int) {
        holder.textView.text = pemainList[position].nama
    }

    override fun getItemCount() = pemainList.size
}