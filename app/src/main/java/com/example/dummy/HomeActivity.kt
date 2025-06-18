package com.example.dummy

import com.example.dummy.MealActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bmiText = findViewById<TextView>(R.id.bmiText)
        val mealCard = findViewById<LinearLayout>(R.id.mealCard)
        val hydrationCard = findViewById<LinearLayout>(R.id.hydrationCard)
        val calorieCard = findViewById<LinearLayout>(R.id.calorieCard)
        val progressCard = findViewById<LinearLayout>(R.id.progressCard)


        // Replace these target Activities with your actual Activity class names

        bmiText.setOnClickListener {
            // Yahan BmiActivity ko start karenge
            startActivity(Intent(this, BmiActivity::class.java))
        }
        mealCard.setOnClickListener {
            startActivity(Intent(this, MealActivity::class.java))
        }
        hydrationCard.setOnClickListener {
            startActivity(Intent(this, HydrationActivity::class.java))
        }
        calorieCard.setOnClickListener {
             startActivity(Intent(this, CalorieActivity::class.java))
        }
        progressCard.setOnClickListener {
            // startActivity(Intent(this, ProgressActivity::class.java))
        }
    }

}

