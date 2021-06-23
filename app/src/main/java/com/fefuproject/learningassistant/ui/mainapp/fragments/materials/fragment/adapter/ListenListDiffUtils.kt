package com.fefuproject.learningassistant.ui.mainapp.fragments.materials.fragment.adapter

import androidx.recyclerview.widget.DiffUtil
import com.fefuproject.learningassistant.data.entities.MatetialModel

class ListenListDiffUtils: DiffUtil.ItemCallback<MatetialModel>() {


    override fun areItemsTheSame(oldItem: MatetialModel, newItem: MatetialModel): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: MatetialModel, newItem: MatetialModel): Boolean = oldItem == newItem

}