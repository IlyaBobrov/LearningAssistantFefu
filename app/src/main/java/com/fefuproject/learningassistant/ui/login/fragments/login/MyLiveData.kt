package com.fefuproject.learningassistant.ui.login.fragments.login

import android.util.Log
import androidx.lifecycle.LiveData

class MyLiveData : LiveData<String>() {


    fun setLogin(login: String) {
        value = login
    }

    override fun onActive() {
        super.onActive()
        Log.d("TAG", "onActive: livedata")
    }

    override fun onInactive() {
        super.onInactive()
        Log.d("TAG", "onInactive: ")
    }
}