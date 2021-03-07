package com.example.fragments

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(R.layout.activity_main), View.OnClickListener {
    private lateinit var button_white: Button;
    private lateinit var button_red: Button;
    private lateinit var button_blue: Button;
    private lateinit var button_green: Button;
    private lateinit var button: Button
    private val manager = supportFragmentManager;
    val fragment1 = Fragment1();
    val fragment2 = Fragment2()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment1)
            commit()
        }

    }

    fun setListeners() {
        button_white = findViewById(R.id.button_white)
        button_red = findViewById(R.id.button_red)
        button_blue = findViewById(R.id.button_blue)
        button_green = findViewById(R.id.button_green)
        button_white.setOnClickListener(this);
        button_red.setOnClickListener(this)
        button_blue.setOnClickListener(this);
        button_green.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        if (button_blue.isPressed) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment, fragment1)
                addToBackStack(null)
                commit()

            }
        } else if (button_red.isPressed) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment, fragment2)
                addToBackStack(null)
                commit()
            }
        } else if (button_green.isPressed) {

        } else if (button_white.isPressed) {

        }
    }



}


