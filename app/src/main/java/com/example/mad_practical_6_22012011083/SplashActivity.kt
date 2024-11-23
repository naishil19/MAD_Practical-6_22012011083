package com.example.mad_practical_6_22012011083
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var gunianimation:AnimationDrawable
    lateinit var tweenanimation:Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        val uvpce_imageview = findViewById<ImageView>(R.id.uvpce_imageview)
        uvpce_imageview.setBackgroundResource(R.drawable.uvpce_animation_list)
        gunianimation = uvpce_imageview.background as AnimationDrawable
        tweenanimation = AnimationUtils.loadAnimation(this,R.anim.tween)
        tweenanimation.setAnimationListener(this)
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus){
            gunianimation.start()
            findViewById<ImageView>(R.id.uvpce_imageview).startAnimation(tweenanimation)
        }
        else{
            (gunianimation.stop())
        }
    }
    override fun onAnimationStart(p0: Animation?) {
    }
    override fun onAnimationEnd(p0: Animation?) {
        Intent(this,MainActivity::class.java).also{startActivity(it)
        }
    }
    override fun onAnimationRepeat(p0: Animation?) {
    }
}