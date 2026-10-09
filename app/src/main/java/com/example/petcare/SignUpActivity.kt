package com.example.petcare

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val btnBack = findViewById<ImageButton>(R.id.btn_back)
        val etName = findViewById<TextInputEditText>(R.id.et_name)
        val etEmail = findViewById<TextInputEditText>(R.id.et_email)
        val etPhone = findViewById<TextInputEditText>(R.id.et_phone)
        val etPassword = findViewById<TextInputEditText>(R.id.et_password)
        val etConfirm = findViewById<TextInputEditText>(R.id.et_confirm)
        val btnSignUp = findViewById<MaterialButton>(R.id.btn_signup)
        val tvLogin = findViewById<TextView>(R.id.tv_login)

        btnBack.setOnClickListener { finish() }

        tvLogin.setOnClickListener { finish() }

        btnSignUp.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirm = etConfirm.text.toString().trim()

            when {
                name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() -> {
                    Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                }
                password != confirm -> {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }
            }
        }
    }
}