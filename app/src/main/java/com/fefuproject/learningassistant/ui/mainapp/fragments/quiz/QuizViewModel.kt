package com.fefuproject.learningassistant.ui.mainapp.fragments.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "В разработке"
    }
    val text: LiveData<String> = _text
}