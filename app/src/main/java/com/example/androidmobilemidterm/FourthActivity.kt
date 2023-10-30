package com.example.androidmobilemidterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Build
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.statusBarColor)
        }


        val buttonOrder = findViewById<Button>(R.id.button_order)
        val buttonBack = findViewById<Button>(R.id.button_back)

        val enteredName = intent.getStringExtra("enteredName")
        val selectedCity = intent.getStringExtra("selectedCity")

        buttonOrder.setOnClickListener {
            Intent(this, FifthActivity::class.java).also {
                it.putExtra("enteredName", enteredName)
                it.putExtra("selectedCity", selectedCity)
                startActivity(it)
            }
        }

        val backButton = findViewById<Button>(R.id.button_back)

        backButton.setOnClickListener(View.OnClickListener {
            // Kembali ke aktivitas sebelumnya
            finish()
        })
    }
}
