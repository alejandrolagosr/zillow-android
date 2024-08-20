package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemImageBinding


class ImagesAdapter(private val images: List<String>): RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {

    class ImageViewHolder(private val view: ItemImageBinding): ViewHolder(view.root) {

        fun bind(imageUrl: String) {
            Glide.with(view.root.context)
                .load(imageUrl)
                .into(view.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position])
    }
}