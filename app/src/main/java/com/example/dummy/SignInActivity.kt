package com.example.dummy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Button

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signUpText = findViewById<TextView>(R.id.tv_sign_up)
        val cancelButton = findViewById<TextView>(R.id.tv_cancel)


        signUpText.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }
}
