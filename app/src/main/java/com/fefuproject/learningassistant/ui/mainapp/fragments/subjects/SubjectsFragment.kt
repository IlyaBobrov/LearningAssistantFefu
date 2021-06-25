package com.fefuproject.learningassistant.ui.mainapp.fragments.subjects

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fefuproject.learningassistant.R
import com.fefuproject.learningassistant.data.entities.SubjectModel
import com.fefuproject.learningassistant.databinding.FragmentMainSubjectsBinding
import com.fefuproject.learningassistant.ui.mainapp.fragments.subjects.adapter.SubjectsAdapter
import java.util.*

class SubjectsFragment : Fragment(), SubjectsAdapter.SubjectOnItemClickListener {

    companion object {
        fun newInstance() = SubjectsFragment()
        const val SUBJECT_THEME = "SUBJECT_THEME"
    }

    private lateinit var viewModel: SubjectsViewModel

    private lateinit var listSubjects: MutableList<SubjectModel>
    private lateinit var viewList: MutableList<SubjectModel>

    private val adapterSubjects = SubjectsAdapter(this)


    private var _binding: FragmentMainSubjectsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainSubjectsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SubjectsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterSubjects.submitList(null)
        generateData()
        setupRecyclerview()
        sortAndSetData()
    }

    private fun setupRecyclerview() {
        binding.rvSubjects.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterSubjects
        }
    }


    private fun sortAndSetData() {
        viewList = mutableListOf<SubjectModel>()
        var flag = false
        listSubjects.forEach { dataItem ->
            viewList.forEach {
                flag = dataItem.heading == it.heading
            }
            if (!flag) {
                viewList.add(dataItem)
            } else {
                flag = false
            }
        }

        adapterSubjects.submitList(viewList)
    }



    private fun generateData() {
        listSubjects = mutableListOf(
            SubjectModel(1, UUID.randomUUID().toString(), "Конкуренция и рыночные структуры", "Тема 1", requireContext().getString(R.string.stop_text_2)),
            SubjectModel(2, UUID.randomUUID().toString(), "Конкуренция и рыночные структуры", "Тема 2", requireContext().getString(R.string.stop_text_2)),
            SubjectModel(3, UUID.randomUUID().toString(), "Конкуренция и рыночные структуры", "Тема 3", requireContext().getString(R.string.stop_text_2)),
            SubjectModel(4, UUID.randomUUID().toString(), "Конкуренция и рыночные структуры", "Тема 4", requireContext().getString(R.string.stop_text_2)),
            SubjectModel(5, UUID.randomUUID().toString(), "Конкуренция и рыночные структуры", "Тема 5", requireContext().getString(R.string.stop_text_2)),
            SubjectModel(6, UUID.randomUUID().toString(), "Поведение потребителя", "Тема 1", requireContext().getString(R.string.stop_text_2)),
            SubjectModel(7, UUID.randomUUID().toString(), "Поведение потребителя", "Тема 2", requireContext().getString(R.string.stop_text_2)),
            SubjectModel(8, UUID.randomUUID().toString(), "Поведение потребителя", "Тема 3", requireContext().getString(R.string.stop_text_2)),
            SubjectModel(9, UUID.randomUUID().toString(), "Фирма. Производство и издержки", "Тема 1", requireContext().getString(R.string.stop_text_2)),
            SubjectModel(10, UUID.randomUUID().toString(), "Фирма. Производство и издержки", "Тема 2", requireContext().getString(R.string.stop_text_2)),
            SubjectModel(11, UUID.randomUUID().toString(), "Рынки факторов производства", "Тема 1", requireContext().getString(R.string.stop_text_2)),
            SubjectModel(12, UUID.randomUUID().toString(), "Рынки факторов производства", "Тема 2", requireContext().getString(R.string.stop_text_2)),
            SubjectModel(13, UUID.randomUUID().toString(), "Деньги и банковская система", "Тема 1", requireContext().getString(R.string.stop_text_2)),
            SubjectModel(14, UUID.randomUUID().toString(), "Деньги и банковская система", "Тема 2", requireContext().getString(R.string.stop_text_2)),
            SubjectModel(15, UUID.randomUUID().toString(), "Предпринимательство", "Тема 1", requireContext().getString(R.string.stop_text_2)),
            SubjectModel(16, UUID.randomUUID().toString(), "Предпринимательство", "Тема 2", requireContext().getString(R.string.stop_text_2)),
            SubjectModel(17, UUID.randomUUID().toString(), "Инфляция", "Тема 1", requireContext().getString(R.string.stop_text_2))
        )
    }

    override fun onItemClick(v: View, item: SubjectModel, position: Int) {
        val bundle = Bundle()

        var parseList = mutableListOf<SubjectModel>()

        listSubjects.forEach { dataItem ->
            if (dataItem.heading == item.heading)
                parseList.add(dataItem)
        }

        bundle.putParcelableArrayList(SUBJECT_THEME, parseList as ArrayList<SubjectModel>)

        findNavController().navigate(R.id.action_navigation_subjects_to_testsSubjectsFragment, bundle)
    }
}