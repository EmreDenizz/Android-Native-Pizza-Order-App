/**
 * @author Emre Deniz
 * @student_number 301371047
 * @date Oct 13, 2023
 * @description: Android Assigment 2 - Pizza Online App
 */

package com.example.emredeniz_mapd711_assignment2_pizzaonline

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {
    // Initialize a lateinit property for SharedPreferences
    lateinit var  sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set action bar title
        supportActionBar?.setTitle("Fresh Pizza")

        // Initialize SharedPreferences
        sharedPreferences = this.getSharedPreferences("SharedPrefPizzaOnline", Context.MODE_PRIVATE)
    }

    // Inflate top menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    // Menu selection actions
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Pizza type selected. jump to next activity
        when(item.itemId) {
            R.id.cheese -> {
                sharedPreferences.edit().putString("pizzaType", "Cheese Pizza").apply()
                startActivity(Intent(this@MainActivity,SecondActivity::class.java))
            }
            R.id.veggie -> {
                sharedPreferences.edit().putString("pizzaType", "Veggie Pizza").apply()
                startActivity(Intent(this@MainActivity,SecondActivity::class.java))
            }
            R.id.pepperoni -> {
                sharedPreferences.edit().putString("pizzaType", "Pepperoni Pizza").apply()
                startActivity(Intent(this@MainActivity,SecondActivity::class.java))
            }
            R.id.chicken -> {
                sharedPreferences.edit().putString("pizzaType", "Chicken Pizza").apply()
                startActivity(Intent(this@MainActivity,SecondActivity::class.java))
            }
            R.id.supreme -> {
                sharedPreferences.edit().putString("pizzaType", "Supreme Pizza").apply()
                startActivity(Intent(this@MainActivity,SecondActivity::class.java))
            }
        }
        return true
    }
}
