package com.example.challengeme.ui.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.challengeme.data.LoginDataSource
import com.example.challengeme.data.LoginRepository
import com.example.challengeme.ui.login.RegistrationViewModel

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class RegistrationViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegistrationViewModel::class.java)) {
            return RegistrationViewModel(

            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
