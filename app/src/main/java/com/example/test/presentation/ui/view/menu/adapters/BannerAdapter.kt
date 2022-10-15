package com.example.test.presentation.ui.view.menu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test.R
import com.example.test.databinding.BannerItemBinding

class BannerAdapter: RecyclerView.Adapter<BannerAdapter.ViewHolder>() {

    private val banners = listOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3,    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.banner_item, parent, false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            Glide.with(root).load(banners[position]).into(banner)
        }
    }

    override fun getItemCount(): Int {
        return banners.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = BannerItemBinding.bind(itemView)
    }
}