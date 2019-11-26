package com.example.challengeme.ui.login

/**
 * User details post authentication that is exposed to the UI
 */
data class LoggedInUserView(
    val displayName: String
    //Инфа, которая приходит с сервера (инфа  о пользователе)
    // будет отображаться в профиле
)
