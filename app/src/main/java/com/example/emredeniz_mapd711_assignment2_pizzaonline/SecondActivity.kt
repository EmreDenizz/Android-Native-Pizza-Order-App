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
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    // Initialize a lateinit property for SharedPreferences
    lateinit var  sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Initialize UI elements
        var radioGroup: RadioGroup = findViewById(R.id.pizzaSize)
        var ContinueButton: Button = findViewById(R.id.buttonContinue)
        var checkBox: CheckBox = findViewById(R.id.checkBox)
        var checkBox2: CheckBox = findViewById(R.id.checkBox2)
        var checkBox3: CheckBox = findViewById(R.id.checkBox3)
        var checkBox4: CheckBox = findViewById(R.id.checkBox4)
        var checkBox5: CheckBox = findViewById(R.id.checkBox5)
        var checkBox6: CheckBox = findViewById(R.id.checkBox6)
        var checkBox7: CheckBox = findViewById(R.id.checkBox7)
        var checkBox8: CheckBox = findViewById(R.id.checkBox8)

        // Set action bar title
        supportActionBar?.setTitle("Fresh Pizza")

        // Initialize SharedPreferences
        sharedPreferences = this.getSharedPreferences("SharedPrefPizzaOnline", Context.MODE_PRIVATE)

        // Continue button actions
        ContinueButton.setOnClickListener {
            val selectedRadioButtonId: Int = radioGroup.checkedRadioButtonId
            // Check if the pizza size selected from radio button
            if (selectedRadioButtonId != -1) {
                var selectedRadioButton: RadioButton = findViewById(selectedRadioButtonId)
                var selectedRadioButtonText = selectedRadioButton.text;
                sharedPreferences.edit().putString("pizzaSize", selectedRadioButtonText.toString()).apply()

                // Calculate total amount
                var total_amount = "";
                if(selectedRadioButtonText == "Small ($10)"){total_amount = "$10";}
                else if(selectedRadioButtonText == "Medium ($15)"){total_amount = "$15";}
                else if(selectedRadioButtonText == "Large ($20)"){total_amount = "$20";}
                sharedPreferences.edit().putString("totalAmount", total_amount).apply()

                // Get toppings
                var toppings = ""
                var isAnyCheckBoxSelected = 0
                if (checkBox.isChecked) {isAnyCheckBoxSelected = 1; toppings += checkBox.text}
                if (checkBox2.isChecked) {isAnyCheckBoxSelected = 1; toppings += checkBox2.text}
                if (checkBox3.isChecked) {isAnyCheckBoxSelected = 1; toppings += checkBox3.text}
                if (checkBox4.isChecked) {isAnyCheckBoxSelected = 1; toppings += checkBox4.text}
                if (checkBox5.isChecked) {isAnyCheckBoxSelected = 1; toppings += checkBox5.text}
                if (checkBox6.isChecked) {isAnyCheckBoxSelected = 1; toppings += checkBox6.text}
                if (checkBox7.isChecked) {isAnyCheckBoxSelected = 1; toppings += checkBox7.text}
                if (checkBox8.isChecked) {isAnyCheckBoxSelected = 1; toppings += checkBox8.text}
                sharedPreferences.edit().putString("pizzaToppings", toppings).apply()

                // Check if at least one topping is selected. if so, jump to payment page
                if(isAnyCheckBoxSelected == 1){
                    startActivity(Intent(this@SecondActivity,ThirdActivity::class.java))
                }
                else{
                    // Alert for selecting at least one topping
                    Toast.makeText(this, "Please select at least one topping", Toast.LENGTH_LONG).show()
                }
            }
            else {
                // Alert for selecting pizza size
                Toast.makeText(this, "Please select the pizza size", Toast.LENGTH_LONG).show()
            }
        }
    }
}
