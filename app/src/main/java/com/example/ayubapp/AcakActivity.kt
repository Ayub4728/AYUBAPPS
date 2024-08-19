package com.example.ayubapp

import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ayubapp.data.Pemain
import com.example.ayubapp.databinding.ActivityAcakBinding
import com.example.ayubapp.databinding.ActivityAyahBinding
import com.example.ayubapp.tools.AdapterPemain
import com.example.ayubapp.tools.AdapterPemain2

class AcakActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAcakBinding
    private lateinit var  Adapter : AdapterPemain
    private lateinit var  Adapter2 : AdapterPemain2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAcakBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.rvNamaPemain.layoutManager = LinearLayoutManager(this)
        binding.rvNamaPemain2.layoutManager = LinearLayoutManager(this)

        binding.btnacak.setOnClickListener {
            if(binding.edJumlahPemain.text.isEmpty()){
                Toast.makeText(this, "Jumlah pemain masih kosong", Toast.LENGTH_SHORT).show()
            } else if (binding.edNamaPemain.text.isEmpty()){
                Toast.makeText(this, "Nama pemain masih kosong", Toast.LENGTH_SHORT).show()
            }else{
                acakPemain()

            }

        }
    }

    private fun acakPemain() {
        val jumlahPemain = binding.edJumlahPemain.text.toString().toInt()
        val namaPemain = binding.edNamaPemain.text.toString().split(",").map { it.trim() }

        if (namaPemain.size < jumlahPemain) {
            Toast.makeText(this, "Jumlah pemain lebih banyak dari nama yang tersedia", Toast.LENGTH_SHORT).show()
            return
        }

        // Acak nama pemain
        val acakPemain = namaPemain.shuffled().take(jumlahPemain)

        // Bagi pemain menjadi dua tim
        val midPoint = jumlahPemain / 2
        val tim1 = acakPemain.take(midPoint).map { Pemain(it) }
        val tim2 = acakPemain.drop(midPoint).map { Pemain(it) }

        // Tampilkan di RecyclerView masing-masing tim
        Adapter = AdapterPemain(tim1)
        Adapter2= AdapterPemain2(tim2)
        binding.rvNamaPemain.adapter = Adapter
        binding.rvNamaPemain2.adapter = Adapter2
    }
}