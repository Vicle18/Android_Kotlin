package com.example.glidelibraryexercise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageAdapter(private val context: Context) : RecyclerView.Adapter<ImageAdapter.ViewHolder>()  {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var imageView: ImageView = v.findViewById(R.id.ivCell)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_image_adapter, parent, false))
    }

    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {
        val urlToCall = String.format("https://picsum.photos/500/500?image=%d", position)
        Glide.with(context).clear(holder.imageView)
        Glide.with(context).load(urlToCall).into(holder.imageView)    }

    override fun getItemCount(): Int {
        return 75
    }

}