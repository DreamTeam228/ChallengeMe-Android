package com.example.challengeme.ui.login

/**
 * Authentication result : success (user details) or error message.
 */

//результат входа (успещный вход, ошибка входа)
// REMAKE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
data class LoginResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)
