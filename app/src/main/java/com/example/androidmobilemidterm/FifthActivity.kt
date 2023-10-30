package com.example.androidmobilemidterm

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import android.widget.Button
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
        doneButton.setOnClickListener {
            // Cek apakah kedua checkbox tidak dicentang
            if (!pickupCheckbox.isChecked && !fastDeliveryCheckbox.isChecked) {
                Toast.makeText(this, "Please choose delivery", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Tidak melanjutkan aksi jika tidak ada yang dipilih
            }

            // Mendapatkan teks dari checkbox yang dipilih
            val deliveryMethod = if (pickupCheckbox.isChecked) "Ambil Sendiri" else "Fast Delivery"

            // Membuat pesan Toast sesuai dengan metode pengiriman yang dipilih
            val toastMessage = if (pickupCheckbox.isChecked) {
                "Terima kasih ${orderName.text} sudah memesan di toko kami. Silakan ambil pesanan Anda di Toko $selectedCity."
            } else {
                "Terima kasih ${orderName.text} sudah memesan di toko kami. Pesanan Pepperoni pizza Anda dikirim menggunakan $deliveryMethod."
            }

            // Menampilkan pesan Toast
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()

        }



    }
}
