package com.erald.digitalelectrician.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.erald.digitalelectrician.R
import com.erald.digitalelectrician.databinding.StructureBasicBinding
import com.erald.digitalelectrician.model.BasicModel

/**
 * BasicAdapter.kt
 *
 * This class represents the adapter for the home list.
 * @param context               - the application context
 * @param items                 - list of home items
 * @param onHomeClickListener   - interface to implement the onClick
 * */
class BasicAdapter(private val context: Context,
                   private val items: MutableList<BasicModel>,
                   private var onHomeClickListener: OnBasicClickListener
                   ) : RecyclerView.Adapter<BasicAdapter.BasicViewHolder>() {

    inner class BasicViewHolder(private var binding: StructureBasicBinding,
                                private var onHomeClickListener: OnBasicClickListener)
        : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(basicModel: BasicModel) {
            binding.textViewBasicItem.text = context.resources.getString(basicModel.title);
            binding.constraintStructureBasic.background.setTint(ContextCompat.getColor(context, basicModel.color))
            itemView.animation = AnimationUtils.loadAnimation(context, R.anim.recycler_view_item_anim)

            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            onHomeClickListener.onClick(adapterPosition, items)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicViewHolder {
        val binding = StructureBasicBinding.inflate(LayoutInflater.from(context), parent, false)
        return BasicViewHolder(binding, onHomeClickListener)
    }

    override fun onBindViewHolder(holder: BasicViewHolder, position: Int) {
        val basicModel = items[position]
        with(holder) {
            bind(basicModel)
        }
    }

    override fun getItemCount(): Int = items.size

    /**
     * Interface for invoking the click event for each element of itemView
     * */
    interface OnBasicClickListener {
        fun onClick(position: Int, items: MutableList<BasicModel>)
    }

}