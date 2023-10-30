package com.example.androidmobilemidterm

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.widget.LinearLayout
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
        textViewName.text = "Hello, $enteredName"

        val fab = findViewById<FloatingActionButton>(R.id.fab_icon)


        val pizzaLayout = findViewById<LinearLayout>(R.id.pizzaLayout)
        val spaghettiLayout = findViewById<LinearLayout>(R.id.spaghettiLayout)
        val burgerLayout = findViewById<LinearLayout>(R.id.burgerLayout)
        val steakLayout = findViewById<LinearLayout>(R.id.steakLayout)

        var selectedLayout: LinearLayout? = null
        var selectedItem: String? = null

        pizzaLayout.setOnLongClickListener {
            if (selectedLayout != pizzaLayout) {
                selectedLayout?.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))

                pizzaLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.blok))
                selectedLayout = pizzaLayout
                selectedItem = "Pizza"
            }
            true
        }

        spaghettiLayout.setOnLongClickListener {
            if (selectedLayout != spaghettiLayout) {
                selectedLayout?.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))

                spaghettiLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.blok))
                selectedLayout = spaghettiLayout
                selectedItem = "Spaghetti"
            }
            true
        }

        burgerLayout.setOnLongClickListener {
            if (selectedLayout != burgerLayout) {
                selectedLayout?.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))

                burgerLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.blok))
                selectedLayout = burgerLayout
                selectedItem = "Burger"
            }
            true
        }

        steakLayout.setOnLongClickListener {
            if (selectedLayout != steakLayout) {
                selectedLayout?.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))

                steakLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.blok))
                selectedLayout = steakLayout
                selectedItem = "Steak"
            }
            true
        }
        fab.setOnClickListener {
            if (selectedLayout != null) {
                val intent = Intent(this, FourthActivity::class.java)
                intent.putExtra("selectedCity", selectedCity)
                intent.putExtra("enteredName", enteredName)
                intent.putExtra("selectedItem", selectedItem)

                if (selectedLayout == pizzaLayout) {
                    intent.putExtra("selectedItem", "Pizza")
                } else if (selectedLayout == spaghettiLayout) {
                    intent.putExtra("selectedItem", "Spaghetti")
                } else if (selectedLayout == burgerLayout) {
                    intent.putExtra("selectedItem", "Burger")
                } else if (selectedLayout == steakLayout) {
                    intent.putExtra("selectedItem", "Steak")
                }

                startActivity(intent)
            } else {
                Toast.makeText(this, "Long press to choose menu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

