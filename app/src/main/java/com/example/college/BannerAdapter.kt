package com.example.college

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.college.R

class BannerAdapter(private val imageUrls: List<Int>) :
    RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_banner, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val imageResId = imageUrls[position]
        holder.bind(imageResId)
    }

    override fun getItemCount(): Int {
        return imageUrls.size
    }

    inner class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.bannerImageView)

        fun bind(imageResId: Int) {
            // 이미지 리소스 ID를 String으로 변환하여 이미지를 표시합니다.
            Glide.with(itemView)
                .load("android.resource://${itemView.context.packageName}/$imageResId")
                .into(imageView)
        }
    }
}
