package com.example.challengeme.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _editState = MutableLiveData<HomeEditState>()
    val editState: LiveData<HomeEditState> = _editState

    fun enableEditState() {
        _editState.value =
            HomeEditState(isEnable = true)
    }

    fun disableEditState() {
        _editState.value =
            HomeEditState(isEnable = false)
    }

}