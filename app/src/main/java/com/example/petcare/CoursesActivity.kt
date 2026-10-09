package com.example.petcare

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class CoursesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        setupBottomNav(R.id.nav_courses)

        findViewById<ImageButton>(R.id.btn_back)?.setOnClickListener {
            finish()
        }

        findViewById<LinearLayout>(R.id.card_caregiver)?.setOnClickListener {
            openDetails("Caregiver Training")
        }

        findViewById<LinearLayout>(R.id.card_first_aid)?.setOnClickListener {
            openDetails("First Aid Training")
        }

        findViewById<LinearLayout>(R.id.card_health)?.setOnClickListener {
            openDetails("Health & Safety")
        }

        findViewById<LinearLayout>(R.id.card_childcare)?.setOnClickListener {
            openDetails("Child Care Training")
        }
    }

    private fun openDetails(courseName: String) {
        val intent = Intent(this, CourseDetailsActivity::class.java)
        intent.putExtra("COURSE_NAME", courseName)
        startActivity(intent)
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