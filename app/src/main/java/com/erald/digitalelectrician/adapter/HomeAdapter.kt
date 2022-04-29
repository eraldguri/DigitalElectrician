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

/**
 * HomeAdapter.kt
 *
 * This class represents the adapter for the home list.
 * @param context               - the application context
 * @param items                 - list of home items
 * @param onHomeClickListener   - interface to implement the onClick
 * */
class HomeAdapter(private val context: Context,
                  private val items: MutableList<HomeModel>,
                  private var onHomeClickListener: OnHomeClickListener
                  ) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    /**
     * This class represents the ViewHolder for adapter item
     *
     * @param binding               - view binding for this class
     * @param onHomeClickListener   - interface for invoking the click event on each item
     * */
    inner class HomeViewHolder(var binding: StructureHomeBinding,
                               private var onHomeClickListener: OnHomeClickListener
    )
        : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        /**
         * This methods binds views to the values from items list
         *
         * @param homeModel - This is the model class of the item
         * */
        fun bind(homeModel: HomeModel) {
            binding.textViewHomeListTitle.text = context.resources.getString(homeModel.title);
            binding.homeCardView.background.setTint(ContextCompat.getColor(context, homeModel.color))
            itemView.animation = AnimationUtils.loadAnimation(context, R.anim.recycler_view_item_anim)

            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            onHomeClickListener.onClick(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = StructureHomeBinding.inflate(LayoutInflater.from(context), parent, false)
        return HomeViewHolder(binding, onHomeClickListener)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val homeModel = items[position]
        with(holder) {
            bind(homeModel)
        }
    }

    override fun getItemCount() = items.size

    /**
     * Interface for invoking the click event for each element of itemView
     * */
    interface OnHomeClickListener {
        fun onClick(position: Int)
    }

}