package com.fefuproject.learningassistant.ui.login.fragments.repass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.fefuproject.learningassistant.databinding.FragmentAuthRepasswordBinding
import com.fefuproject.learningassistant.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RePasswordFragment : Fragment() {

    private val viewModel: RepasswordViewModel by viewModels()
    private var binding: FragmentAuthRepasswordBinding by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthRepasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        setupListeners()
        setupCallback()
    }

    private fun setupCallback() {
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    findNavController().popBackStack()

                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    private fun setupListeners() {
        binding.tvBtnInputAuthRepass.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}