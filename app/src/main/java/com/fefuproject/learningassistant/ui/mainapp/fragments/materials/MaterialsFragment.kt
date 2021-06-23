package com.fefuproject.learningassistant.ui.mainapp.fragments.materials

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fefuproject.learningassistant.R
import com.fefuproject.learningassistant.data.entities.MatetialModel
import com.fefuproject.learningassistant.databinding.FragmentMainMaterialsBinding
import com.fefuproject.learningassistant.ui.mainapp.MainActivity
import com.fefuproject.learningassistant.ui.mainapp.fragments.materials.adapters.MaterialsAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class MaterialsFragment : Fragment(), MaterialsAdapter.MaierialOnItemClickListener {

    companion object {
        const val MATERIAL_THEME = "MATERIAL_THEME"
        const val CODE_OPEN = "CODE_OPEN"
        const val KEY_READ = "KEY_READ"
    }

    private lateinit var materialsViewModel: MaterialsViewModel

    private val adapterMaterials = MaterialsAdapter(this)

    private lateinit var data: MutableList<MatetialModel>
    private lateinit var viewList: MutableList<MatetialModel>


    private var _binding: FragmentMainMaterialsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        materialsViewModel =
            ViewModelProvider(this).get(MaterialsViewModel::class.java)

        _binding = FragmentMainMaterialsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textDashboard
        materialsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar()
        setupRecyclerview()
        onListener()
        getDataFromDB()

        adapterMaterials.submitList(null)

        generateData()
        sortAndSetData()
    }


    private fun generateData() {
        data = mutableListOf<MatetialModel>(
            MatetialModel(
                1,
                UUID.randomUUID().toString(),
                "Ленгвистика",
                "Тема 1. Японский алфавит",
                requireContext().getString(R.string.stop_text_1)
            ),
            MatetialModel(
                2,
                UUID.randomUUID().toString(),
                "Ленгвистика",
                "Тема 2. Японский. Произношение",
                requireContext().getString(R.string.stop_text_1)
            ),
            MatetialModel(
                3,
                UUID.randomUUID().toString(),
                "Ленгвистика",
                "Тема 3. Японский. Грамамтика",
                requireContext().getString(R.string.stop_text_1)
            ),
            MatetialModel(
                4,
                UUID.randomUUID().toString(),
                "Химия",
                "Тема 1. Газы в окружающей среде",
                requireContext().getString(R.string.stop_text_1)
            ),
            MatetialModel(
                5,
                UUID.randomUUID().toString(),
                "Химия",
                "Тема 2. Газы. Реакции",
                requireContext().getString(R.string.stop_text_1)
            ),
            MatetialModel(
                6,
                UUID.randomUUID().toString(),
                "История",
                "Тема 1. Японская война",
                requireContext().getString(R.string.stop_text_1)
            ),
            MatetialModel(
                7,
                UUID.randomUUID().toString(),
                "Общетвознание",
                "Тема 1. Политика Японии 19 века",
                requireContext().getString(R.string.stop_text_1)
            ),
            MatetialModel(
                8,
                UUID.randomUUID().toString(),
                "Общетвознание",
                "Тема 2. Политика Японии 20 века",
                requireContext().getString(R.string.stop_text_1)
            ),
            MatetialModel(
                9,
                UUID.randomUUID().toString(),
                "Общетвознание",
                "Тема 3. Политика Японии 21 века",
                requireContext().getString(R.string.stop_text_1)
            ),
            MatetialModel(
                10,
                UUID.randomUUID().toString(),
                "Общетвознание",
                "Тема 4. Политика Китая 19 века",
                requireContext().getString(R.string.stop_text_1)
            ),
            MatetialModel(
                11,
                UUID.randomUUID().toString(),
                "Общетвознание",
                "Тема 5. Политика Китая 20 века",
                requireContext().getString(R.string.stop_text_1)
            ),
            MatetialModel(
                12,
                UUID.randomUUID().toString(),
                "Общетвознание",
                "Тема 6. Политика Китая 21 века",
                requireContext().getString(R.string.stop_text_1)
            ),
        )


    }

    private fun sortAndSetData() {
        viewList = mutableListOf<MatetialModel>()
        var flag = false
        data.forEach { dataItem ->
            viewList.forEach {
                flag = dataItem.heading == it.heading
            }
            if (!flag) {
                viewList.add(dataItem)
            } else {
                flag = false
            }
        }

        adapterMaterials.submitList(viewList)
    }

    private fun getDataFromDB() {
    }

    private fun initToolbar() {

//        (requireActivity() as MainActivity).setToolbarTitle(requireContext().getString(R.string.Materials))

        /*(requireActivity() as MainActivity).binding.topAppBar.apply {
            setOnMenuItemClickListener { menuItem ->
                menu.setGroupVisible(R.id.group_toolbar_search, true)
                when (menuItem.itemId) {
                    R.id.tbHelp -> {
                        //todo
                        true
                    }
                    R.id.tbSerch -> {
                        Toast.makeText(context, getString(R.string.in_develop), Toast.LENGTH_SHORT)
                            .show()
                        true
                    }
                    else -> false
                }
            }
        }*/
    }

    private fun setupRecyclerview() {
        binding.rvMaterials.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterMaterials
        }
    }

    private fun onListener() {
        binding.containerFilterMaterials.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(v: View, item: MatetialModel, position: Int) {
        val bundle = Bundle()
        bundle.putString(CODE_OPEN, KEY_READ)

        var parseList = mutableListOf<MatetialModel>()

        data.forEach { dataItem ->
            if (dataItem.heading == item.heading)
                parseList.add(dataItem)
        }

        bundle.putParcelableArrayList(MATERIAL_THEME, parseList as ArrayList<MatetialModel>)

        findNavController().navigate(R.id.action_homeFragment_to_taskFragment, bundle)
    }
}