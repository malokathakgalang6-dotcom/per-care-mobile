package com.example.petcare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EnrollmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enrollment)

        val courseName = intent.getStringExtra("COURSE_NAME") ?: "Course"
        findViewById<TextView>(R.id.tv_course_name).text = courseName

        findViewById<ImageButton>(R.id.btn_back).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btn_confirm).setOnClickListener {
            val name = findViewById<EditText>(R.id.et_full_name).text.toString().trim()
            val email = findViewById<EditText>(R.id.et_email).text.toString().trim()
            val phone = findViewById<EditText>(R.id.et_phone).text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Successfully enrolled in $courseName!", Toast.LENGTH_LONG).show()
                // Go to My Courses after enrollment
                startActivity(Intent(this, MyCoursesActivity::class.java))
                finish()
            }
        }
    }
}