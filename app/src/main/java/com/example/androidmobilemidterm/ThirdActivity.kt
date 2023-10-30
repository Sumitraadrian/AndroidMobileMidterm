package com.example.androidmobilemidterm

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.widget.ImageView
import android.widget.Toast

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.statusBarColor)
        }

        val intent: Intent = intent
        val enteredName = intent.getStringExtra("enteredName")
        val selectedCity = intent.getStringExtra("selectedCity")

        val textViewName = findViewById<TextView>(R.id.user)
        val pizzaIcon = findViewById<ImageView>(R.id.pizza_icon)
        val spaghettiIcon = findViewById<ImageView>(R.id.spaghetti_icon)
        val burgerIcon = findViewById<ImageView>(R.id.burger_icon)
        val steakIcon = findViewById<ImageView>(R.id.steak_icon)

        textViewName.text = "Hello, $enteredName"
        val fab = findViewById<FloatingActionButton>(R.id.fab_icon)

        pizzaIcon.setOnClickListener {
            val message = getString(R.string.toast_pepperoni_pizza)
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        spaghettiIcon.setOnClickListener {
            val message = getString(R.string.toast_spaghetti)
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        burgerIcon.setOnClickListener {
            val message = getString(R.string.toast_burger)
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        steakIcon.setOnClickListener {
            val message = getString(R.string.toast_steak)
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        fab.setOnClickListener {
            // Pindah ke FourthActivity
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("selectedCity", selectedCity)
            intent.putExtra("enteredName", enteredName)
            startActivity(intent)
        }
    }
}
