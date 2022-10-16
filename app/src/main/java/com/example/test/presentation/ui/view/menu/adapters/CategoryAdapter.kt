package com.example.test.presentation.ui.view.menu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.CategoryItemBinding
import com.example.test.presentation.di.App

class CategoryAdapter(private val categoryList: Array<String>, private val listener: (Int) -> Unit): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    companion object {
        private var currentPosition = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {

            category.text = categoryList[position]

            if(currentPosition == position) {
                setBackground(categoryRoot, R.drawable.category_selected)
                setTextColor(category, R.color.bottom_items)
            }
            else {
                setBackground(categoryRoot, R.drawable.category_unselected)
                setTextColor(category, R.color.description)
            }

            categoryRoot.setOnClickListener {
                notifyItemChanged(currentPosition)
                currentPosition = holder.adapterPosition
                notifyItemChanged(currentPosition)
                listener(position)
            }
        }
    }

    private fun setTextColor(view: TextView, color: Int) {
        if(App.getContext() != null) {
            view.setTextColor(ResourcesCompat.getColor(
                App.getContext()!!.resources,
                color,
                null
            ))
        }
    }

    private fun setBackground(view: CardView, drawable: Int) {
        if(App.getContext() != null) {
            view.background = ResourcesCompat.getDrawable(
                App.getContext()!!.resources,
                drawable,
                null
            )
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = CategoryItemBinding.bind(itemView)
    }
}