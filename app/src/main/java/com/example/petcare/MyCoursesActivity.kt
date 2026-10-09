package com.example.petcare

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MyCoursesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_courses)

        setupBottomNav(R.id.nav_my_courses)

        findViewById<ImageButton>(R.id.btn_back)?.setOnClickListener {
            finish()
        }

        val tabInProgress = findViewById<TextView>(R.id.tab_in_progress)
        val tabCompleted = findViewById<TextView>(R.id.tab_completed)
        val tabAll = findViewById<TextView>(R.id.tab_all)

        fun selectTab(selected: TextView) {
            listOf(tabInProgress, tabCompleted, tabAll).forEach { tab ->
                if (tab == null) return@forEach
                if (tab == selected) {
                    tab.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_primary))
                    tab.setTextColor(ContextCompat.getColor(this, R.color.white))
                } else {
                    tab.setBackgroundColor(ContextCompat.getColor(this, R.color.card_background))
                    tab.setTextColor(ContextCompat.getColor(this, R.color.text_secondary))
                }
            }
        }

        tabInProgress?.setOnClickListener { selectTab(tabInProgress) }
        tabCompleted?.setOnClickListener { selectTab(tabCompleted) }
        tabAll?.setOnClickListener { selectTab(tabAll) }
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