package com.example.challengeme.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val login: String,
    val password: String

    // Все поля юзера
)
