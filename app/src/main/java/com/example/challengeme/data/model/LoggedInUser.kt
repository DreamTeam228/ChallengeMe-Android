package com.example.challengeme.data.model

import com.example.challengeme.User.UserAchievement
import com.example.challengeme.User.UserChallenge

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val id : Int,
    val login: String,
    val password: String,
    val displayName: String,
    val position: String,  //(координаты)
//    val achievementsId: ArrayList<Int>,       // Будет хранится на сервере
//    val challengesId: ArrayList<Int>,
    val userLevel: String,
    val challengeCount: Int, //(количество полученных звёзд)
    val lastChallenge: UserChallenge,
    val lastAchievement: UserAchievement,
    val profilePicture: String

    // как насчет хранить список вполненных челленджей по ID - и по айди можно будет получить информацию о челлендже
    // мб аватарку???
    // о себе
    // Звание ???
    // uuid по которому строится qr

    // Все поля юзера
)
