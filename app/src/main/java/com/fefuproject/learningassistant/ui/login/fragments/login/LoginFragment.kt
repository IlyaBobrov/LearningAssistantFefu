package com.fefuproject.learningassistant.ui.login.fragments.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.fefuproject.learningassistant.R
import com.fefuproject.learningassistant.databinding.FragmentAuthLoginBinding
import com.fefuproject.learningassistant.ui.mainapp.MainActivity
import com.fefuproject.learningassistant.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var binding: FragmentAuthLoginBinding by autoCleared()
    val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupObservers()
    }

    private fun setupListeners() {
        binding.tvBtnAuthRegHere.setOnClickListener {
//            findNavController().navigate(R.id.registrationFragment)
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }

        binding.tvBtnAuthForgetPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_rePasswordFragment)
        }

        binding.btnAuthEnter.setOnClickListener {
            //TODO check fields
            startMainActivity()
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(requireContext(), MainActivity::class.java))
        requireActivity().finish()
    }

    private fun setupObservers() {
        /*viewModel.users.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) Log.d("TAG", "setupObservers: SUCCESS")
                }
                Resource.Status.ERROR -> Log.d("TAG", "setupObservers: ${it.message}")

                Resource.Status.LOADING -> Log.d("TAG", "setupObservers: loading")
            }
        })*/
    }

}