package com.example.multipleactivityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private var TAG : String = "MainActivity";
    private var message: String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(TAG, "onCreate")
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
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val message = editText.text.toString()
        val intent = Intent(this, Address::class.java).apply {
            putExtra(EXTRA_MESSAGE, message);
        }
        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run {
            putString(MAINACTIVITY_MESSAGE, message)
        }

        //Save view hierarchy by calling superclass
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState")
    }

    companion object {
        val MAINACTIVITY_MESSAGE = "MainActivityMessage"
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        savedInstanceState?.run {
            message = getString(MAINACTIVITY_MESSAGE).toString();
        }

        //Call the superclass to restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "onRestoreInstanceState")
    }
}