package com.example.multipleactivityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.EditText

class Birth : AppCompatActivity() {
    var previousMessage : String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birth)
        previousMessage = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE).toString();
    }


    /** Called when the user taps the Send button */
    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.editTextDate)
        val message = previousMessage + "\n" + editText.text.toString()
        val intent = Intent(this, DisplayData::class.java).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}