package com.example.listepays3

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CatalogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        val listView = findViewById<ListView>(R.id.listViewProducts)
        val products = resources.getStringArray(R.array.products)

        // Une icône par produit, dans le même ordre que strings.xml
        val images = listOf(
            android.R.drawable.ic_menu_call,            // Téléphone
            android.R.drawable.ic_menu_share,           // Câble USB
            android.R.drawable.ic_lock_idle_charging,   // Chargeur
            android.R.drawable.ic_menu_recent_history,  // Apple Watch
            android.R.drawable.ic_lock_silent_mode_off, // Casque Bluetooth
            android.R.drawable.ic_menu_slideshow,       // PC portable
            android.R.drawable.ic_menu_manage           // Carte graphique
        )

        listView.adapter = ProductAdapter(this, products, images)

        listView.setOnItemClickListener { parent, _, position, _ ->
            val item = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, "Produit sélectionné : $item", Toast.LENGTH_LONG).show()
        }
    }
}