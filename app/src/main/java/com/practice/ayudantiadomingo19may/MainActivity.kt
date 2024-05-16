package com.practice.ayudantiadomingo19may

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encuentra el botón por su ID
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.text)

        // Crear un ObjectAnimator para rotar en el eje Z
        val animator = ObjectAnimator.ofFloat(textView, "rotationY", 0f, 360f)
        animator.duration = 8000  // Duración de la animación en milisegundos
        animator.repeatCount = ObjectAnimator.INFINITE  // Repetir indefinidamente
        animator.interpolator = LinearInterpolator()  // Interpolador lineal para rotación uniforme
        animator.start()  // Iniciar la animación

        // Asigna un click listener al botón
        button.setOnClickListener {
            // Crea una instancia de la clase SecondActivity
            val intent = Intent(this, SecondActivity::class.java)
            // Inicia la actividad
            startActivity(intent)
        }



    }
}
