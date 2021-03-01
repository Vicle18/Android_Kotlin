package com.example.recyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.viewmodels.NumberViewModel

class MainActivity : AppCompatActivity(), CustomAdapter.ViewHolderListener {
    private lateinit var view: TextView;
    private lateinit var recyclerView : RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: CustomAdapter;
    val viewModel: NumberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager;

        adapter = CustomAdapter();
        adapter.setNumbers(viewModel.getNumbers().value!!);
        recyclerView.adapter = adapter;

        viewModel.getNumbers().observe(this, {numbers ->
            adapter.setNumbers(numbers);
        })

    }





}