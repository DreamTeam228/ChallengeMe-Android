package com.example.challengeme.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Возможно, здесь скоро будет чат!"
    }
    val text: LiveData<String> = _text
}