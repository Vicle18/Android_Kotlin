package com.example.multipleactivityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.EditText

class Address : AppCompatActivity() {
    private var TAG : String = "AddressActivity";
    var previousMessage : String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        /** Get the message from MainActivity*/
        previousMessage = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE).toString();
    }

    override fun onStart() {
        super.onStart()

        Log.i(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
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