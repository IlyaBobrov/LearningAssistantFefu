package com.fefuproject.learningassistant.ui.mainapp.fragments.subjects.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fefuproject.learningassistant.R
import com.fefuproject.learningassistant.data.entities.SubjectModel
import com.fefuproject.learningassistant.databinding.FragmentMainTestsSubjectsBinding
import com.fefuproject.learningassistant.ui.mainapp.fragments.materials.fragment.ListensFragment
import com.fefuproject.learningassistant.ui.mainapp.fragments.subjects.SubjectsFragment.Companion.SUBJECT_THEME
import com.fefuproject.learningassistant.ui.mainapp.fragments.subjects.fragment.adapter.TestsSubjectsAdapter

class TestsSubjectsFragment : Fragment(), TestsSubjectsAdapter.SubjectOnItemClickListener {

    companion object {
        fun newInstance() = TestsSubjectsFragment()
        const val SUBJECT_ITEM = "SUBJECT_ITEM"
    }

    private lateinit var viewModel: TestsSubjectsViewModel

    private var _binding: FragmentMainTestsSubjectsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewList: MutableList<SubjectModel>

    private val adapterSubjects = TestsSubjectsAdapter(this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainTestsSubjectsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getBundleData()
    }

    private fun getBundleData() {
        viewList = arguments?.getParcelableArrayList<SubjectModel>(SUBJECT_THEME)!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TestsSubjectsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerview()
        initRV()
    }

    private fun initRV() {
        adapterSubjects.submitList(viewList)
    }

    private fun setupRecyclerview() {
        binding.rvTestsSubjects.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterSubjects
        }
    }

    override fun onItemClick(v: View, item: SubjectModel, position: Int) {
        val bundle = Bundle()
        bundle.putParcelable(SUBJECT_ITEM, item)
        findNavController().navigate(R.id.action_testsSubjectsFragment_to_testingFragment, bundle)
    }
}