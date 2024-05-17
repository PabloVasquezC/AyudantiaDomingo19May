package com.practice.ayudantiadomingo19may

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
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


        // Create an ObjectAnimator to rotate the textView around its Y-axis.
        val animatorY = ObjectAnimator.ofFloat(textView, "rotationY", 0f, 360f)

        // Set the duration of the animation to 3000 milliseconds (3 seconds).
        animatorY.duration = 3000

        // Set the animation to play only once. '0' means no repeats.
        animatorY.repeatCount = 0

        // Use a DecelerateInterpolator to slow down the animation as it comes to an end.
        animatorY.interpolator = DecelerateInterpolator()

        // Start the animation.
        animatorY.start()

        // Create an ObjectAnimator to fade in the textView from transparent to opaque.
        val fadeInAnimator = ObjectAnimator.ofFloat(textView, "alpha", 0f, 1f)
        fadeInAnimator.duration = 3000  // Set the duration of the fade in animation to 3000 milliseconds.

        fadeInAnimator.start()

        // Initial position of the button (below its final position)
        button.translationY = 70f  // Adjust this value based on your layout and preference

        // ObjectAnimator for button fade in
        val fadeInAnimatorButton = ObjectAnimator.ofFloat(button, "alpha", 0f, 1f)
        fadeInAnimatorButton.duration = 2000

        // ObjectAnimator for button move up
        val moveUpAnimatorButton = ObjectAnimator.ofFloat(button, "translationY", 100f, 0f)  // Moves up to its final position
        moveUpAnimatorButton.duration = 1000

        // AnimatorSet to run fade in and move up animations together after a delay
        val animatorSetButton = AnimatorSet()
        animatorSetButton.playTogether(fadeInAnimatorButton, moveUpAnimatorButton)
        animatorSetButton.startDelay = 3000  // Start both animations after a delay
        animatorSetButton.start()

        button.setOnClickListener {
            val intent = Intent(this, DescriptionActivity::class.java)
            startActivity(intent)
        }
    }
}
