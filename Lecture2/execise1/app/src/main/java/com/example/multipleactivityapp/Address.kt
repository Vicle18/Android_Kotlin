package com.example.multipleactivityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText

class Address : AppCompatActivity() {
    var previousMessage : String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        /** Get the message from MainActivity*/
        previousMessage = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE).toString();
    }


        /** Called when the user taps the Send button */
        fun sendMessage(view: View) {
            val editText = findViewById<EditText>(R.id.txtAddress)
            val message = previousMessage + "\n" + editText.text.toString();
            val intent = Intent(this, Birth::class.java).apply {
                putExtra(EXTRA_MESSAGE, message)
            }
            startActivity(intent)
        }
}