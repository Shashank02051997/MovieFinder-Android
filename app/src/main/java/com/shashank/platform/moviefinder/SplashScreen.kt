package com.shashank.platform.moviefinder

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.shashank.platform.moviefinder.R

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash_screen)
        val timerThread = object : Thread() {
            override fun run() {
                try {
                    sleep(3000)
                    val i = Intent(this@SplashScreen, Login::class.java)
                    startActivity(i)
                    finish()
                } catch (e: Exception) {
                }

            }
        }
        timerThread.start()
    }
}
