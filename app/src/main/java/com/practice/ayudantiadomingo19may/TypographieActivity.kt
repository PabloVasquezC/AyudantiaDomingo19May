package com.practice.ayudantiadomingo19may

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat

class TypographieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_typographie)

        val textView = findViewById<TextView>(R.id.textView)

        val animator = ObjectAnimator.ofFloat(textView, "rotationX", 0f, 360f)
        animator.duration = 4000
        animator.repeatCount = ObjectAnimator.INFINITE
        animator.interpolator = LinearInterpolator()
        animator.start()

        val previous_button = findViewById<Button>(R.id.previous)
        val next_button = findViewById<Button>(R.id.next)

        previous_button.setOnClickListener {
            val intent = Intent(this, DescriptionActivity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(this,
                android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            startActivity(intent, options.toBundle())
        }

        next_button.setOnClickListener {
            val intent = Intent(this, WidgetsActivity::class.java)

            startActivity(intent)
        }
    }
}