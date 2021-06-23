package com.fefuproject.learningassistant.ui.mainapp.fragments.materials.fragment.theory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fefuproject.learningassistant.data.entities.MatetialModel
import com.fefuproject.learningassistant.databinding.FragmentMainMaterialTheoryBinding
import com.fefuproject.learningassistant.ui.mainapp.fragments.materials.fragment.ListensFragment

class TheoryFragment : Fragment() {

    companion object {
        fun newInstance() = TheoryFragment()
    }

    private lateinit var viewModel: TheoryViewModel

    lateinit var material: MatetialModel

    private var _binding: FragmentMainMaterialTheoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getBundleData()
    }

    private fun getBundleData() {
        material = requireArguments().getParcelable(ListensFragment.MATERIAL_ITEM)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainMaterialTheoryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TheoryViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setContent()

    }

    private fun setContent() {
        binding.tvTitleTheory.text = material.heading
        binding.tvTitleTheme.text = material.subject
        binding.tvBodyTheorem.text = material.text
    }

}