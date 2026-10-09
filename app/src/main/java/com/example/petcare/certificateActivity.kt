package com.example.petcare

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CertificatesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certificates)

        findViewById<ImageButton>(R.id.btn_back).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btn_download_1).setOnClickListener {
            Toast.makeText(this, "Downloading Caregiver Training certificate...", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btn_download_2).setOnClickListener {
            Toast.makeText(this, "Downloading First Aid Training certificate...", Toast.LENGTH_SHORT).show()
        }
    }
}