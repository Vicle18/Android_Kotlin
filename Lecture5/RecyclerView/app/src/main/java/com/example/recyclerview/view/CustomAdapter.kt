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


class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private lateinit var numbers: ArrayList<Number>;

    private val listener: ViewHolderListener;

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
        val vh = ViewHolder(v, tv)
        vh.textView.setOnClickListener { v -> deleteNumber(vh.adapterPosition, v) }
        return vh;
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text= numbers.get(position).toString()
    }

    override fun getItemCount() = numbers.size

    fun deleteNumber(position: Int, v: View){
        val message = String.format("Removing item")
        Log.i("CustomAdapter", message)

        val number = numbers[position].toInt()
        val snack = Snackbar.make(v!!, message, Snackbar.LENGTH_LONG)
        snack.setAction("Undo") {
            listener.addNumberOnClick(position, number)

        }
        snack.show()
        listener.deleteNumberOnClick(position);
        notifyDataSetChanged()
    }

    class ViewHolder(frameLayout: View?, val textView: TextView) : RecyclerView.ViewHolder(frameLayout!!)



    interface ViewHolderListener {
        fun deleteNumberOnClick(position: Int)
        fun addNumberOnClick(position: Int, number: Int)
    }
}