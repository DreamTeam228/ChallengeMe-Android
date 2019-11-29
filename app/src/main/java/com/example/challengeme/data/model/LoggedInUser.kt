package com.example.challengeme.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val login: String,
    val password: String

    // var displayName: String
    // var position: String (координаты)
    //  val id:
    // var challengeCount: Int (количество пройденных челленджей)

    // как насчет хранить список вполненных челленджей по ID - и по айди можно будет получить информацию о челлендже
    // мб аватарку???
    // о себе
    // Звание ???
    // uuid по которому строится qr

    // Все поля юзера
)
