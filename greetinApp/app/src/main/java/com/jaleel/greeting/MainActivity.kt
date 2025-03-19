package com.example.greetingapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.jaleel.greeting.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        val greetButton: Button = findViewById(R.id.greetButton)
        val userNameEditText: TextInputEditText = findViewById(R.id.userName)
        val courseEditText: TextInputEditText = findViewById(R.id.courseEditText)
        val greetText: TextView = findViewById(R.id.greetText)
        val imageView: ImageView = findViewById(R.id.imageView)

        // Set an OnClickListener to the greetButton
        greetButton.setOnClickListener {
            val userName = userNameEditText.text.toString()
            val course = courseEditText.text.toString()

            // Display a greeting message
            greetText.text = "Hello, $userName! Welcome to the $course course."


            if(course == "Java"){
                imageView.setImageResource(R.drawable.java)
            }else{
                imageView.setImageResource(R.drawable.kotlin)
            }

            // Optionally, change the image dynamically (you could load a resource or set visibility)
            // Example: replace with your actual image resource
        }
    }
}
