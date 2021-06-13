package com.fefuproject.learningassistant.ui.login.fragments.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.fefuproject.learningassistant.databinding.FragmentAuthRegistrationBinding
import com.fefuproject.learningassistant.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    val viewModel: RegistrationViewModel by viewModels()
    private var binding: FragmentAuthRegistrationBinding by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        binding.tvBtnBtnAuthReg.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}