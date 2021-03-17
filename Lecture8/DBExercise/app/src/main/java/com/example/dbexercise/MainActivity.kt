package com.example.dbexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var name : EditText
    private lateinit var address : EditText
    private lateinit var age : EditText
    private lateinit var button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getViewInstances()


        button.setOnClickListener {
            if (name.text.toString().isNotEmpty() && address.text.toString().isNotEmpty() && age.text.toString().isNotEmpty()) {
                var user = User(name.text.toString(), address.text.toString(), age.text.toString().toInt())
                var db = DatabaseHandler(this);
                db.inserData(user)
            } else{
                Toast.makeText(this, "Please Fill All Data", Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun getViewInstances(){
        button = findViewById(R.id.button)
        name = findViewById(R.id.etName)
        address = findViewById(R.id.etAddress)
        age = findViewById(R.id.etAge)

    }
}