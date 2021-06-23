package com.fefuproject.learningassistant.ui.login.fragments.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fefuproject.learningassistant.data.entities.User
import com.fefuproject.learningassistant.data.repository.UserRepository
import com.fefuproject.learningassistant.utils.Resource
import kotlinx.coroutines.launch


class LoginViewModel
@ViewModelInject
constructor(
    private val repository: UserRepository
) : ViewModel() {

//    var login: String = ""

//    private val users = repository.getUsers()

//    fun getUsers(): LiveData<List<User>> = repository.getUserWithLogin(login)

    /*fun getUsers(): LiveData<Resource<List<User>>> {

        viewModelScope.launch {
            repository.getUsers()
        }

        return users
    }*/


}
