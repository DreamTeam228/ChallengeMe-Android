package com.example.challengeme.ui.login

/**
 * Authentication result : success (user details) or error message.
 */

//результат входа (успещный вход, ошибка входа)
// при регистрации: false или true

data class RegistrationResult(
    val success: Int? = null,
    val error: Int? = null
)
