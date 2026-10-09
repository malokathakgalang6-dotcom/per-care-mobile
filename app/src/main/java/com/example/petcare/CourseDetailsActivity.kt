package com.example.petcare

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class CourseDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details)

        val courseName = intent.getStringExtra("COURSE_NAME") ?: "Course"

        // Show course name on the screen
        findViewById<TextView>(R.id.tv_course_title)?.text = courseName

        // Back button
        findViewById<ImageButton>(R.id.btn_back).setOnClickListener {
            finish()
        }

        // Enroll Now → opens Enrollment screen
        findViewById<MaterialButton>(R.id.btn_enroll).setOnClickListener {
            val intent = Intent(this, EnrollmentActivity::class.java)
            intent.putExtra("COURSE_NAME", courseName)
            startActivity(intent)
        }
    }
}