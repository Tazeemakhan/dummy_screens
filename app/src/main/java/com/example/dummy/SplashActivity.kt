package com.example.nutriplan

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.nutriplan.SignInActivity // Import SignInActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, SignInActivity::class.java) // Make sure SignInActivity is imported
            startActivity(intent)
            finish()
        }, 2000) // 2-second delay
    }
}
