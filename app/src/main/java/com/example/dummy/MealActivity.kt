// MealActivity.kt
package com.example.dummy

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

class MealActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etHeight: EditText
    private lateinit var etWeight: EditText
    private lateinit var etGoalWeight: EditText
    private lateinit var spinnerActivity: Spinner
    private lateinit var spinnerAllergy: Spinner
    private lateinit var btnGenerate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mealplan)

        // Binding views
        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        etHeight = findViewById(R.id.etHeight)
        etWeight = findViewById(R.id.etWeight)
        etGoalWeight = findViewById(R.id.etGoalWeight)
        spinnerActivity = findViewById(R.id.spinnerActivityLevel)
        spinnerAllergy = findViewById(R.id.spinnerAllergy)
        btnGenerate = findViewById(R.id.btnGenerate)
        tvResult = findViewById(R.id.tvResult)

        // Activity Level Spinner
        val activityLevels = arrayOf("Sedentary", "Active", "Very Active")
        val activityAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, activityLevels)
        activityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerActivity.adapter = activityAdapter

        // Allergy Spinner
        val allergyOptions = arrayOf("None", "Milk", "Eggs", "Peanuts", "Wheat", "Soy", "Seafood", "Tree nuts")
        val allergyAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, allergyOptions)
        allergyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerAllergy.adapter = allergyAdapter

        // Button Click Listener
        btnGenerate.setOnClickListener {
            val name = etName.text.toString()
            val ageStr = etAge.text.toString()
            val heightStr = etHeight.text.toString()
            val weightStr = etWeight.text.toString()
            val goalWeightStr = etGoalWeight.text.toString()

            // Validate Age
            val age = ageStr.toIntOrNull()
            if (age == null || age < 18) {
                Toast.makeText(this, "Age must be 18 or older", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validate other required fields (optional)
            if (name.isEmpty() || heightStr.isEmpty() || weightStr.isEmpty() || goalWeightStr.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val activityLevel = spinnerActivity.selectedItem.toString()
            val allergy = spinnerAllergy.selectedItem.toString()

            // Output message
            val result = """
                ✅ Your Entered Profile:
                
                Name: $name
                Age: $age
                Height: $heightStr inches
                Weight: $weightStr kg
                Goal Weight: $goalWeightStr kg
                Activity Level: $activityLevel
                Allergy: $allergy

                🎯 Diet plan will be generated based on this information!
            """.trimIndent()

            tvResult.visibility = View.VISIBLE
            tvResult.text = result
        }
    }
}
