package com.fefuproject.learningassistant.ui.mainapp.fragments.subjects.fragment.testing

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fefuproject.learningassistant.R
import com.fefuproject.learningassistant.data.entities.SubjectModel
import com.fefuproject.learningassistant.databinding.FragmentMainSubjectsTestingBinding
import com.fefuproject.learningassistant.databinding.FragmentMainTestsSubjectsBinding
import com.fefuproject.learningassistant.ui.mainapp.fragments.materials.fragment.ListensFragment
import com.fefuproject.learningassistant.ui.mainapp.fragments.subjects.fragment.TestsSubjectsFragment.Companion.SUBJECT_ITEM

class TestingFragment : Fragment() {

    companion object {
        fun newInstance() = TestingFragment()
    }

    private lateinit var viewModel: TestingViewModel

    private var _binding: FragmentMainSubjectsTestingBinding? = null
    private val binding get() = _binding!!

    private lateinit var subject: SubjectModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getBundleData()
    }

    private fun getBundleData() {
        subject = requireArguments().getParcelable(SUBJECT_ITEM)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainSubjectsTestingBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TestingViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setContent()
    }

    private fun setContent() {

        binding.tvTitleTesting.text = subject.heading
        binding.tvTitleThemeTesting.text = subject.subject
        binding.tvBodyTheoremTesting.text = subject.text

    }

}