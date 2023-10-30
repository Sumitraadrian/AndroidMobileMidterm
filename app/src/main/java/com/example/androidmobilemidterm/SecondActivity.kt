package com.example.androidmobilemidterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Build
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class SecondActivity : AppCompatActivity() {
    // Deklarasi TextView
    private lateinit var userTextView: TextView
    private lateinit var cityTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.statusBarColor)
        }

        // Inisialisasi TextView
        userTextView = findViewById(R.id.user)
        cityTextView = findViewById(R.id.cities)

        val intent: Intent = intent
        val selectedCity = intent.getStringExtra("selectedCity")
        val enteredName = intent.getStringExtra("enteredName")

        if (selectedCity != null && enteredName != null) {
            userTextView.text = "Hello, $enteredName"
            cityTextView.text = selectedCity
        }

        // Inisialisasi tombol "See Menus"
        val seeMenusButton = findViewById<Button>(R.id.button_menu)

        seeMenusButton.setOnClickListener {
            // Menjalankan ThirdActivity saat tombol "See Menus" ditekan
            val intent = Intent(this, ThirdActivity::class.java)

            intent.putExtra("selectedCity", selectedCity)
            intent.putExtra("enteredName", enteredName)
            startActivity(intent)
        }
    }
}
