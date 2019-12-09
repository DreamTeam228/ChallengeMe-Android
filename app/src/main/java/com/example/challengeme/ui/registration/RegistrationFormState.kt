package com.example.challengeme.ui.login

/**
 * Data validation state of the login form.
 */
// варианты состояний полей ввода
data class RegistrationFormState(
    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val isDataValid: Boolean = false
)


