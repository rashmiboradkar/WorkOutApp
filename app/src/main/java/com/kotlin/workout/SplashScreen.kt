package com.kotlin.workout

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class SplashScreen : AppCompatActivity() {
    private var image: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash_screen)

        initialise()

        val prefs = getSharedPreferences(LoginActivity.MY_LOGIN_PREFS, MODE_PRIVATE)
        val email = prefs.getString(LoginActivity.USER_EMAIL, "")
        val pass = prefs.getString(LoginActivity.USER_PASSWORD, "")

       Handler().postDelayed({

            if (email == "" && pass == "") {
                val intent = Intent(this@SplashScreen, WelcomeActivity::class.java)
                startActivity(intent)
                this@SplashScreen.finish()
            } else {
                val intent = Intent(this@SplashScreen, StartExercise::class.java)
                startActivity(intent)
                this@SplashScreen.finish()
            }
        }, 500)
    }

    private fun initialise() {
        image = findViewById(R.id.splashLogo)

    }
}