package com.practice.ayudantiadomingo19may

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        textView = findViewById(R.id.text)
        progressBar = findViewById(R.id.progressBar)

        // Inicialmente ocultar texto y botón
        textView.alpha = 0f
        button.alpha = 0f

        // Mostrar el ProgressBar durante 2 segundos
        progressBar.visibility = View.VISIBLE
        Handler().postDelayed({
            progressBar.visibility = View.GONE
            startAnimations()
        }, 3000) // 2000 ms = 2 segundos
    }

    private fun startAnimations() {
        // Animación de rotación para textView
        val animatorY = ObjectAnimator.ofFloat(textView, "rotationY", 0f, 360f).apply {
            duration = 3000
            interpolator = DecelerateInterpolator()
        }

        // Animación de aparición (fade-in) para textView
        val fadeInAnimatorText = ObjectAnimator.ofFloat(textView, "alpha", 0f, 1f).apply {
            duration = 3000
        }

        // Combinar y ejecutar animaciones de textView
        AnimatorSet().apply {
            playTogether(animatorY, fadeInAnimatorText)
            start()
        }

        // Animaciones para el botón
        val fadeInAnimatorButton = ObjectAnimator.ofFloat(button, "alpha", 0f, 1f).apply {
            duration = 2000
        }
        val moveUpAnimatorButton = ObjectAnimator.ofFloat(button, "translationY", 100f, 0f).apply {
            duration = 1000
        }

        // Combinar y establecer retraso para las animaciones del botón
        AnimatorSet().apply {
            playTogether(fadeInAnimatorButton, moveUpAnimatorButton)
            startDelay = 3000 // Esperar a que termine la animación del texto
            start()
        }

        // Evento click para el botón
        button.setOnClickListener {
            startActivity(Intent(this, DescriptionActivity::class.java))
        }
    }
}
