package com.example.ayubapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder
import com.example.ayubapp.databinding.ActivityCalculatorBinding
import com.example.ayubapp.databinding.ActivityMainMenuBinding

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mengaturInputanAngka()

        val buttonIds = arrayOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnplus, R.id.btnminus, R.id.btnmultiple, R.id.btndivide,
            R.id.btnHAPUS, R.id.btnResult
        )

        for (buttonId in buttonIds) {
            val button = findViewById<Button>(buttonId)

            button.setOnClickListener { onButtonClick(it) }
        }

        binding.btnResult.setOnClickListener { onEqualsButtonClick() }
    }

    private fun mengaturInputanAngka() {
        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val expression = s.toString()
                try {
                    val result = evaluateExpression(expression)
                    binding.resultText.setText(result.toString())
                } catch (e: Exception) {

                    binding.resultText.text.clear()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }


    private fun onButtonClick(view: View) {
        val button = view as Button
        var buttonText = button.text.toString()
        val currentText = binding.editText.text.toString()

        when (buttonText) {
            "Hapus" -> binding.editText.setText("")
            "x" -> binding.editText.setText(currentText + "*")
            ":" -> binding.editText.setText(currentText + "/")
            else -> binding.editText.setText(currentText + buttonText)
        }
    }

    private fun onEqualsButtonClick() {
        val currentText = binding.editText.text.toString()
        try {
            val result = evaluateExpression(currentText)
            val resultInt = result.toInt() // Convert result to integer
            binding.resultText.text = Editable.Factory.getInstance().newEditable(resultInt.toString())
        } catch (e: Exception) {
            binding.editText.setText("Error: ${e.message}")
        }
    }




    private fun evaluateExpression(expression: String): Int {
        return ExpressionBuilder(expression).build().evaluate().toInt()
    }

}