package com.example.androidmobilemidterm

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

class FifthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.statusBarColor)
        }

        val orderName = findViewById<TextView>(R.id.order_user)
        val orderDistrict = findViewById<TextView>(R.id.storeInfo)

        val enteredName = intent.getStringExtra("enteredName")
        val selectedCity = "Store: " + intent.getStringExtra("selectedCity")

        orderName.text = enteredName
        orderDistrict.text = selectedCity

        val pickupCheckbox = findViewById<CheckBox>(R.id.pickupCheckbox)
        val fastDeliveryCheckbox = findViewById<CheckBox>(R.id.fastDeliveryCheckbox)

        pickupCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                fastDeliveryCheckbox.isChecked = false
                Toast.makeText(this, "Ambil Sendiri dipilih", Toast.LENGTH_SHORT).show()
            }
        }

        fastDeliveryCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                pickupCheckbox.isChecked = false
                Toast.makeText(this, "Fast Delivery dipilih", Toast.LENGTH_SHORT).show()
            }
        }

        val doneButton = findViewById<Button>(R.id.button_menu)

        val purchaseDescription = findViewById<TextView>(R.id.purchaseDescription)
        val selectedItem = intent.getStringExtra("selectedItem")

        when (selectedItem) {
            "Pizza" -> {
                purchaseDescription.text = "Pepperoni Pizza sudah dipesan"
            }
            "Spaghetti" -> {
                purchaseDescription.text = "Spaghetti sudah dipesan"
            }
            "Burger" -> {
                purchaseDescription.text = "Burger sudah dipesan"
            }
            "Steak" -> {
                purchaseDescription.text = "Steak sudah dipesan"
            }
        }

        doneButton.setOnClickListener {
            val pickupCheckbox = findViewById<CheckBox>(R.id.pickupCheckbox)
            val fastDeliveryCheckbox = findViewById<CheckBox>(R.id.fastDeliveryCheckbox)

            if (!pickupCheckbox.isChecked && !fastDeliveryCheckbox.isChecked) {

                Toast.makeText(this, "Please choose delivery method", Toast.LENGTH_SHORT).show()
            } else {
                val deliveryMethod = if (pickupCheckbox.isChecked) "Ambil Sendiri" else "Fast Delivery"

                val notifLayout = findViewById<LinearLayout>(R.id.notif_layout)
                val messageTextView = findViewById<TextView>(R.id.message)

                val message = if (pickupCheckbox.isChecked) {
                    "Terima kasih $enteredName sudah memesan di toko kami. Silakan ambil pesanan Anda di Toko $selectedCity."
                } else {
                    "Terima kasih $enteredName sudah memesan di toko kami. Pesanan $selectedItem Anda dikirim menggunakan $deliveryMethod."
                }

                messageTextView.text = message
                doneButton.text = "Back to Home"
                notifLayout.visibility = View.VISIBLE

                doneButton.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
