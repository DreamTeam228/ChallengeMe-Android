package com.example.challengeme.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.example.challengeme.data.LoginRepository
import com.example.challengeme.data.Result

import com.example.challengeme.R

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        val result = loginRepository.login(username, password)

        if (result is Result.Success) {
            // получаем результат входа
            // На основе LoggedInUser из Result собираем LoggedInUserView
            _loginResult.value =
                LoginResult(success = LoggedInUserView(displayName = result.data.login)) //если все ок - дисплеим инфу о вошедшем юзере
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed) // выводим сообщение об ошибке
        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) { // проверям валидность логина
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)  // присваем состояние ошибки
        } else if (!isPasswordValid(password)) {      // проверяем валидность пароля
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)  // присваиваем состояние ошибки
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)   //если все ок - меняем флаг, который разблокирует кнопку
        }
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
        return password.length > 6
    }
}
