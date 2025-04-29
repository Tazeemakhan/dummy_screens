package com.example.dummy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        val signInText = findViewById<TextView>(R.id.tv_sign_in_here)
        val cancelButton = findViewById<TextView>(R.id.tv_cancel)

        signInText.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }
}
