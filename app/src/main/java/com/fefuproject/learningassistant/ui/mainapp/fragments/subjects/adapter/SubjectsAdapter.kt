package com.fefuproject.learningassistant.ui.mainapp.fragments.subjects.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fefuproject.learningassistant.R
import com.fefuproject.learningassistant.data.entities.MatetialModel
import com.fefuproject.learningassistant.data.entities.SubjectModel

class SubjectsAdapter(
    val subjectlOnItemClickListener: SubjectOnItemClickListener
) : ListAdapter<SubjectModel, RecyclerView.ViewHolder>(SubjectListDiffUtils()) {

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
                .inflate(R.layout.item_home_subjects, parent, false)
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as itemViewHolder).bindItemHolder(getItem(position))


    inner class itemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var title: TextView = itemView.findViewById(R.id.tvTitleItemSubject)

        fun bindItemHolder(currentItem: SubjectModel) {
            itemView.setOnClickListener(this)
            title.text = currentItem.heading
        }

        override fun onClick(v: View) {
            subjectlOnItemClickListener.onItemClick(
                v,
                getItem(absoluteAdapterPosition),
                absoluteAdapterPosition
            )
        }
    }


    interface SubjectOnItemClickListener {
        fun onItemClick(v: View, item: SubjectModel, position: Int)
    }

}