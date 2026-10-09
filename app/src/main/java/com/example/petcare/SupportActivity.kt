package com.example.petcare

import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SupportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support)

        findViewById<ImageButton>(R.id.btn_back).setOnClickListener {
            finish()
        }

        findViewById<LinearLayout>(R.id.item_call).setOnClickListener {
            Toast.makeText(this, "Calling +27 66 097 9292...", Toast.LENGTH_SHORT).show()
        }

        findViewById<LinearLayout>(R.id.item_email).setOnClickListener {
            Toast.makeText(this, "Opening email to support@percare.co.za", Toast.LENGTH_SHORT).show()
        }

        findViewById<LinearLayout>(R.id.item_visit).setOnClickListener {
            Toast.makeText(this, "123 Care Street, johannesburg,2000" +
                    "", Toast.LENGTH_SHORT).show()
        }

        val etMessage = findViewById<TextInputEditText>(R.id.et_message)
        findViewById<MaterialButton>(R.id.btn_send).setOnClickListener {
            val message = etMessage.text.toString().trim()
            if (message.isEmpty()) {
                Toast.makeText(this, "Please type a message", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Message sent successfully!", Toast.LENGTH_SHORT).show()
                etMessage.setText("")
            }
        }
    }
}