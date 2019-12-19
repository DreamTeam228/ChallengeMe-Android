package com.example.challengeme.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.example.challengeme.R
import com.example.challengeme.AsynchronousRequests.RegistrationAsyncTask
import com.example.challengeme.AsynchronousRequests.asyncResult.AsyncResult

class RegistrationViewModel : ViewModel() {

    private val _registrationForm = MutableLiveData<RegistrationFormState>()
    val registrationFormState: LiveData<RegistrationFormState> = _registrationForm

    private val _registrationResult = MutableLiveData<AsyncResult>()
    val registrationResult: LiveData<AsyncResult> = _registrationResult

    fun login(username: String, password: String, displayName: String) {
        // can be launched in a separate asynchronous job

        val result = RegistrationAsyncTask(
            username,
            password,
            displayName
        ).execute("http://188.225.46.84").get()
        _registrationResult.value = result

    }

    fun registrationDataChanged(displayName: String, username: String, password: String, confirm_password: String) {
        if (!isDisplayNameValid(displayName)) {      // проверяем валидность пароля
            _registrationForm.value = RegistrationFormState(displayNameError = R.string.invalid_displayName)  // присваиваем состояние ошибки
        } else if (!isUserNameValid(username)) { // проверям валидность логина
            _registrationForm.value = RegistrationFormState(usernameError = R.string.invalid_username)  // присваем состояние ошибки
        } else if (!isPasswordValid(password)) {      // проверяем валидность пароля
            _registrationForm.value = RegistrationFormState(passwordError = R.string.invalid_password)  // присваиваем состояние ошибки
        } else if (!isPasswordConfirmed(password,confirm_password)) {
            _registrationForm.value = RegistrationFormState(confirmError = R.string.invalid_confirm)
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

    private fun isPasswordConfirmed(pass:String,confirm_pass:String):Boolean {
        return pass == confirm_pass
    }
}
