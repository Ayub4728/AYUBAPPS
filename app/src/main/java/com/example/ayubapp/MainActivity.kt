package com.example.ayubapp

import android.R.attr.data
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ayubapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnmasuk.setOnClickListener(){
            val username = binding.editusername.text.toString()
            val password = binding.editpassword.text.toString()

//            if (username != "ayub123") {
//                Toast.makeText(this, "Username Salah , Coba lagi", Toast.LENGTH_SHORT).show()
//            } else if(password != "ayuyinyub"){
//                Toast.makeText(this, "Password Salah , Coba lagi", Toast.LENGTH_SHORT).show()
//            }else {
//                val intent = Intent(this@MainActivity, AyubActivity::class.java)
//                startActivity(intent)
//            }

            if (username != "ayik321"){
                Toast.makeText(this, "Username Salah , Coba lagi", Toast.LENGTH_SHORT).show()
            }else if (password !="12345678"){
                Toast.makeText(this, "Password Salah , Coba lagi", Toast.LENGTH_SHORT).show()
            }else {
                val intent = Intent(this@MainActivity, MainMenuActivity::class.java)
                startActivity(intent)
            }

        }
    }
}