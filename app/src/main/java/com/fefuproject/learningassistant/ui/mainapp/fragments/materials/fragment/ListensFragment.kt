package com.fefuproject.learningassistant.ui.mainapp.fragments.materials.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fefuproject.learningassistant.R
import com.fefuproject.learningassistant.data.entities.MatetialModel
import com.fefuproject.learningassistant.databinding.FragmentMainMaterialsListensBinding
import com.fefuproject.learningassistant.ui.mainapp.fragments.materials.MaterialsFragment.Companion.CODE_OPEN
import com.fefuproject.learningassistant.ui.mainapp.fragments.materials.MaterialsFragment.Companion.KEY_READ
import com.fefuproject.learningassistant.ui.mainapp.fragments.materials.MaterialsFragment.Companion.MATERIAL_THEME
import com.fefuproject.learningassistant.ui.mainapp.fragments.materials.adapters.ListensAdapter

class ListensFragment : Fragment(), ListensAdapter.ListenOnItemClickListener {

    companion object {
        fun newInstance() = ListensFragment()

        const val MATERIAL_ITEM = "MATERIAL_ITEM"
    }

    private lateinit var viewModel: ListensViewModel

    private lateinit var viewList: MutableList<MatetialModel>

    private var _binding: FragmentMainMaterialsListensBinding? = null
    private val binding get() = _binding!!

    private val adapterListen = ListensAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getBundleData()
    }

    private fun getBundleData() {
        when (arguments?.get(CODE_OPEN)) {
            KEY_READ -> {
                viewList = arguments?.getParcelableArrayList<MatetialModel>(MATERIAL_THEME)!!
                Log.d("TAG", "getBundleData: $viewList")
            }

            else -> {
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainMaterialsListensBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListensViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerview()
        initRV()
    }

    private fun initRV() {
        adapterListen.submitList(viewList)
    }

    private fun setupRecyclerview() {
        binding.rvListens.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterListen
        }
    }

    override fun onItemClick(v: View, item: MatetialModel, position: Int) {
        val bundle = Bundle()
        bundle.putParcelable(MATERIAL_ITEM, item)
        findNavController().navigate(R.id.action_listensFragment_to_theoryFragment, bundle)
    }

}