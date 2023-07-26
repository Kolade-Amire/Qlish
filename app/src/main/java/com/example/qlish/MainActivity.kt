package com.example.qlish

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen


class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var keepSplashOnScreen = true
        val delay = 7000L

        SplashScreen.Companion
        installSplashScreen()
            .setKeepOnScreenCondition { keepSplashOnScreen }
        Handler(Looper.getMainLooper()).postDelayed({ keepSplashOnScreen = false }, delay)
        super.onCreate(savedInstanceState)

    }

}