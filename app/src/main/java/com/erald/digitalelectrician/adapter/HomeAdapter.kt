package com.erald.digitalelectrician.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.erald.digitalelectrician.R
import com.erald.digitalelectrician.databinding.StructureHomeBinding
import com.erald.digitalelectrician.model.HomeModel

class HomeAdapter(private val context: Context, private val items: MutableList<HomeModel>)
    : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(var binding: StructureHomeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = StructureHomeBinding.inflate(LayoutInflater.from(context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        with(holder) {
            with(items[position]) {
                binding.textViewHomeListTitle.text = title
                binding.homeCardView.background.setTint(ContextCompat.getColor(context, color))
            }

            // animation
            holder.itemView.animation = AnimationUtils.loadAnimation(context, R.anim.recycler_view_item_anim)
        }
    }

    override fun getItemCount() = items.size

}