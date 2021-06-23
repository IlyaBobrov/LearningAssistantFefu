package com.fefuproject.learningassistant.ui.mainapp.fragments.materials.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fefuproject.learningassistant.R
import com.fefuproject.learningassistant.data.entities.MatetialModel

class MaterialsAdapter(
    val materialOnItemClickListener: MaierialOnItemClickListener
) : ListAdapter<MatetialModel, RecyclerView.ViewHolder>(MaterialListDiffUtils()) {

    companion object {
        const val TYPE_STANDART = 1
    }

    private var currentPosition: Int = 0

    override fun getItemViewType(position: Int): Int {
        currentPosition = position
        return TYPE_STANDART
    }

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return itemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_home_materials, parent, false)
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as itemViewHolder).bindItemHolder(getItem(position))


    inner class itemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var title: TextView = itemView.findViewById(R.id.tvTitleItemMaterial)

        fun bindItemHolder(currentItem: MatetialModel) {
            itemView.setOnClickListener(this)
            title.text = currentItem.heading
        }

        override fun onClick(v: View) {
            materialOnItemClickListener.onItemClick(
                v,
                getItem(absoluteAdapterPosition),
                absoluteAdapterPosition
            )
        }
    }


    interface MaierialOnItemClickListener {
        fun onItemClick(v: View, item: MatetialModel, position: Int)
    }

}