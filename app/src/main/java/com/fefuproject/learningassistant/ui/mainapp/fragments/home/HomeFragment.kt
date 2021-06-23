package com.fefuproject.learningassistant.ui.mainapp.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fefuproject.learningassistant.R
import com.fefuproject.learningassistant.databinding.FragmentMainHomeBinding
import com.fefuproject.learningassistant.ui.mainapp.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentMainHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentMainHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolBar()
        initRau()
    }

    private fun initRau() {
        binding.tvRauHome.text = "0.0"
    }

    private fun initToolBar() {
//        (requireActivity() as MainActivity).setToolbarTitle(requireContext().getString(R.string.Main))

        /*(requireActivity() as MainActivity).binding.topAppBar.apply {

            menu.setGroupVisible(R.id.group_toolbar_search, false)

            setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.tbHelp -> {

                        //todo
                        true
                    }
                    else -> false
                }
            }

        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}