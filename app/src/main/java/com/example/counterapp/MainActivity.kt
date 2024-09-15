package com.example.counterapp

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("counter_prefs", Context.MODE_PRIVATE)
        val counter = sharedPreferences.getInt("counter", 0) + 1
        sharedPreferences.edit().putInt("counter", counter).apply()

        val shapeCounter : View = findViewById(R.id.redCircleView)
        val counterTextView: TextView = findViewById(R.id.counterTextView)
        counterTextView.text = counter.toString()


        val fadeIn = AlphaAnimation(0.0f, 1.0f)
        fadeIn.duration = 1000 // Duración de la animación en milisegundos
        fadeIn.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                counterTextView.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animation?) {

            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
        shapeCounter.startAnimation(fadeIn)
        counterTextView.startAnimation(fadeIn)
    }
}