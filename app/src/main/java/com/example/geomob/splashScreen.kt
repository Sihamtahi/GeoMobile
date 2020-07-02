package com.example.geomob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView


class splashScreen : AppCompatActivity() {

    lateinit var handler: Handler
    ///animation variable
    lateinit var animationTop  : Animation
    lateinit var imageView:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        animationTop = AnimationUtils.loadAnimation(this,R.anim.top_animation)
        imageView = findViewById(R.id.pineLogo)
        imageView.animation = animationTop
        handler = Handler()
        handler.postDelayed({

            // Delay and Start Activity
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        } , 3000) // here we're delaying to startActivity after 3seconds

    }

}
