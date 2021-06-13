package com.fefuproject.learningassistant.ui.login.fragments.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.fefuproject.learningassistant.data.repository.UserRepository


class LoginViewModel
@ViewModelInject
constructor(
    repository: UserRepository
) : ViewModel() {

//    val users = repository.getUser()
}
