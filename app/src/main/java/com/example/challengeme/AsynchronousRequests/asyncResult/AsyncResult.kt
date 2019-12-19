package com.example.challengeme.AsynchronousRequests.asyncResult

/**
 * Authentication result : success (user details) or error message.
 */

//результат входа (успещный вход, ошибка входа)
// при регистрации: false или true

data class AsyncResult(
    val success: Int? = null,
    val error: Int? = null
)
