package com.example.test.presentation.ui.view.menu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test.R
import com.example.test.databinding.MenuItemBinding
import com.example.test.domain.model.UIProduct

class MenuAdapter(private val productList: List<UIProduct>): RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            val product = productList[position]
            Glide.with(root)
                .load(R.drawable.pizza)
                .into(foodIcon)
            foodName.text = product.name
            description.text = product.description
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = MenuItemBinding.bind(itemView)
    }
}