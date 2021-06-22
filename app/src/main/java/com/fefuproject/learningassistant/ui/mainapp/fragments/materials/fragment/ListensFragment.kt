package com.fefuproject.learningassistant.ui.mainapp.fragments.materials.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fefuproject.learningassistant.R

class ListensFragment : Fragment() {

    companion object {
        fun newInstance() = ListensFragment()
    }

    private lateinit var viewModel: ListensViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_materials_listens, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListensViewModel::class.java)
        // TODO: Use the ViewModel
    }

}