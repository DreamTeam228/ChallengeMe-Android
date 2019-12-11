package com.example.challengeme.data

import com.example.challengeme.AsynchronousRequests.RESTAuthAsyncTask
import com.example.challengeme.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // handle loggedInUser authentication

            val user = checkLogin(username, password)
            return Result.Success(user)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {

    }

    private fun checkLogin (username: String, password: String) : LoggedInUser {
        // Проверяем наличие юзера в базах и правильность пароля
        // ЕСли нет, кидай ошибку (Result.error)
        // если да, собираем сразу юзера LoggedInUser (Result.success)

        val loggedInUser = RESTAuthAsyncTask(
            username,
            password
        ).execute("http://188.225.46.84/json123").get()
        if(loggedInUser == null) {
            throw Exception()
        } else {
            return loggedInUser
        }

    }
}

