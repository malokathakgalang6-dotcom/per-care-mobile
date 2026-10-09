package com.example.petcare

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupBottomNav(R.id.nav_home)

        findViewById<MaterialButton>(R.id.btn_explore)?.setOnClickListener {
            startActivity(Intent(this, CoursesActivity::class.java))
        }

        // If btn_explore is a normal Button, use this instead:
        // findViewById<android.widget.Button>(R.id.btn_explore)?.setOnClickListener {
        //     startActivity(Intent(this, CoursesActivity::class.java))
        // }

        findViewById<TextView>(R.id.action_courses)?.setOnClickListener {
            startActivity(Intent(this, MyCoursesActivity::class.java))
        }

        findViewById<TextView>(R.id.action_profile)?.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        findViewById<TextView>(R.id.action_messages)?.setOnClickListener {
            startActivity(Intent(this, MessagesActivity::class.java))
        }

        findViewById<TextView>(R.id.action_support)?.setOnClickListener {
            startActivity(Intent(this, SupportActivity::class.java))
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