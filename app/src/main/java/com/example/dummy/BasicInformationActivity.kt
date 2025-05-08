package com.example.dummy

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
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

        val etName = findViewById<EditText>(R.id.etName)
        val etage = findViewById<EditText>(R.id.etage)
        val etgender = findViewById<AutoCompleteTextView>(R.id.etgender)
        val etActivity = findViewById<AutoCompleteTextView>(R.id.etActivity)
        val etnextButton = findViewById<Button>(R.id.etnextButton)

        // gender dropdown
        val genderField = findViewById<AutoCompleteTextView>(R.id.etgender)
        val genders = arrayOf("Male", "Female")

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, genders)
        genderField.setAdapter(adapter)

        genderField.setOnClickListener {
            genderField.showDropDown()
        }
        //  Activity Level dropdown
        val activityLevelField = findViewById<AutoCompleteTextView>(R.id.etActivity)
        val activityOptions = arrayOf("Sedentary", "Moderate", "Very Active")
        val activityAdapter =
            ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, activityOptions)
        activityLevelField.setAdapter(activityAdapter)
        activityLevelField.setOnClickListener { activityLevelField.showDropDown() }

        etnextButton.setOnClickListener {
            val name = etName.text.toString().trim()
            val age = etage.text.toString().trim()
            val gender = findViewById<AutoCompleteTextView>(R.id.etgender)
            val Activity_level = findViewById<AutoCompleteTextView>(R.id.etActivity)


            if (name.isEmpty() && age.isEmpty()) {
                Toast.makeText(this, "Please fill the credentials ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = hashMapOf(
                "name" to name,
                "age" to age,
            )

            db.collection("Users")
                .add(user)
                .addOnSuccessListener {
                    Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
                }

                .addOnFailureListener { e ->
                    Toast.makeText(this, "Failed: ${e.message}", Toast.LENGTH_LONG).show()
                }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}