package com.example.challengeme.data

import com.example.challengeme.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            checkLogin(username, password)
            val fakeUser = LoggedInUser(username, password)
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }

    private fun checkLogin (username: String, password: String) {
        // Проверяем наличие юзера в базах и правильность пароля
        // ЕСли нет, кидай ошибку (Result.error)
        // если да, собираем сразу юзера LoggedInUser (Result.success)
    }
}

