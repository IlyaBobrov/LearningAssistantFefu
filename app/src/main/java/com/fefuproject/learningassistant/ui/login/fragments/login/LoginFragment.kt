package com.fefuproject.learningassistant.ui.login.fragments.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
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
//    private lateinit var viewModel: LoginViewModel


//    lateinit var observer: Observer<String>
//    private var livedata = MyLiveData()

/*
    private val viewModel: LoginViewModel by navGraphViewModels(R.id.nested_graph) {
        defaultViewModelProviderFactory
    }
*/


    var login: String = ""
    var pas: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
//        livedata.value = "hello"

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
            checkFields()
            startMainActivity()
        }
    }

    private fun checkFields() {
        login = binding.etLoginAuth.text.toString().trim()
        pas = binding.etPasswordAuth.text.toString()
//        livedata.setLogin(login)

//        viewModel.login = login
//        viewModel.user.value
    }

    private fun startMainActivity() {
        startActivity(Intent(requireContext(), MainActivity::class.java))
        requireActivity().finish()
    }

    private fun setupObservers() {

        /*observer = Observer {
            showMessage(it)
            Log.e("TAG", "ld: $it", )
        }*/

        /*viewModel.getUsers().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) Log.d("TAG", "setupObservers: SUCCESS")
                    showMessage(it.data.toString())

                }
                Resource.Status.ERROR -> {
                    Log.d("TAG", "setupObservers: ${it.message}")
                    showMessage(it.message.toString())
                }
                Resource.Status.LOADING -> Log.d("TAG", "setupObservers: loading")
            }
        })*/
    }

    fun showMessage(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
//        livedata.observe(requireActivity(), observer)
    }

    override fun onStop() {
        super.onStop()
//        livedata.removeObserver(observer)

    }

}