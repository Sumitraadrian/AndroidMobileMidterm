package com.example.androidmobilemidterm

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var citySpinner: Spinner
    private lateinit var nameInput: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.statusBarColor)
        }
        val nameInputLayout = findViewById<TextInputLayout>(R.id.name_input)
        val nameInputText = findViewById<TextInputEditText>(R.id.name_input_text)

// Simpan hint awal dalam variabel
        val initialHint = nameInputLayout.hint

// Atur hint pada TextInputLayout dan EditText ke awal
        nameInputLayout.hint = initialHint
        nameInputText.hint = initialHint

        nameInputText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                // Ketika kotak isian mendapatkan fokus, hilangkan hint
                nameInputLayout.hint = ""
            } else {
                // Ketika kotak isian kehilangan fokus, kembalikan hint awal
                nameInputLayout.hint = initialHint
            }
        }

        citySpinner = findViewById(R.id.city_spinner)
        nameInput = findViewById(R.id.name_input_text)
        submitButton = findViewById(R.id.submit)

        val cityArray = resources.getStringArray(R.array.kota)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cityArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        citySpinner.adapter = adapter

        submitButton.setOnClickListener {
            val selectedCity = citySpinner.selectedItem.toString()
            val enteredName = nameInput.text.toString()

            val nameInputLayout = findViewById<TextInputLayout>(R.id.name_input)

            if (enteredName.isEmpty()) {
                // Nama kosong, set error message
                nameInputLayout.error = "Nama harus diisi"
            } else {
                // Nama diisi, clear error message and proceed
                nameInputLayout.error = null

                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("selectedCity", selectedCity)
                intent.putExtra("enteredName", enteredName)
                startActivity(intent)
            }
        }




    }


}
