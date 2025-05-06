package com.example.dummy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.FirebaseFirestore
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val db = FirebaseFirestore.getInstance()

        val maleBtn = findViewById<Button>(R.id.male_btn)
        val femaleBtn = findViewById<Button>(R.id.female_btn)

        maleBtn.setOnClickListener {
            storeGenderToFirestore("Male", db)
        }

        femaleBtn.setOnClickListener {
            storeGenderToFirestore("Female", db)
        }

        }
    private fun storeGenderToFirestore(gender: String, db: FirebaseFirestore) {
        val genderData = hashMapOf(
            "gender" to gender
        )

        db.collection("users")
            .add(genderData)
            .addOnSuccessListener {
                Toast.makeText(this, "Gender saved successfully!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error saving gender: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
    }

