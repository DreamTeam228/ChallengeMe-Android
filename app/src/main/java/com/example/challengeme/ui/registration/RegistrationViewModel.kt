package com.example.challengeme.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns

import com.example.challengeme.R
import com.example.challengeme.AsynchronousRequests.RegistrationAsyncTask

class RegistrationViewModel : ViewModel() {

    private val _registrationForm = MutableLiveData<RegistrationFormState>()
    val registrationFormState: LiveData<RegistrationFormState> = _registrationForm

    private val _registrationResult = MutableLiveData<RegistrationResult>()
    val registrationResult: LiveData<RegistrationResult> = _registrationResult

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job

        val result = RegistrationAsyncTask(
            username,
            password
        ).execute("http://188.225.46.84").get()
        _registrationResult.value = result

    }

    fun registrationDataChanged(username: String, password: String, displayName: String) {
        if (!isUserNameValid(username)) { // проверям валидность логина
            _registrationForm.value = RegistrationFormState(usernameError = R.string.invalid_username)  // присваем состояние ошибки
        } else if (!isPasswordValid(password)) {      // проверяем валидность пароля
            _registrationForm.value = RegistrationFormState(passwordError = R.string.invalid_password)  // присваиваем состояние ошибки
        } else if (!isDisplayNameValid(displayName)) {      // проверяем валидность пароля
            _registrationForm.value = RegistrationFormState(displayNameError = R.string.invalid_displayName)  // присваиваем состояние ошибки
        } else {
            _registrationForm.value = RegistrationFormState(isDataValid = true)   //если все ок - меняем флаг, который разблокирует кнопку
        }
        // else if(!isUserNameUnique) { и погнали ошибку }
    }

    // fun isUserNameUnique(...) и вот тут вызываем пост запрос

    private fun isDisplayNameValid(displayName: String): Boolean {
        return displayName.length > 4
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 4
    }
}
