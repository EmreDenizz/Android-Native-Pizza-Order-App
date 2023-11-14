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
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class ThirdActivity : AppCompatActivity() {
    // Initialize a lateinit property for SharedPreferences.
    lateinit var  sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        // Set action bar title
        supportActionBar?.setTitle("Fresh Pizza")

        // Initialize SharedPreferences
        sharedPreferences = this.getSharedPreferences("SharedPrefPizzaOnline", Context.MODE_PRIVATE)

        // Initialize UI elements
        var totalAmountText: TextView = findViewById(R.id.textTotalAmount)
        var name: EditText = findViewById(R.id.editTextName)
        var email: EditText = findViewById(R.id.editTextEmail)
        var phone: EditText = findViewById(R.id.editTextPhone)
        var address: EditText = findViewById(R.id.editTextAddress)
        var postalCode: EditText = findViewById(R.id.editTextPostalCode)
        var nameOnCard: EditText = findViewById(R.id.editTextNameOnCard)
        var cardNumber: EditText = findViewById(R.id.editTextCardNumber)
        var expiryMonth: EditText = findViewById(R.id.editTextExpiryMonth)
        var expiryYear: EditText = findViewById(R.id.editTextExpiryYear)
        var cvv: EditText = findViewById(R.id.editTextCvv)
        var radioGroup: RadioGroup = findViewById(R.id.cardType)
        val payButton = findViewById<Button>(R.id.buttonPay)

        // Retrieve stored data from SharedPreferences
        var totalAmount = sharedPreferences.getString("totalAmount", "")
        totalAmountText.text = totalAmount

        // Pay button actions
        payButton.setOnClickListener {
            // Selected card type option from radio button
            val selectedRadioButtonId: Int = radioGroup.checkedRadioButtonId

            // Input validations
            if (name.text.toString().length === 0){
                name.setError("Required.")
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
                email.setError("Please enter a valid email.")
            }
            else if (phone.text.toString().length === 0){
                phone.setError("Required.")
            }
            else if (address.text.toString().length === 0){
                address.setError("Required.")
            }
            else if (postalCode.text.toString().length === 0){
                postalCode.setError("Required.")
            }
            else if (selectedRadioButtonId == -1) {
                // Alert for selecting card type
                Toast.makeText(this, "Please select the card type.", Toast.LENGTH_LONG).show()
            }
            else if (nameOnCard.text.toString().length === 0){
                nameOnCard.setError("Required.")
            }
            else if (cardNumber.text.toString().length !== 16){
                cardNumber.setError("Please enter a valid card number.")
            }
            else if (expiryMonth.text.toString().length === 0 || expiryMonth.text.toString().toInt() < 1 || expiryMonth.text.toString().toInt() > 12){
                expiryMonth.setError("Please enter a valid expiry date.")
            }
            else if (expiryYear.text.toString().length === 0 || expiryYear.text.toString().toInt() < 23){
                expiryYear.setError("Please enter a valid expiry date.")
            }
            else if (cvv.text.toString().length !== 3){
                cvv.setError("Please enter a valid cvv.")
            }
            // Verify payment and jump to Confirmation page
            else{
                sharedPreferences.edit().putString("customerName", name.text.toString()).apply()
                sharedPreferences.edit().putString("address", address.text.toString()).apply()

                startActivity(Intent(this@ThirdActivity,ForthActivity::class.java))
            }
        }
    }
}
