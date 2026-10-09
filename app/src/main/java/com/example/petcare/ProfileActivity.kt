package com.example.petcare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setupBottomNav(R.id.nav_profile)

        findViewById<ImageButton>(R.id.btn_back)?.setOnClickListener {
            finish()
        }

        findViewById<TextView>(R.id.item_my_courses)?.setOnClickListener {
            startActivity(Intent(this, MyCoursesActivity::class.java))
        }

        findViewById<TextView>(R.id.item_help)?.setOnClickListener {
            startActivity(Intent(this, SupportActivity::class.java))
        }

        findViewById<TextView>(R.id.item_personal)?.setOnClickListener {
            Toast.makeText(this, "Personal Information", Toast.LENGTH_SHORT).show()
        }

        findViewById<TextView>(R.id.item_certificates)?.setOnClickListener {
            startActivity(Intent(this, CertificatesActivity::class.java))
        }

        findViewById<TextView>(R.id.item_notifications)?.setOnClickListener {
            Toast.makeText(this, "Notifications", Toast.LENGTH_SHORT).show()
        }

        findViewById<TextView>(R.id.item_settings)?.setOnClickListener {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btn_logout)?.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun setupBottomNav(selectedItemId: Int) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav) ?: return
        bottomNav.selectedItemId = selectedItemId

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    if (selectedItemId != R.id.nav_home) {
                        startActivity(Intent(this, HomeActivity::class.java))
                        finish()
                    }
                    true
                }
                R.id.nav_courses -> {
                    if (selectedItemId != R.id.nav_courses) {
                        startActivity(Intent(this, CoursesActivity::class.java))
                        finish()
                    }
                    true
                }
                R.id.nav_my_courses -> {
                    if (selectedItemId != R.id.nav_my_courses) {
                        startActivity(Intent(this, MyCoursesActivity::class.java))
                        finish()
                    }
                    true
                }
                R.id.nav_messages -> {
                    if (selectedItemId != R.id.nav_messages) {
                        startActivity(Intent(this, MessagesActivity::class.java))
                        finish()
                    }
                    true
                }
                R.id.nav_profile -> {
                    if (selectedItemId != R.id.nav_profile) {
                        startActivity(Intent(this, ProfileActivity::class.java))
                        finish()
                    }
                    true
                }
                else -> false
            }
        }
    }
}