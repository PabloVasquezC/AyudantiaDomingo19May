package com.practice.ayudantiadomingo19may

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.text)


        val animator = ObjectAnimator.ofFloat(textView, "rotationY", 0f, 360f)

        animator.duration = 3000
        animator.repeatCount = 0
        animator.interpolator = DecelerateInterpolator()

        // Inicia la animación
        animator.start()

        button.setOnClickListener {
            val intent = Intent(this, DescriptionActivity::class.java)
            startActivity(intent)
        }
    }
}
