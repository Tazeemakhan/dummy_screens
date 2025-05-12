package com.example.dummy

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.FirebaseFirestore

class BasicInformationActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        db = FirebaseFirestore.getInstance()

        val etName = findViewById<EditText>(R.id.etName)
        val etAge = findViewById<EditText>(R.id.etage)
        val etGender = findViewById<AutoCompleteTextView>(R.id.etgender)
        val etActivity = findViewById<AutoCompleteTextView>(R.id.etActivity)
        val etHeight = findViewById<AutoCompleteTextView>(R.id.etHeight)
        val etWeight = findViewById<TextView>(R.id.etWeight)
        val etAllergy = findViewById<AutoCompleteTextView>(R.id.etAllergy)
        val etNextButton = findViewById<Button>(R.id.etnextButton)

        val genders = arrayOf("Male", "Female")
        val genderAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, genders)
        etGender.setAdapter(genderAdapter)
        etGender.setOnClickListener { etGender.showDropDown() }

        val activityOptions = arrayOf("Sedentary", "Moderate", "Very Active")
        val activityAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, activityOptions)
        etActivity.setAdapter(activityAdapter)
        etActivity.setOnClickListener { etActivity.showDropDown() }

        val AllergyOptions = arrayOf("Milk / Dairy", "Eggs","Peanuts","Tree Nuts (almonds, cashews etc.)","Wheat/gluten","soyBean","Fish","Corn","None", "Very Active")
        val AllergyAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, AllergyOptions)
        etActivity.setAdapter(activityAdapter)
        etActivity.setOnClickListener { etActivity.showDropDown() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etNextButton.setOnClickListener {
            val name = etName.text.toString().trim()
            val age = etAge.text.toString().trim()
            val gender = etGender.text.toString().trim()
            val activityLevel = etActivity.text.toString().trim()
            val Height = etHeight.text.toString().trim()
            val Weight = etWeight.text.toString().trim()
            val Allergy = etAllergy.text.toString().trim()

            if (name.isEmpty() || age.isEmpty() || gender.isEmpty() || activityLevel.isEmpty()  || Weight.isEmpty() ) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = hashMapOf(
                "name" to name,
                "age" to age,
                "gender" to gender,
                "activityLevel" to activityLevel,
                "Height" to Height,
                "Weight" to Weight,
                "Allergy" to Allergy,
            )

            db.collection("users")
                .add(user)
                .addOnSuccessListener {
                    Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Failed: ${e.message}", Toast.LENGTH_LONG).show()
                }
        }
    }
}