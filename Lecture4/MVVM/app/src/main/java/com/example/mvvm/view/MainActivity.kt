package com.example.mvvm.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvm.R
import com.example.mvvm.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button;
    private lateinit var view: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel: MyViewModel by viewModels()

        button = findViewById(R.id.button_joke);
        view = findViewById(R.id.textView);

        button.setOnClickListener(){
            viewModel.loadJokes()
        }

        viewModel.getJokes().observe(this, {jokes ->
            view.text = jokes.text;
        })
    }
}