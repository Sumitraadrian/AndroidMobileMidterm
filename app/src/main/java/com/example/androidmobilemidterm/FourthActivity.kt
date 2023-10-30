package com.example.androidmobilemidterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Build
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.statusBarColor)
        }

        val buttonOrder = findViewById<Button>(R.id.button_order)

        val enteredName = intent.getStringExtra("enteredName")
        val selectedCity = intent.getStringExtra("selectedCity")
        val selectedItem = intent.getStringExtra("selectedItem")
        val selectedMenu = intent.getStringExtra("selectedMenu")
        val menuItemName = intent.getStringExtra("selectedItem")
        val menuName = findViewById<TextView>(R.id.menu_name)
        menuName.text = menuItemName


        val menuImage = findViewById<ImageView>(R.id.menu_image)
        val priceTag = findViewById<TextView>(R.id.price_tag)
        val pizzaDesc = findViewById<TextView>(R.id.pizza_desc)

        // Mengakses nama makanan
        val pizzaName = resources.getString(R.string.pepperoni_pizza)
        val spaghettiName = resources.getString(R.string.spaghetti_name)
        val burgerName = resources.getString(R.string.burger_name)
        val steakName = resources.getString(R.string.steak_name)

        // Mengakses harga makanan
        val pizzaPrice = resources.getString(R.string.pizza_harga)
        val spaghettiPrice = resources.getString(R.string.spaghetti_price)
        val burgerPrice = resources.getString(R.string.burger_price)
        val steakPrice = resources.getString(R.string.steak_price)

        // Mengakses deskripsi makanan
        val pizzaDescription = resources.getString(R.string.pepperoni_desk)
        val spaghettiDescription = resources.getString(R.string.spaghetti_description)
        val burgerDescription = resources.getString(R.string.burger_description)
        val steakDescription = resources.getString(R.string.steak_description)


        when (selectedItem) {
            "Pizza" -> {
                menuImage.setImageResource(R.drawable.main_pizza)
                priceTag.text = pizzaPrice
                pizzaDesc.text = pizzaDescription

            }
            "Spaghetti" -> {
                menuImage.setImageResource(R.drawable.spaghetti_label)
                priceTag.text = spaghettiPrice
                pizzaDesc.text = spaghettiDescription
            }
            "Burger" -> {
                menuImage.setImageResource(R.drawable.burger_label)
                priceTag.text = burgerPrice
                pizzaDesc.text = burgerDescription
            }
            "Steak" -> {
                menuImage.setImageResource(R.drawable.steak_label)
                priceTag.text = steakPrice
                pizzaDesc.text = steakDescription
            }
        }

        buttonOrder.setOnClickListener {
            // Pindah ke FifthActivity
            Intent(this, FifthActivity::class.java).also {
                it.putExtra("enteredName", enteredName)
                it.putExtra("selectedCity", selectedCity)
                it.putExtra("selectedItem", selectedItem)

                startActivity(it)
            }
        }

        val backButton = findViewById<Button>(R.id.button_back)

        backButton.setOnClickListener {
            // Kembali ke aktivitas sebelumnya
            finish()
        }
    }
}
