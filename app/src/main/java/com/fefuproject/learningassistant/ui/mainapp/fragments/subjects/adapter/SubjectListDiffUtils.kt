package com.fefuproject.learningassistant.ui.mainapp.fragments.subjects.adapter

import androidx.recyclerview.widget.DiffUtil
import com.fefuproject.learningassistant.data.entities.SubjectModel


class SubjectListDiffUtils : DiffUtil.ItemCallback<SubjectModel>() {


    override fun areItemsTheSame(oldItem: SubjectModel, newItem: SubjectModel): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: SubjectModel, newItem: SubjectModel): Boolean =
        oldItem == newItem

}