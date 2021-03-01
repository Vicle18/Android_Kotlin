package com.example.recyclerview.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.google.android.material.snackbar.Snackbar


class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private lateinit var numbers: ArrayList<Number>;
    private lateinit var removeButton: Button;

    constructor(listener: ViewHolderListener) : super() {
        this.listener = listener
    }

    fun setNumbers(numberList: ArrayList<Number>) {
        numbers = numberList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.view, viewGroup, false)
        val tv = v.findViewById<TextView>(R.id.textView2)
        return ViewHolder(v, tv);
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text= numbers.get(position).toString()
    }

    override fun getItemCount() = numbers.size

    class ViewHolder(frameLayout: View?, val textView: TextView) : RecyclerView.ViewHolder(frameLayout!!)

    fun deleteNumber(position: Int, v: View){
        val message = String.format("Removing item at position: %s with value: %s", position,  numbers[position].value)
        Log.i("CustomAdapter", message)

        val number = numbers[position]
        val snack = Snackbar.make(v!!, message, Snackbar.LENGTH_LONG)
        snack.setAction("Undo") {
            listener.addNumberOnClick(position, number)

        }
    }
}