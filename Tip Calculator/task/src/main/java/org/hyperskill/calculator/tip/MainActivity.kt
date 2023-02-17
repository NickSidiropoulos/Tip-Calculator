package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.edit_text)
        val slider = findViewById<Slider>(R.id.slider)


        editText.doAfterTextChanged {
            changeTextView(editText.text, slider.value.toInt())
        }

        slider.addOnChangeListener { slider, value, fromUser ->
            changeTextView(editText.text, slider.value.toInt()) }
    }

    private fun changeTextView(text: Editable, value: Int) {
        val textView = findViewById<TextView>(R.id.text_view)

        if (text.isNotEmpty()){
            val amount = String.format("%.2f", text.toString().toDouble()).toDouble()
            val tip = String.format("%.2f", ((amount * value) / 100))
            textView.text = "Tip amount: $tip\$"
            //textView.text = "Bill value: ${}\$, tip percentage: ${value}%"
        } else{
            textView.text = ""
        }
    }
}