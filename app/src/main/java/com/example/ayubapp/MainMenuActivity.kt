
package com.example.ayubapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ayubapp.databinding.ActivityMainBinding
import com.example.ayubapp.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.llMn1.setOnClickListener {
            val intent = Intent(this@MainMenuActivity, AyubActivity::class.java)
            startActivity(intent)
        }
        binding.llmn2.setOnClickListener {
            val intent = Intent(this@MainMenuActivity, CalculatorActivity::class.java)
            startActivity(intent)
        }
        binding.llMn3.setOnClickListener {
            val intent = Intent(this@MainMenuActivity, AcakActivity::class.java)
            startActivity(intent)
        }
}
}