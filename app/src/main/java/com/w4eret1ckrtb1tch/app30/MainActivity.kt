package com.w4eret1ckrtb1tch.app30

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button1)
        val editText: EditText = findViewById(R.id.edit_text1)

        button.setOnClickListener {
            Toast.makeText(this, "TEST OK", Toast.LENGTH_SHORT)
        }
        editText.addTextChangedListener(onTextChanged = { text, start, before, count ->
            button.isEnabled = text?.isNotBlank() ?: false
        })

    }
}