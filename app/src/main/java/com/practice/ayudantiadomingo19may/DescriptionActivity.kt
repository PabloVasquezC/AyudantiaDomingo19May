package com.practice.ayudantiadomingo19may

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat

class DescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_description)

        val titleText = findViewById<TextView>(R.id.title_text)

        val animatorY = ObjectAnimator.ofFloat(titleText, "rotationY", 0f, 360f)
        animatorY.duration = 3000
        animatorY.repeatCount = ObjectAnimator.INFINITE
        animatorY.interpolator = DecelerateInterpolator()
        animatorY.start()

        val previous_button = findViewById<Button>(R.id.previous)
        val next_button = findViewById<Button>(R.id.next)

        previous_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(this,
                android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            startActivity(intent, options.toBundle())
        }

        next_button.setOnClickListener {
            val intent = Intent(this, TypographieActivity::class.java)

            startActivity(intent)
        }

    }
}