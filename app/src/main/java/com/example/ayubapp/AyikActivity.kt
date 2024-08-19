package com.example.ayubapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ayubapp.databinding.ActivityAyikBinding
import com.example.ayubapp.databinding.ActivityAyubBinding

class AyikActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAyikBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAyikBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnmasuk.setOnClickListener(){
            val intent = Intent(this@AyikActivity, AyahActivity::class.java)
            startActivity(intent)
        }
    }
}