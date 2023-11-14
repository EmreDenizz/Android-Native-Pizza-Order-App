/**
 * @author Emre Deniz
 * @student_number 301371047
 * @date Oct 13, 2023
 * @description: Android Assignment 2 - Pizza Online App
 */

package com.example.emredeniz_mapd711_assignment2_pizzaonline

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ForthActivity : AppCompatActivity() {
    // Initialize a lateinit property for SharedPreferences
    lateinit var  sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forth)

        // Set action bar title
        supportActionBar?.setTitle("Fresh Pizza")

        // Initialize UI elements
        var sizeText: TextView = findViewById(R.id.textPizzaSize)
        var typeText: TextView = findViewById(R.id.textPizzaType)
        var toppingsText: TextView = findViewById(R.id.textPizzaToppings)
        var customerNameText: TextView = findViewById(R.id.textViewCustomerName)
        var addressText: TextView = findViewById(R.id.textViewAddress)

        // Initialize SharedPreferences
        sharedPreferences = this.getSharedPreferences("SharedPrefPizzaOnline", Context.MODE_PRIVATE)

        // Retrieve stored data from SharedPreferences
        var pizzaSize = sharedPreferences.getString("pizzaSize", "")
        if(pizzaSize == "Small ($10)"){pizzaSize = "Small" }
        else if(pizzaSize == "Medium ($15)"){pizzaSize = "Medium" }
        else if(pizzaSize == "Large ($20)"){pizzaSize = "Large" }
        var customerName = sharedPreferences.getString("customerName", "")
        var pizzaType = sharedPreferences.getString("pizzaType", "")
        var pizzaToppings = sharedPreferences.getString("pizzaToppings", "")
        var address = sharedPreferences.getString("address", "")

        // Set the texts with the values from SharedPreferences
        customerNameText.text = customerName
        sizeText.text = pizzaSize
        typeText.text = pizzaType
        toppingsText.text = pizzaToppings
        addressText.text = address
    }
}
