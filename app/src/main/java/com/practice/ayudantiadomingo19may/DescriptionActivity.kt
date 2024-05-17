package com.practice.ayudantiadomingo19may

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_description)

        val previus_button = findViewById<Button>(R.id.previous)
        val next_button = findViewById<Button>(R.id.next)

        previus_button.setOnClickListener {
            finish()
        }

        next_button.setOnClickListener {
            val intent = Intent(this, TypographieActivity::class.java)
            startActivity(intent)
        }

    }
}